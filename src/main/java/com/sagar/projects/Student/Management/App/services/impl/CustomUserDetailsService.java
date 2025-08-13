package com.sagar.projects.Student.Management.App.services.impl;

import com.sagar.projects.Student.Management.App.entities.Admin;
import com.sagar.projects.Student.Management.App.entities.Student;
import com.sagar.projects.Student.Management.App.exceptions.ResourceNotFoundException;
import com.sagar.projects.Student.Management.App.repository.AdminRepo;
import com.sagar.projects.Student.Management.App.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Student>studentOptional= studentRepository.findByEmail(email);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            return User.builder()
                    .username(student.getEmail())
                    .password(student.getPassword())
                    .roles(student.getRole().name())
                    .build();
        }


        Optional<Admin> adminOptional = adminRepo.findByEmail(email);
        if(adminOptional.isPresent()){
            Admin admin = adminOptional.get();
            return User.builder()
                    .username(admin.getEmail())
                    .password(admin.getPassword())
                    .roles(admin.getRole().name())
                    .build();
        }

        throw new ResourceNotFoundException("User not found with" +email+" this email");

    }
}
