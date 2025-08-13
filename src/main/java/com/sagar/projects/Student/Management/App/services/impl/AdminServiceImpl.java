package com.sagar.projects.Student.Management.App.services.impl;

import com.sagar.projects.Student.Management.App.entities.Admin;
import com.sagar.projects.Student.Management.App.exceptions.ResourceNotFoundException;
import com.sagar.projects.Student.Management.App.repository.AdminRepo;
import com.sagar.projects.Student.Management.App.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Admin getAdminByEmail(String email) {
        Admin admin = adminRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("Admin with Given Email"+email+" not Found"));
        return admin;
    }

    @Override
    public Admin saveAdmin(Admin admin) {

        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword())); // Encode the password
        adminRepo.save(admin);
        return admin;
    }

    @Override
    public List<Admin>getAllAdmin(){
        List<Admin> adminList=adminRepo.findAll();
        return adminList;
    }
}
