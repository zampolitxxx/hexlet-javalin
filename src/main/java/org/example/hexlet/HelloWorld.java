package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        Course Java = new Course(1, "Java", "Java for beginers");
        Course Python = new Course(2, "Python", "Python for beginers");
        List<Course> courseList = List.of(Java, Python);
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/courses/{id}", ctx -> {
            Integer id = ctx.pathParamAsClass("id", Integer.class).getOrDefault(0);
            Course course = courseList.get(id);
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });
        app.get("/courses", ctx -> {
            var page = new CoursesPage(courseList);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });
        app.start(7070); // Стартуем веб-сервер
    }
}
