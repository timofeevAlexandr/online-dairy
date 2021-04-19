package com.tymofeev.alex.onlineDiary.service;

import com.tymofeev.alex.onlineDiary.model.Student;
import com.tymofeev.alex.onlineDiary.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll(){
        return repository.findAll();
    }
    public List<Student> getByLastName(String lastName){
        return repository.findByLastName(lastName);
    }
    public Student getById(long id){
        return repository.findById(id);
    }
}
