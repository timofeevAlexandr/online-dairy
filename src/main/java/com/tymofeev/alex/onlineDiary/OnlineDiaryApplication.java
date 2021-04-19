package com.tymofeev.alex.onlineDiary;

import com.tymofeev.alex.onlineDiary.model.ClassRoom;
import com.tymofeev.alex.onlineDiary.model.Student;
import com.tymofeev.alex.onlineDiary.model.Teacher;
import com.tymofeev.alex.onlineDiary.repository.ClassRoomRepository;
import com.tymofeev.alex.onlineDiary.repository.StudentRepository;
import com.tymofeev.alex.onlineDiary.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OnlineDiaryApplication {

    private static final Logger log = LoggerFactory.getLogger(OnlineDiaryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OnlineDiaryApplication.class, args);
    }

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Bean
    public CommandLineRunner fillDB(ClassRoomRepository classRoomRepository,
                                    TeacherRepository teacherRepository,
                                    StudentRepository studentRepository) {
        return (args) -> {
            log.info("Create class room...");
            ClassRoom classRoom = new ClassRoom(100);
            classRoomRepository.save(classRoom);
            log.info("Class room was created...");

            // save a few customers
            log.info("Create teachers...");
            List<Teacher> teacherList = new ArrayList<>();
            teacherList.add(new Teacher("Александр", "Семенов"));
            teacherList.get(0).setClassRoom(classRoom);

            teacherList.add(new Teacher("Виктор", "Иванов"));
            teacherList.get(1).setClassRoom(classRoom);

            teacherList.add(new Teacher("Владислав", "Петров"));
            teacherList.get(2).setClassRoom(classRoom);

            teacherList.add(new Teacher("Иван", "Пухов"));
            teacherList.get(3).setClassRoom(classRoom);

            teacherList.add(new Teacher("Петр", "Смирнов"));
            teacherList.get(4).setClassRoom(classRoom);

            for (Teacher teacher: teacherList) {
                teacherRepository.save(teacher);
            }
            log.info("Teachers was created...");

            log.info("Create students...");
            List<Student> studentList = new ArrayList<>();
            studentList.add(new Student("Иван", "Иванов"));
            studentList.get(0).setTeacher(teacherList.get(0));

            studentList.add(new Student("Петр", "Петров"));
            studentList.get(1).setTeacher(teacherList.get(0));

            studentList.add(new Student("Александр", "Пухов"));
            studentList.get(2).setTeacher(teacherList.get(0));

            studentList.add(new Student("Виктор", "Смирнов"));
            studentList.get(3).setTeacher(teacherList.get(1));

            studentList.add(new Student("Владислав", "Семенов"));
            studentList.get(4).setTeacher(teacherList.get(2));

            for (Student student: studentList) {
                studentRepository.save(student);
            }
            log.info("Students was created...");
        };
    }
}