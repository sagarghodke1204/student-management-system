    package com.sagar.projects.Student.Management.App.entities;

    import com.sagar.projects.Student.Management.App.enums.Role;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Table(name = "Student_info")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long reg_num;

        private String name;

        private long contact_number;

        private String address;

        private String email;

        private String password;

        @Enumerated(EnumType.STRING) // Store enum as String in DB
        private Role role = Role.STUDENT;

    }
