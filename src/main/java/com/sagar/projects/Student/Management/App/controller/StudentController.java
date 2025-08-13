package com.sagar.projects.Student.Management.App.controller;

import com.sagar.projects.Student.Management.App.entities.Student;
import com.sagar.projects.Student.Management.App.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
   private StudentService studentService;

    @PostMapping("/post")
    public ResponseEntity<Student> saveStudent (@RequestBody Student student){
          Student student1 = studentService.saveStudent(student);
          return ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }

    @GetMapping("/get")
   public ResponseEntity<List<Student>> getAllStudent(){
       List<Student>students= studentService.getallStudent();
       return ResponseEntity.ok(students);
   }

    @GetMapping("admin/{id}")
   public ResponseEntity<Student> getByStudentId(@PathVariable String id){
     Student student = studentService.getStudentById(id);
return ResponseEntity.ok(student);
   }

   @DeleteMapping("admin/{id}")
   public ResponseEntity<Student>deleteByStudentId(@PathVariable String id){
       Student student = studentService.deleteStudentById(id);
        return ResponseEntity.ok(student);
   }

   @PatchMapping("admin/{id}")
   public ResponseEntity<Student>updateByStudentId(@PathVariable String id,@RequestBody Student existingStudent){
       Student student= studentService.updateById(id,existingStudent);
       return ResponseEntity.ok(student);

    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>>login(@RequestBody Map<String,String>logindata){
        String email=logindata.get("email");
        String password=logindata.get("password");

        Student student =studentService.getStudentByEmail(email);

        // getting email from data base and checking whether it present .
        if(student == null){
            Map<String,Object> errorReponse = new HashMap<>();
            errorReponse.put("message","Invalid Credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorReponse);
        }

        // Password checking .
        if (BCrypt.checkpw(password, student.getPassword())) {
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("message", "Login successful!");
            return ResponseEntity.ok().body(successResponse);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Invalid credentials.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<Student> getStudentDetails(@RequestParam String email) {
        try {
            Student student = studentService.getStudentByEmail(email);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
