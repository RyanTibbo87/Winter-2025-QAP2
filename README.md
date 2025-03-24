# ⛳ Golf Club Tournament & Membership API

🔗 GitHub Repository: [Winter-2025-QAP2](https://github.com/RyanTibbo87/Winter-2025-QAP2)

A RESTful API built with **Spring Boot** for managing members and tournaments at a golf club. The application uses **MySQL** for data persistence and is containerized using **Docker Compose** for easy setup and deployment.

---

## 🚀 Features

- Manage **Golf Club Members** (CRUD)
- Manage **Tournaments** (CRUD)
- Register members for tournaments
- **Search** members and tournaments by different fields
- API tested using **Postman**
- Dockerized for smooth local development

---

## 🧱 Tech Stack

- Java 17 / Spring Boot 3
- Spring Data JPA / Hibernate
- MySQL 8
- Docker / Docker Compose
- Postman

---

## 🐳 How to Run the Project in Docker

> 💡 **Details in the project readme about the supported search APIs and how to run project in docker.**

### 1. Clone the repository

```
git clone https://github.com/RyanTibbo87/Winter-2025-QAP2.git
cd Winter-2025-QAP2

2. Start the containers

docker compose up --build

3. Access the services

API → http://localhost:8080

MySQL → localhost:3306

MySQL credentials:

Username: root

Password: root

Database: golfclub

🔍 Supported Search APIs
📁 Member Search Endpoints
GET /api/members
→ List all members

GET /api/members/search?name=John
→ Search members by name

GET /api/members/search?email=john@example.com
→ Search members by email

🏆 Tournament Search Endpoints
GET /api/tournaments
→ List all tournaments

GET /api/tournaments/search?name=Spring Open
→ Search tournaments by name

GET /api/tournaments/search?location=London
→ Search tournaments by location


