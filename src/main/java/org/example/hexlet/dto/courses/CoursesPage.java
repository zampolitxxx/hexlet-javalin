package org.example.hexlet.dto.courses;
import lombok.Getter;
import lombok.AllArgsConstructor;
import org.example.hexlet.model.Course;
import java.util.List;

@Getter
@AllArgsConstructor
public class CoursesPage {
    List<Course> courses;
}
