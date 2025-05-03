package com.sagar.projects.Student.Management.App.services.impl;

import com.sagar.projects.Student.Management.App.entities.Student;
import com.sagar.projects.Student.Management.App.exceptions.ResourceNotFoundException;
import com.sagar.projects.Student.Management.App.repository.StudentRepository;
import com.sagar.projects.Student.Management.App.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student saveStudent(Student student) {
        String randomStudentid = UUID.randomUUID().toString();
        student.setReg_num(randomStudentid);
        System.out.println("Saving student: " + student);
        studentRepository.save(student);
        return student;
    }


    @Override
    public List<Student> getallStudent() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
      Student student= studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not Found for entered Id"+id));
        return student;
    }

    @Override
    public Student deleteStudentById(String id) {

        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return student;
        }).orElseThrow(() -> new ResourceNotFoundException("Student with RegNum " + id + " not found"));
    }

    @Override
    public Student updateById(String id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student with RegNum " + id + " not found"));
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAdress(updatedStudent.getAdress());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setContact_number(updatedStudent.getContact_number());
        return studentRepository.save(existingStudent);
    }


}
