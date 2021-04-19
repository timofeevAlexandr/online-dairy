package com.tymofeev.alex.onlineDiary.service;

import com.tymofeev.alex.onlineDiary.model.Student;
import com.tymofeev.alex.onlineDiary.model.Teacher;
import com.tymofeev.alex.onlineDiary.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<Teacher> getAll(){
        return repository.findAll();
    }
    public List<Teacher> getByLastName(String lastName){
        return repository.findByLastName(lastName);
    }

    public List<Student> getStudentsByLastName(String lastName) {
        return repository.getStudentsByLastName(lastName);
    }
}
