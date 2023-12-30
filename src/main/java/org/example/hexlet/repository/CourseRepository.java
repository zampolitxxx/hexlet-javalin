package org.example.hexlet.repository;

import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static List<Course> entities = new ArrayList<>();
    public static void addCourse(Course course) {
        course.setId(entities.size() + 1);
        entities.add(course);
    }
    public static List<Course> getEntities() {
        return entities;
    }

}
