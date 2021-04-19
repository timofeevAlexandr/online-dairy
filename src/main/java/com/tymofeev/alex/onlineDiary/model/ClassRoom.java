package com.tymofeev.alex.onlineDiary.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ClassRoom{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Integer number;

    public ClassRoom(Integer number) {
        this.number = number;
    }
}