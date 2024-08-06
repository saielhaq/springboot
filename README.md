# Prosettings

## Overview
Prosettings is a demo project for managing player settings using Spring Boot. It includes functionalities for creating, updating, deleting, and listing players. The project uses PostgreSQL as the database and Thymeleaf for the front-end.

## Table of Contents
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Endpoints](#endpoints)
- [Configuration](#configuration)
- [License](#license)

## Getting Started
To get a local copy up and running, follow these simple steps.

## Prerequisites
- Java 21
- Maven 3.9.7
- PostgreSQL

## Installation
1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/prosettings.git
    cd prosettings
    ```

2. Configure the database:
    - Create a PostgreSQL database named `prosettings`.
    - Update the database configuration in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/prosettings
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build the project using Maven:
    ```sh
    ./mvnw clean install
    ```

## Running the Application
To run the application, use the following command:
```sh
./mvnw spring-boot:run
```
The application will start and be accessible at `http://localhost:8080/player`.

## Project Structure
The project structure is as follows:
```plaintext
prosettings
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── prosettings
│   │   │               ├── ProsettingsApplication.java
│   │   │               ├── controller
│   │   │               │   └── PlayerController.java
│   │   │               ├── entity
│   │   │               │   └── Player.java
│   │   │               ├── repository
│   │   │               │   └── PlayerRepository.java
│   │   │               └── service
│   │   │                   └── PlayerService.java
│   │   ├── resources
│   │   │   ├── static
│   │   │   │   ├── css
│   │   │   │   │   └── style.css
│   │   │   │   ├── images
│   │   │   │   └── js
│   │   │   │       └── script.js
│   │   │   ├── templates
│   │   │   │   ├── footer.html
│   │   │   │   ├── header.html
│   │   │   │   ├── layout.html
│   │   │   │   └── player.html
│   │   │   └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── prosettings
│                       └── ProsettingsApplicationTests.java
├── pom.xml
```

## Endpoints
The application provides the following endpoints:

- `GET /player`: Lists all players.
- `GET /player/{id}`: Retrieves a player by ID.
- `POST /player`: Creates a new player.
- `PUT /player/{id}`: Updates a player.
- `DELETE /player/{id}`: Deletes a player.


### Database Configuration
The database configuration is managed in `src/main/resources/application.properties`. Key properties include:

- `spring.datasource.url`: JDBC URL of the database
- `spring.datasource.username`: Database username
- `spring.datasource.password`: Database password
- `spring.jpa.hibernate.ddl-auto`: Hibernate schema generation option

Modify these properties to match your database setup. For security, avoid committing sensitive information like passwords to version control.
