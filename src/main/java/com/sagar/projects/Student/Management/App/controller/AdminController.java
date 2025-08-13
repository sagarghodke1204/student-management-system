package com.sagar.projects.Student.Management.App.controller;

import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.sagar.projects.Student.Management.App.entities.Admin;
import com.sagar.projects.Student.Management.App.services.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
   private AdminServiceImpl adminService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    ResponseEntity<List<Admin>>getAllAdmin(){
        List<Admin> adminList = adminService.getAllAdmin();
        return ResponseEntity.ok(adminList);
    }

    @PostMapping("/post")
    ResponseEntity<Admin>saveAdmin(@RequestBody Admin admin){
        Admin admin1 = adminService.saveAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin1);
    }

    @GetMapping("/{email}")
    ResponseEntity<Admin>getAdminByEmail(@PathVariable String email){
        Admin admin = adminService.getAdminByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Admin admin = adminService.getAdminByEmail(email);

        if (admin != null && bCryptPasswordEncoder.matches(password, admin.getPassword())) {
            return ResponseEntity.ok().build(); // Login successful
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid email or password"));
        }
    }




}
