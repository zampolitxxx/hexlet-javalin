package org.example.hexlet.dto.courses;

import org.example.hexlet.model.Course;
import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
public class CoursesPage{
    private List<Course> coursesList;
}
