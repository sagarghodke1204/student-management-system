package com.sagar.projects.Student.Management.App.repository;

import com.sagar.projects.Student.Management.App.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,String> {

    Optional<Student> findByEmail(String email);
}
