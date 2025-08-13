package com.sagar.projects.Student.Management.App.entities;

import com.sagar.projects.Student.Management.App.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Admin")
public class Admin {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="id" )
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING) // Store enum as String in DB
    private Role role = Role.ADMIN;


}
