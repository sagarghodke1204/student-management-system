package com.sagar.projects.Student.Management.App.repository;

import com.sagar.projects.Student.Management.App.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin,String> {

    Optional<Admin> findByEmail(String email);
}
