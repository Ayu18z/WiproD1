# 🍕 Pizzeria – Microservices Pizza Ordering System

A **microservices-based pizza ordering platform** built using **Spring Boot & Spring Cloud**.  
The system allows customers to order food online while enabling administrators to manage menu items, orders, and revenue efficiently.

---

## 🚀 Architecture

This application follows a **Microservices Architecture** where independent services communicate using REST APIs.

### 🔧 Core Technologies
- **Spring Boot** – Microservice development
- **Spring Cloud & Eureka Server** – Service discovery & registration
- **Spring Security + JWT** – Authentication & authorization
- **Spring Data JPA (Hibernate)** – Database operations
- **JavaMail Sender** – Email notifications
- **REST APIs** – Service communication
- **HTML, CSS, Fetch API** – Frontend interface
- **SQL Databases** – Dedicated database per service

---

## 📦 Microservices

| Service | Port | Responsibility |
|--------|------|---------------|
| **User Service** | 8081 | User registration & authentication |
| **Admin Service** | 8082 | Admin controls & menu management |
| **Menu Service** | 8083 | Menu CRUD & filtering |
| **Order Service** | 8084 | Order processing & billing |
| **Message Service** | 8085 | Email notifications |
| **Eureka Server** | 8761 | Service discovery |

---

## 👤 User Features

✔ Register & login  
✔ Browse menu categories  
✔ Add multiple items to cart  
✔ Place & cancel orders  
✔ Payment confirmation  
✔ Receive order updates via email  
✔ View order history & bill  

---

## 👨‍💼 Admin Features

✔ Admin login  
✔ Manage menu items (Create, Update, Delete)  
✔ Accept or reject orders  
✔ Generate bills  
✔ Send notifications to users  
✔ View monthly & date-range revenue reports  

---

## 🔐 Security

- JWT token-based authentication  
- Role-based access control (ADMIN / USER)  
- BCrypt password encryption  
- CORS configuration  
- Secure REST endpoints  

---

## 🔄 Key API Modules

### 🔹 User Service
- User registration & login
- JWT token generation & validation

### 🔹 Menu Service
- Add, update, delete menu items
- Filter by category & price
- Search menu items

### 🔹 Order Service
- Place & cancel orders
- Payment confirmation
- Billing & revenue analytics

### 🔹 Message Service
- Send email notifications for order updates

---

## 🛠️ Setup & Run

### 1️⃣ Start Eureka Server
Run the Eureka server to enable service registration.

### 2️⃣ Configure Databases
Create databases for each microservice and update credentials in `application.properties`.

### 3️⃣ Run Microservices
Start services in the following order:
1. Eureka Server  
2. User Service  
3. Menu Service  
4. Order Service  
5. Message Service  
6. Admin Service  

### 4️⃣ Access Application
Open the frontend in your browser and interact with the system.

---

## 📊 System Highlights

✅ Microservices-based architecture  
✅ Secure JWT authentication  
✅ Email notification system  
✅ Revenue analytics & billing  
✅ Scalable & modular design  

---

## 🔮 Future Enhancements

- Online payment gateway integration  
- Docker containerization  
- Kubernetes deployment  
- API Gateway implementation  
- React-based frontend  
- Cloud deployment  

---

## 👨‍💻 Author

**Ayush Kumar**  
Java Full Stack Developer  

---

⭐ If you like this project, consider giving it a star!
