package com.tymofeev.alex.onlineDiary.service;

import static org.junit.Assert.assertEquals;
import com.tymofeev.alex.onlineDiary.model.ClassRoom;
import com.tymofeev.alex.onlineDiary.repository.ClassRoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClassRoomServiceTest {

    @Mock
    ClassRoomRepository classRoomRepository;

    @InjectMocks
    ClassRoomService classRoomService;

    @Test
    public void getAllTest(){

        List<ClassRoom> listClassRooms = new ArrayList<>();
        listClassRooms.add(new ClassRoom(100));
        listClassRooms.add(new ClassRoom(200));
        listClassRooms.add(new ClassRoom(300));

        when(classRoomRepository.findAll()).thenReturn(listClassRooms);

        List<ClassRoom> testListClassRooms = classRoomService.getAll();

        assertEquals(3, testListClassRooms.size());
        assertEquals(100, (long) testListClassRooms.get(0).getNumber());
        assertEquals(200, (long) testListClassRooms.get(1).getNumber());
        assertEquals(300, (long) testListClassRooms.get(2).getNumber());
    }
}
