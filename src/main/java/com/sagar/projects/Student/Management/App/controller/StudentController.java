package com.sagar.projects.Student.Management.App.controller;

import com.sagar.projects.Student.Management.App.entities.Student;
import com.sagar.projects.Student.Management.App.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
   private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent (@RequestBody Student student){
          Student student1 = studentService.saveStudent(student);
          return ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }

    @GetMapping
   public ResponseEntity<List<Student>> getAllStudent(){
       List<Student>students= studentService.getallStudent();
       return ResponseEntity.ok(students);
   }

    @GetMapping("/{id}")
   public ResponseEntity<Student> getByStudentId(@PathVariable String id){
     Student student = studentService.getStudentById(id);
return ResponseEntity.ok(student);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Student>deleteByStudentId(@PathVariable String id){
       Student student = studentService.deleteStudentById(id);
        return ResponseEntity.ok(student);
   }

   @PatchMapping("/{id}")
   public ResponseEntity<Student>updateByStudentId(@PathVariable String id,@RequestBody Student existingStudent){
       Student student= studentService.updateById(id,existingStudent);
       return ResponseEntity.ok(student);
    }

}
