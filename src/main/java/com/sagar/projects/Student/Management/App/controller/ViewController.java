package com.sagar.projects.Student.Management.App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

      @GetMapping("/")
      public String homepage(){
          return "homepage";
      }

      @GetMapping("/register-student")
      public String registerStudent(){
          return "register-student";
      }


     @GetMapping("/home")
     public String home(){
         return "Home";
     }

    @GetMapping("/add-student")
    public String addStudent(){
        return "add-student";
    }

    @GetMapping("/view-students")
    public String viewStudent(){
        return "view-students";
    }

    @GetMapping("/delete-student")
    public String deleteStudent(){
        return "delete-student";
    }

    @GetMapping("/update-student")
    public String updateStudent(){
        return "update-student";
    }

    @GetMapping("/Search")
    public String searchStudent(){
        return "Search";
    }

}
