package com.sagar.projects.Student.Management.App.services;

import com.sagar.projects.Student.Management.App.entities.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {

    Admin getAdminByEmail(String email);

    List<Admin>getAllAdmin();

    Admin saveAdmin(Admin admin);

}
