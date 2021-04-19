package com.tymofeev.alex.onlineDiary.controller;

import com.tymofeev.alex.onlineDiary.model.Student;
import com.tymofeev.alex.onlineDiary.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController{

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/{lastName}")
    //get all students by last name
    public List<Student> getByLastName(@PathVariable String lastName){
        return service.getByLastName(lastName);
    }
}