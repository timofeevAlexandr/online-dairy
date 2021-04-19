package com.tymofeev.alex.onlineDiary.service;

import com.tymofeev.alex.onlineDiary.model.ClassRoom;
import com.tymofeev.alex.onlineDiary.model.Teacher;
import com.tymofeev.alex.onlineDiary.repository.ClassRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {

    private ClassRoomRepository repository;

    public ClassRoomService(ClassRoomRepository repository) {
        this.repository = repository;
    }

    public List<ClassRoom> getAll(){
        return repository.findAll();
    }
    public List<Teacher> getTeachersByNumber(Integer number){
        return repository.getTeachersByNumber(number);
    }
}
