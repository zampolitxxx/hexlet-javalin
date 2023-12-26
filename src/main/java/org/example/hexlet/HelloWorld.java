package org.example.hexlet;

import io.javalin.Javalin;
import org.example.hexlet.dto.courses.CoursePage;
//import org.example.hexlet.dto.courses.CoursePage;
//import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config ->
                config.plugins.enableDevLogging());
        var course = new Course(0, "first course", "Java description");
        var page = new CoursePage(course);
        app.get("/", ctx -> {

            ctx.render("index.jte", Collections.singletonMap("page", page));
        });
        app.get("/courses", ctx -> {

            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });
        app.start(7070);
    }
}
