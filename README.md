# Task Management API (Spring Boot • JPA • DTO Architecture)

A professional RESTful backend API built using **Spring Boot**, **Spring Data JPA (Hibernate)**, and **PostgreSQL** to manage tasks efficiently.

This project follows an **industry-level layered architecture** using DTOs, Mapper pattern, Validation, Global Exception Handling, Pagination, Logging, and API Versioning.

This is my **third Spring Boot mini project**, focused on building production-style backend APIs.

---

## ✨ Features

### ✅ Core CRUD Operations

* Create new task
* Get all tasks (Pagination supported)
* Update task (PUT)
* Partial update task (PATCH)
* Delete task

### ✅ Advanced Backend Features

* DTO-based architecture (Request & Response separation)
* Mapper pattern for Entity ↔ DTO conversion
* Enum-based task status and priority
* API Versioning (`/api/v1`)
* Logging using SLF4J
* Clean REST responses using ResponseEntity
* Custom exception handling

### ✅ Validation & Error Handling

* Jakarta Validation annotations (`@NotBlank`, `@NotNull`, etc.)
* Global Exception Handler using `@RestControllerAdvice`
* Structured validation error responses

### ✅ Pagination & Filtering

* Pagination using Spring Data Pageable
* Filter tasks by status using query parameters

---

## 🛠️ Tech Stack

* Java
* Spring Boot (Spring Web)
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven
* Lombok
* Jakarta Validation

---

## 🧱 Architecture

This project follows a clean layered architecture:

* **Controller Layer** – Handles REST endpoints
* **Service Layer** – Business logic & logging
* **Repository Layer** – Database interaction (JPA)
* **DTO Layer** – Request & Response models
* **Mapper Layer** – Entity to DTO conversion
* **Exception Layer** – Centralized error handling

```
Controller → DTO → Mapper → Service → Repository → Database
```

---

## 🔗 API Endpoints

Base URL:

```
/api/v1/tasks
```

### Core Endpoints

* `POST /api/v1/tasks` → Create task
* `GET /api/v1/tasks` → Get all tasks (pagination supported)
* `PUT /api/v1/tasks/{id}` → Full update
* `PATCH /api/v1/tasks/{id}` → Partial update
* `DELETE /api/v1/tasks/{id}` → Delete task

### Additional

* `GET /api/v1/tasks/status?value=TODO` → Get tasks by status

---

## 🧪 Testing

All endpoints tested using **Postman**.

---

## 📸 Screenshots

* Postman request/response screenshots
  
* Database table screenshots

Example:

```
![Postman Screenshot](PASTE_IMAGE_LINK_HERE)
```

---

## 🚀 How to Run

1. Clone the repository
2. Configure database in `application.properties`
3. Run Spring Boot application
4. Test APIs using Postman

---

## 👨‍💻 Author

**Ganning Joel J**
Java Backend Developer | Aspiring Java Full Stack Developer

Projects Progression:

* Student Management System (JDBC)
* Student Management System (JPA)
* Task Management API (DTO Architecture)
