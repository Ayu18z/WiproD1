package com.example.order.service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.order.dto.MenuItemDTO;
import com.example.order.dto.UserEmailDTO;
import com.example.order.entity.OrderEntity;
import com.example.order.exception.InvalidInputException;
import com.example.order.exception.ResourceNotFoundException;
import com.example.order.feign.MenuClient;
import com.example.order.feign.UserClient;
import com.example.order.repo.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private MenuClient menuClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private JavaMailSender mailSender;


    public OrderEntity placeOrder(Long userId, List<Long> itemIds, Double totalAmount, String paymentMethod) {

        if (userId == null || itemIds == null || itemIds.isEmpty()) {
            throw new InvalidInputException("User ID and item list are required");
        }

        OrderEntity order = new OrderEntity();
        order.setUserId(userId);
        order.setItemIds(itemIds);
        order.setTotalAmount(totalAmount);
        order.setPaymentMethod(paymentMethod);

        if ("COD".equalsIgnoreCase(paymentMethod)) {
            order.setPaymentStatus("PAID");
            order.setStatus("PENDING");
        } else {
            order.setPaymentStatus("NOT_PAID");
            order.setStatus("PAYMENT_PENDING");
        }

        order.setCreatedAt(LocalDateTime.now());

        return repo.save(order);
    }


    public OrderEntity confirmPayment(Long orderId) {
        OrderEntity order = repo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        if (!"NOT_PAID".equals(order.getPaymentStatus())) {
            throw new InvalidInputException("Payment is already completed");
        }

        order.setPaymentStatus("PAID");
        order.setStatus("PENDING");

        return repo.save(order);
    }



    public OrderEntity cancelOrder(Long orderId) {
        OrderEntity order = repo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        if ("COMPLETED".equals(order.getStatus())) {
            throw new InvalidInputException("Completed orders cannot be cancelled");
        }

        order.setStatus("CANCELLED");
        repo.save(order);

        sendOrderEmail(order.getUserId(), "Order Cancelled",
                "Your order #" + orderId + " has been cancelled.");

        return order;
    }



    public List<OrderEntity> getOrdersByUser(Long userId) {
        return repo.findByUserId(userId);
    }



    public List<OrderEntity> getAllOrders() {
        return repo.findAll();
    }

    public OrderEntity acceptOrder(Long id) {
        OrderEntity order = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        order.setStatus("ACCEPTED");
        repo.save(order);

        sendOrderEmail(order.getUserId(), "Order Accepted",
                "Great news! Your order #" + id + " has been accepted.");

        return order;
    }

    public OrderEntity rejectOrder(Long id) {
        OrderEntity order = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        order.setStatus("REJECTED");
        repo.save(order);

        sendOrderEmail(order.getUserId(), "Order Rejected",
                "Sorry! Your order #" + id + " has been rejected.");

        return order;
    }

    public OrderEntity completeOrder(Long id) {
        OrderEntity order = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        order.setStatus("COMPLETED");
        repo.save(order);

        sendOrderEmail(order.getUserId(), "Order Completed",
                "Your order #" + id + " is ready! Enjoy your pizza 🍕");

        return order;
    }



    public Map<String, Object> generateBill(Long orderId) {

        OrderEntity order = repo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        List<MenuItemDTO> menu = menuClient.getAllMenuItems();

        Map<Long, MenuItemDTO> itemMap = menu.stream()
                .collect(Collectors.toMap(MenuItemDTO::getId, m -> m));

        Map<Long, Integer> qtyMap = new HashMap<>();
        for (Long id : order.getItemIds()) {
            qtyMap.put(id, qtyMap.getOrDefault(id, 0) + 1);
        }

        List<Map<String, Object>> billItems = new ArrayList<>();
        double total = 0;

        for (var entry : qtyMap.entrySet()) {
            MenuItemDTO item = itemMap.get(entry.getKey());

            if (item == null) {
                throw new ResourceNotFoundException("Menu item missing: " + entry.getKey());
            }

            double line = item.getPrice() * entry.getValue();

            Map<String, Object> row = new HashMap<>();
            row.put("name", item.getName());
            row.put("price", item.getPrice());
            row.put("qty", entry.getValue());
            row.put("lineTotal", line);

            billItems.add(row);
            total += line;
        }

        Map<String, Object> bill = new HashMap<>();
        bill.put("orderId", orderId);
        bill.put("userId", order.getUserId());
        bill.put("items", billItems);
        bill.put("total", total);
        bill.put("status", order.getStatus());
        bill.put("createdAt", order.getCreatedAt());

        return bill;
    }


  
          //  revenue part
      

    public Map<String, Object> calculateRevenue(LocalDateTime start, LocalDateTime end) {

        List<OrderEntity> orders = repo.findAll().stream()
                .filter(o -> !"CANCELLED".equals(o.getStatus()))
                .filter(o -> o.getCreatedAt().isAfter(start) && o.getCreatedAt().isBefore(end))
                .toList();

        double total = orders.stream()
                .mapToDouble(OrderEntity::getTotalAmount)
                .sum();

        Map<String, Object> map = new HashMap<>();
        map.put("orders", orders);
        map.put("totalRevenue", total);

        return map;
    }


 //email part

    private void sendOrderEmail(Long userId, String subject, String body) {

        System.out.println("EMAIL STEP → Fetching user email for ID = " + userId);

        UserEmailDTO user = null;

        try {
            user = userClient.getUserById(userId);
            System.out.println("EMAIL: user-service responded → " + user);
        } catch (Exception e) {
            System.out.println("EMAIL ERROR → Feign failed: " + e.getMessage());
            return;
        }

        if (user == null || user.getEmail() == null) {
            System.out.println("EMAIL ERROR → User email is NULL");
            return;
        }

        String to = user.getEmail();
        System.out.println("Sending email to: " + to);

        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(to);
            msg.setSubject(subject);
            msg.setText(body);

            mailSender.send(msg);
            System.out.println("EMAIL SUCCESS → Sent!");
        } catch (Exception e) {
            System.out.println("EMAIL SEND ERROR → " + e.getMessage());
        }
    }
}
