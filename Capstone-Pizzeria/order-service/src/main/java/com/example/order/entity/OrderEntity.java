package com.example.order.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;  // who placed the order

    @ElementCollection
    private List<Long> itemIds; // list of menu item id

    private Double totalAmount;

    private String status; // pending or cancled

    private LocalDateTime createdAt;
    
    private String paymentStatus;   // paid/non-paid
    private String paymentMethod;   // cod or online

}