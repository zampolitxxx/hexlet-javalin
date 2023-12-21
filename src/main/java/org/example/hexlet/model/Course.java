package org.example.hexlet.model;
import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class Course {
    private Integer id;
    private String title;
    private String description;
}
