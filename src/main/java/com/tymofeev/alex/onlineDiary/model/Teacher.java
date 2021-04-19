package com.tymofeev.alex.onlineDiary.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Teacher extends BaseEntity{

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @ManyToOne
    @JoinColumn(name = "classRoom_id")
    private
    ClassRoom classRoom;

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
