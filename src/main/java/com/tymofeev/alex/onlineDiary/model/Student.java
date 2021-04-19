package com.tymofeev.alex.onlineDiary.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
public class Student extends BaseEntity{

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
