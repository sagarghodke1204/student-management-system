Student Management System 🎓
This is a basic Student Management System built using Spring Boot. It allows an Admin to perform CRUD operations (Create, Read, Update, Delete) on student records. The application is designed for learning and improving backend development skills with Spring Boot and Java.

📖 Table of Contents
Features

Technologies Used

Getting Started

Prerequisites

Installation

Running the Application

Contributing

License

Contact

🛠️ Features
Add new student records

View all student details

Update student information

Delete student records

Secure role-based login for Admin and Student

Session-based authentication using Spring Security

MVC architecture with Thymeleaf

Spring Boot with JPA and Hibernate

🧰 Tech Stack
Java 17

Spring Boot

Spring Security

Spring MVC

Spring Data JPA

Thymeleaf

MySQL (or H2 for in-memory database)

Maven (Project management)

Lombok (for cleaner code)

📁 Project Structure
student-management-system/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.example.studentmanagement/
│ │ │ ├── config/       # Spring Security Configuration
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ └── service/
│ │ └── resources/
│ │ ├── templates/
│ │ └── application.properties
└── pom.xml

⚙️ Getting Started
Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
Before you begin, ensure you have the following installed:

Java Development Kit (JDK) 17

Git

Maven (or an IDE like IntelliJ IDEA with Maven support)

MySQL Server

Installation
Clone the repository:

git clone https://github.com/sagarghodke1204/student-management-system.git
cd student-management-system

Configure your database in application.properties:

Create a MySQL database (e.g., student_db).

Update the connection details in the src/main/resources/application.properties file:

spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Running the Application
Build and run the project:

In IntelliJ IDEA: Open the project and run the StudentManagementSystemApplication.java class.

Or via terminal:

mvn spring-boot:run

Access the app:

Open your browser and go to: http://localhost:8081/

🤝 Contributing
Contributions are welcome! If you have suggestions for improvements or new features, please follow these steps:

Fork the repository.

Create a new branch (git checkout -b feature/AmazingFeature).

Make your changes.

Commit your changes (git commit -m 'Add some AmazingFeature').

Push to the branch (git push origin feature/AmazingFeature).

Open a Pull Request.

📜 License
This project is licensed under the MIT License.

📧 Contact
Sagar Ghodke

GitHub: https://github.com/sagarghodke1204

Project Link: https://github.com/sagarghodke1204/student-management-system
