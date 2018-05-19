package com.wchb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Student {

    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
}
