package com.sagar.projects.Student.Management.App.services;

import com.sagar.projects.Student.Management.App.entities.Student;

import java.util.List;

public interface StudentService {

    //Student performation

     // save user
     Student saveStudent(Student student);

     //get all Student list
     List<Student> getallStudent();

     // get student by it's id
     Student getStudentById(String id);

     //delete student by it's id
    Student deleteStudentById(String id);

    // update student by it's id
     Student updateById(String id,Student updatedStudent);

}
