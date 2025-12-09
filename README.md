# 🍕 Capstone Project - Pizzeria

This project is a microservice-based pizza ordering system.  
It consists of the following services running locally:

| Microservice       | Port  |
|--------------------|-------|
| Admin Service      | 8082  |
| Eureka Server      | 8761  |
| Menu Service       | 8083  |
| Message Service    | 8085  |
| Order Service      | 8084  |
| User Service       | 8081  |

---

## Overview

Pizzeria allows users to browse menu items, place orders, and receive notifications.  
There are **two types of users**:

- **Admin**
- **Customer**

---

## Admin Features

- Login & Logout
- Manage Menu Items (CRUD)
- Accept/Reject Orders
- Send notifications/messages to users
- Generate bills for orders
- View monthly revenue

---

## User Features

- Register, Login & Logout
- Browse menu categories (pizza, sides, beverages, combos, etc.)
- Add multiple items to cart
- Place / Cancel Orders
- Receive order status updates
- View bill & payment options
- Select delivery mode

---

## Technology Stack

- Spring Boot
- Microservices Architecture
- Eureka Discovery Server
- Spring Cloud Config
- Sql (per service)
- JWT Authentication & Security
- HTML, CSS (Front-end)
- Fetch API for integration

---

