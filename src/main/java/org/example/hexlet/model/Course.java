package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Course{
    private Integer id;
    private String name;
    private String description;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
