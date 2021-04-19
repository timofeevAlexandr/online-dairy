package com.tymofeev.alex.onlineDiary.repository;

import com.tymofeev.alex.onlineDiary.model.ClassRoom;
import com.tymofeev.alex.onlineDiary.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRoomRepository extends CrudRepository<ClassRoom, Long> {

    List<ClassRoom> findAll();
    ClassRoom findById(long id);

    @Query(value = "select t from Teacher t JOIN t.classRoom c WHERE c.number=:classRoomNumber")
    List<Teacher> getTeachersByNumber(@Param("classRoomNumber") Integer number);
}