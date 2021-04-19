package com.tymofeev.alex.onlineDiary.controller;

import com.tymofeev.alex.onlineDiary.model.ClassRoom;
import com.tymofeev.alex.onlineDiary.model.Teacher;
import com.tymofeev.alex.onlineDiary.service.ClassRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassRoomController{

    private ClassRoomService service;

    public ClassRoomController(ClassRoomService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClassRoom> getAll(){
        return service.getAll();
    }

    @GetMapping("/{number}")
    //get all teachers by class room number
    public List<Teacher> getTeachersByNumber(@PathVariable Integer number){
        return service.getTeachersByNumber(number);
    }
}