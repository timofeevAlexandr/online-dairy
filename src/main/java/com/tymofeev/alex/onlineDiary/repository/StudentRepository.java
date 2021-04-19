package com.tymofeev.alex.onlineDiary.repository;

import com.tymofeev.alex.onlineDiary.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    Student findById(long id);

}
