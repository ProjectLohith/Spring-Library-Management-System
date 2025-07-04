# ✅ Library Management System – Spring Boot-Based Scalable Backend Application
This is a full-fledged, scalable Library Management System built using Spring Boot, showcasing enterprise-level design principles with features like layered architecture, DTO mapping, custom repositories, exception handling, and Redis integration.

**🔍 Key Features:**

📚 CRUD operations for books, users, authors, and transactions.

✅ Custom business logic for borrowing/returning books, along with transaction status tracking using enums.

🔄 Role-based access & user types (e.g., Student, Faculty) implemented via enums for fine-grained control.

🔐 Integrated custom annotation-based logging using Spring AOP (@LogAnnotation) for transparent request logging.

🧩 Modular layers: controller, service, DTO, mapper, and repository for clean separation of concerns.

**🧠 Advanced Spring Features Used:**

💡 Aspect-Oriented Programming (AOP) for cross-cutting concerns like logging.

🛠️ Custom Repositories (CustomBookRepository, CustomBookRepositoryImpl) for complex DB queries.

🧾 Exception Handling via centralized @ControllerAdvice.

⚙️ Redis Integration (RedisDataRepository) for caching and high-speed access to book/user data.

🧱 DTOs and Mappers to decouple domain logic from request/response payloads and enhance maintainability.

**🛠 Tech Stack:**

Backend: Java, Spring Boot, Spring AOP, Spring Data JPA

Database: MySQL (or PostgreSQL)

Caching: Redis

Build Tool: Maven

Other: Lombok, JPA, SLF4J, Swagger (if added), RESTful APIs

**📁 Project Structure Highlights:**

controller/ → REST endpoints for books, users, transactions

dto/ → Clean input contracts for POST requests

mapper/ → Entity-DTO transformation logic

repository/ → Standard & custom JPA repositories + Redis

enums/ → Book types, transaction status, user roles

annotations/ + service/CustomAspect.java → Logging AOP

exceptions/ → Custom domain exceptions

resources/application.properties → Configuration
