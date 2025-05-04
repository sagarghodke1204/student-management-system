# Student Management System 🎓

This is a basic **Student Management System** built using **Spring Boot**. It allows Admin to perform CRUD operations (Create, Read, Update, Delete) on student records. The application is designed for learning and improving backend development skills with Spring Boot and Java.

## 🛠️ Features

- Add new student records
- View all student details
- Update student information
- Delete student records
- MVC architecture with Thymeleaf 
- Spring Boot with JPA and Hibernate

## 🧰 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf** (if UI is included)
- **MySQL** (or H2 for in-memory database)
- **Maven** (Project management)
- **Lombok** (for cleaner code)

## 📁 Project Structure
student-management-system/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.example.studentmanagement/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ └── service/
│ │ └── resources/
│ │ ├── templates/
│ │ └── application.properties
└── pom.xml


## 🧪 How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/sagarghodke1204/student-management-system.git
   cd student-management-system
   
2.Configure your database in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3.Build and run the project
In IntelliJ IDEA: Open the project and run the StudentManagementSystemApplication.java class.
Or via terminal:
bash :
mvn spring-boot:run

4.Access the app:
Open browser and go to: http://localhost:8081/

![image](https://github.com/user-attachments/assets/38ef40c2-a60e-46c9-9c0d-3c4098b1b407)

when you click on Login as Student:
![image](https://github.com/user-attachments/assets/bd4f625b-c466-4a34-87d4-22666f6b9488)

when you click on Login as Admin
![image](https://github.com/user-attachments/assets/5dd6bff7-2e02-46bf-9795-6df1f7d2457a)

when click on Register As Student
![image](https://github.com/user-attachments/assets/9effb8fe-1380-4096-b875-708f8d19b824)

When you will be Logged in As Admin
![image](https://github.com/user-attachments/assets/ca4f9cb1-d121-4951-9a0c-0b745cc61854)








