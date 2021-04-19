package com.tymofeev.alex.onlineDiary.controller;

import com.tymofeev.alex.onlineDiary.model.Student;
import com.tymofeev.alex.onlineDiary.model.Teacher;
import com.tymofeev.alex.onlineDiary.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController{

    private TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public List<Teacher> getAll(){
        return service.getAll();
    }

    @GetMapping("/{lastName}")
    //get all teachers by last name
    public List<Teacher> getByLastName(@PathVariable String lastName){
        return service.getByLastName(lastName);
    }

    @GetMapping("/getStudents/{lastName}")
    //get all students by teacher last name
    public List<Student> getStudentsByLastName(@PathVariable String lastName){
        return service.getStudentsByLastName(lastName);
    }
}
