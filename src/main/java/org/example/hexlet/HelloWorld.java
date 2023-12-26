package org.example.hexlet;

import io.javalin.Javalin;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.dto.courses.CoursePage;
//import org.example.hexlet.dto.courses.CoursePage;
//import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config ->
                config.plugins.enableDevLogging());

        app.get("/", ctx -> {
            var course = new Course(0, "first course", "Java description");
            var page = new CoursePage(course);
            ctx.render("index.jte", Collections.singletonMap("page", page));
        });
        app.get("/courses", ctx -> {
            var course = new Course(0, "first course", "Java description");
            var page = new CoursePage(course);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });
        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", String.class).getOrDefault("Zero");
            var user = new User("<h1>" + id + "</h1>");
            var page = new UserPage(user);
            var res = StringEscapeUtils.escapeHtml4(id);
            ctx.contentType("html");
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });
        app.start(7070);
    }
}
