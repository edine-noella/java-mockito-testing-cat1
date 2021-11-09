package com.example.junittest.controllers;


import com.example.junittest.models.Student;
import com.example.junittest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get-all")
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student){
        return studentService.createStudent(student.getNames(), student.getGender(), student.getId());
    }
}
