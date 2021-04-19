package com.tymofeev.alex.onlineDiary.repository;

import com.tymofeev.alex.onlineDiary.model.Student;
import com.tymofeev.alex.onlineDiary.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    List<Teacher> findAll();
    List<Teacher> findByLastName(String lastName);
    Teacher findById(long id);

    @Query(value = "select s from Student s JOIN s.teacher t WHERE t.lastName=:teacherLastName")
    List<Student> getStudentsByLastName(@Param("teacherLastName") String lastName);
}
