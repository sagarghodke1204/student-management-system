package com.sagar.projects.Student.Management.App.repository;

import com.sagar.projects.Student.Management.App.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {
}
