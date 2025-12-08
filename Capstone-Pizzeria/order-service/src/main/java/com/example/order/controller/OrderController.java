package com.example.order.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.order.entity.OrderEntity;
import com.example.order.exception.InvalidInputException;
import com.example.order.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService service;

   

    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestBody Map<String, Object> data) {

        Long userId = Long.valueOf(data.get("userId").toString());

        @SuppressWarnings("unchecked")
        List<Integer> itemIdsInt = (List<Integer>) data.get("itemIds");
        List<Long> itemIds = itemIdsInt.stream().map(Long::valueOf).toList();

        Double totalAmount = Double.valueOf(data.get("totalAmount").toString());

        String paymentMethod =
                data.get("payment") != null ? data.get("payment").toString() : "COD";

        return service.placeOrder(userId, itemIds, totalAmount, paymentMethod);
    }




    @PutMapping("/payment/confirm/{orderId}")
    public OrderEntity confirmPayment(@PathVariable Long orderId) {
        return service.confirmPayment(orderId);
    }

    @PutMapping("/cancel/{id}")
    public OrderEntity cancelOrder(@PathVariable Long id) {
        return service.cancelOrder(id);
    }

    @GetMapping("/user/{userId}")
    public List<OrderEntity> getOrdersByUser(@PathVariable Long userId) {
        return service.getOrdersByUser(userId);
    }



    @GetMapping("/all")
    public List<OrderEntity> getAllOrders() {
        return service.getAllOrders();
    }

    @PutMapping("/accept/{id}")
    public OrderEntity acceptOrder(@PathVariable Long id) {
        return service.acceptOrder(id);
    }

    @PutMapping("/reject/{id}")
    public OrderEntity rejectOrder(@PathVariable Long id) {
        return service.rejectOrder(id);
    }

    @PutMapping("/complete/{id}")
    public OrderEntity completeOrder(@PathVariable Long id) {
        return service.completeOrder(id);
    }



    @GetMapping("/bill/{orderId}")
    public Map<String, Object> getBill(@PathVariable Long orderId) {
        return service.generateBill(orderId);
    }


 

    @GetMapping("/revenue/monthly")
    public Map<String, Object> getMonthlyRevenue(@RequestParam String month) {

        LocalDateTime start = LocalDateTime.parse(month + "-01T00:00:00");
        LocalDateTime end = start.plusMonths(1).minusSeconds(1);

        return service.calculateRevenue(start, end);
    }

    @GetMapping("/revenue/range")
    public Map<String, Object> getRevenueBetween(
            @RequestParam String start,
            @RequestParam String end) {

        LocalDateTime s = LocalDateTime.parse(start + "T00:00:00");
        LocalDateTime e = LocalDateTime.parse(end + "T23:59:59");

        return service.calculateRevenue(s, e);
    }
}
