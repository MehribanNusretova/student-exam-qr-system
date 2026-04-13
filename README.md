📚 Student Exam Management System
📌 Overview

This project is a backend system developed for managing student exam processes.
It allows students to register, log in, and receive a QR code for exam participation.

The main goal of this project is to simulate a real-world exam registration and verification system.

🚀 Features
Student registration
Secure login with password encryption
QR code generation for exam access
Database integration using JPA
Layered architecture (Controller, Service, Repository)
🏗️ Project Structure

The project follows a layered architecture:

Controller → Handles incoming HTTP requests
Service → Contains business logic
Repository → Manages database operations
Entity → Represents database tables
🔐 Security
Passwords are encrypted using a password encoder
Plain text passwords are not stored in the database
Authentication logic is implemented during login
🔄 Application Flow
Student registers → data is saved to database
Password is encrypted before storing
Student logs in → credentials are validated
QR code is generated for exam participation
📊 Technologies Used
Java
Spring Boot
Spring Data JPA
Spring Security
MySQL (or your DB)
Maven
🎯 Purpose

This project was developed as part of a learning process to understand backend development concepts such as authentication, database relationships, and real-life system simulation.

⚠️ Challenges Faced
Handling password encryption and login validation
Managing relationships between entities
Ensuring data consistency in database operations
💡 Future Improvements
Add QR code scanning functionality
Implement role-based authentication (Admin/Student)
Improve validation and error handling
👩‍💻 Author

Mehriban Nusretova
GitHub: https://github.com/MehribanNusretova
