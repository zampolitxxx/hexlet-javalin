package org.example.hexlet.dto.courses;

import org.example.hexlet.model.Course;
import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class CoursePage{
    private Course course;
}
