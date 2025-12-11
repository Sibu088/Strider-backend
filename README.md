Strider — Backend API<img width="1900" height="960" alt="image" src="https://github.com/user-attachments/assets/30966862-fc51-46a9-9efc-22d5ee7065ee" />


A clean and lightweight Spring Boot REST API for the Strider project.
Includes Swagger UI, PostgreSQL, and full Docker support for easy local development and deployment.

📌 Features

RESTful API built with Spring Boot

Swagger UI for automatic API documentation

PostgreSQL database integration

Dockerfile + Docker Compose for smooth containerization

Simple controller + service + repository structure

No authentication (public API)

🛠️ Tech Stack

Java 17+

Spring Boot 3.x

Spring Web

Spring Data JPA

PostgreSQL

Springdoc OpenAPI (Swagger UI)

Docker & Docker Compose

Maven

🚀 Getting Started (Local – IntelliJ)
1️⃣ Clone the project
git clone https://github.com/your-username/strider-backend.git
cd strider-backend

2️⃣ Open in IntelliJ

File → Open → select the project folder

IntelliJ will auto-import the Maven dependencies

3️⃣ Configure database

Create a local PostgreSQL instance OR use Docker Compose (recommended).
Set your database values in:

src/main/resources/application.yml

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/striderdb
    username: strider
    password: strider123
  jpa:
    hibernate:
      ddl-auto: update

4️⃣ Run the app

Using IntelliJ run button, or:

./mvnw spring-boot:run

5️⃣ Open Swagger UI
http://localhost:8080/swagger-ui/index.html

🐳 Running With Docker
1. Build the project
./mvnw clean package -DskipTests

2. Build Docker image
docker build -t strider-backend:latest .

3. Run using Docker
docker run -p 8080:8080 strider-backend:latest

🐳 Docker Compose (Backend + PostgreSQL)

Create a docker-compose.yml in the project root:

version: "3.8"

services:
  db:
    image: postgres:15
    environment:
      POSTGRES_USER: strider
      POSTGRES_PASSWORD: strider123
      POSTGRES_DB: striderdb
    ports:
      - "5432:5432"
    volumes:
      - db-data:/var/lib/postgresql/data

  backend:
    build: .
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/striderdb
      SPRING_DATASOURCE_USERNAME: strider
      SPRING_DATASOURCE_PASSWORD: strider123
    ports:
      - "8080:8080"

volumes:
  db-data:


Start both services:

docker-compose up --build

📚 Swagger Documentation

Springdoc automatically exposes the API docs.

Swagger UI →
http://localhost:8080/swagger-ui/index.html

OpenAPI JSON →
http://localhost:8080/v3/api-docs

OpenAPI YAML →
http://localhost:8080/v3/api-docs.yaml

Make sure your pom.xml contains:

<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.5.0</version>
</dependency>

🧪 Example API Endpoints

Example ProjectController would expose endpoints like:

GET    /api/projects
GET    /api/projects/{id}
POST   /api/projects
PUT    /api/projects/{id}
DELETE /api/projects/{id}


You can test them directly in Swagger UI.

📦 Build for production
./mvnw clean package


The resulting JAR will be inside target/.

🐞 Troubleshooting
Issue	Solution
App can't connect to DB	Ensure Postgres is running or check your DB URL/credentials
Swagger UI not showing	Check springdoc dependency and app port
Port 8080 already in use	Change server.port in application.yml
Docker DB resets	Use a named volume (already included)
