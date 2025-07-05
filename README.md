# 📚 Library Management System – High-Level Project Overview
This project is a **Spring Boot-based backend application** that powers a **Library Management System**. It is designed to manage the core operations of a library such as handling users, books, authors, and transactions in a clean, modular, and scalable way.

The system is built using Java, following a layered architecture with separate components for controllers, services, repositories, DTOs, mappers, and models. The project demonstrates how real-world backend applications are structured and secured using modern Spring ecosystem tools.

<br>

### **✅ Features:**

**🧾 User Management:** Add and manage library users (e.g., Students, Admins) with status and role control.

**📘 Book & Author Management:** Handles adding, updating, and tracking books and authors with metadata and relationships.

**🔄 Transaction System:** Issue and return books with proper transaction tracking (e.g., ISSUED, RETURNED).

**🔐 Role-Based Security:** Access control for sensitive endpoints using Spring Security (e.g., only STUDENT can issue, ADMIN can return).

**🧠 Custom Logging:** Logs important actions using annotation-based AOP with @LogAnnotation.

**🚨 Exception Handling:** Centralized error handling via @ControllerAdvice for consistent API responses.

**⚡ Caching with Redis:** Caches frequently accessed data like books and users to enhance performance.

**✅ Input Validation:** Ensures reliable and clean input data using spring-boot-starter-validation.

**🧪 Testing Support:** Supports unit and integration testing with Spring Boot Test and JUnit.

**📁 Layered Architecture:** Clean modular design using Controllers, Services, DTOs, Mappers, Repositories, and Enums.

<br>

### **🛠 Tech Stack:**

**🧑‍💻 Language:** Java 21

**⚙️ Framework:** Spring Boot

**🛢 Database:** MySQL (Primary), H2 (In-memory for local/testing)

**🔗 ORM:** Spring Data JPA

**🔐 Security:** Spring Security (Role-based access control)

**⚡ Caching:** Redis (via Spring Data Redis)

**🔧 Build Tool:** Maven

**📦 Others:** Lombok, Bean Validation, Spring Boot Test, JUnit

<br>

### 📁 Codebase Structure (High-Level Overview)

The project follows a clean layered architecture, ensuring separation of concerns, maintainability, and scalability — aligned with industry best practices for Spring Boot backend applications.

| Module/Package              | Purpose                                                                                      |
|----------------------------|----------------------------------------------------------------------------------------------|
| `controller/`              | Contains all REST API endpoints for users, books, authors, and transactions.                |
| `dto/`                     | Defines request models used for clean data transfer between client and server.     |
| `model/`                   | Represents the core domain entities like Book, User, Transaction, and Author.               |
| `repository/`              | Interfaces for database access using Spring Data JPA, including custom repositories and Redis integration. |
| `service/`                 | Implements business logic, Redis configuration, Spring Security, and custom AOP logic.       |
| `mapper/`                  | Converts between DTOs and entity models to keep layers decoupled.                           |
| `exceptions/`              | Houses custom exception classes.                              |
| `enums/`                   | Defines constants for types, roles, and status codes used across the application.            |
| `annotations/`             | Includes custom annotations like `@LogAnnotation` for aspect-oriented logging.               |
| `resources/`               | Configuration files including `application.properties` for DB, Redis, and app settings.      |
| `SpringMinorApplication.java` | Entry point of the Spring Boot application.                                                |


<br>

### **🎯 What This Project Demonstrates**

* 🚀 Backend API Development: Built scalable RESTful APIs using Spring Boot following industry-standard practices.
* 🔗 Spring Ecosystem Proficiency: Integrated core Spring modules including Spring Security, Spring AOP, Spring Data JPA, Redis, and Validation.
* 🏗 Clean Architecture: Applied layered architecture with Controllers, Services, Repositories, DTOs, Mappers, and Exception handling.
* 🧠 Advanced Concepts: Implemented custom annotations, role-based access, transaction workflows, and Redis caching to simulate real production systems.
* ⚙️ Real-World Backend Design: Structured the project to be modular, extensible, and testable — reflecting enterprise-grade backend engineering principles.
* ✅ Modern Java Development: Built using Java 21, following modern coding conventions and leveraging latest language features where applicable.

