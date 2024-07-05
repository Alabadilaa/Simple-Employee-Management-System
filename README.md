# Employee Management System (EMS)

## Introduction

A simple CRUD application for managing employee records using Spring Boot for the backend and React for the frontend.

## Features

- Create, Read, Update, and Delete (CRUD) employees
- List all employees
- Responsive UI

## Technologies

- **Backend:** Java, Spring Boot, JPA, MySQL
- **Frontend:** React, Axios, Bootstrap

## Setup

### Backend

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/employee-management-system.git
    cd employee-management-system/backend
    ```

2. Configure the database:
    - Make sure you have MySQL or another SQL database running.
    - Update your `application.properties` file with your database details:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/yourdbname
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build and run the Spring Boot application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### Frontend

1. Navigate to the frontend directory:
    ```bash
    cd ../frontend
    ```

2. Install dependencies and start the React app:
    ```bash
    npm install
    npm start
    ```

3. Open `http://localhost:3000` in your browser.

## Project Structure

```plaintext
employee-management-system/
├── backend/    # Spring Boot backend
│   ├── src/main/java/net/firstspring/ems_backend/
│   │   ├── controller/   # REST controllers
│   │   ├── dto/          # Data Transfer Objects
│   │   ├── entity/       # JPA entities
│   │   ├── mapper/       # Mapper classes for converting between entities and DTOs
│   │   ├── repository/   # JPA repositories
│   │   ├── service/      # Service interfaces and implementations
│   │   └── EmsBackendApplication.java  # Main application class
│   ├── src/main/resources/
│   │   ├── application.properties   # Application configuration
│   │   └── schema.sql               # Initial database schema (optional)
│   └── pom.xml  # Maven configuration
├── frontend/   # React frontend
│   ├── public/
│   ├── src/
│   │   ├── components/  # React components
│   │   │   ├── Employee/
│   │   │   ├── Footer/
│   │   │   ├── Header/
│   │   │   ├── ListEmployees/
│   │   ├── service/  # Services for API calls
│   │   │   ├── employeeService/
│   ├── package.json
│   └── README.md
└── README.md   # Project README
