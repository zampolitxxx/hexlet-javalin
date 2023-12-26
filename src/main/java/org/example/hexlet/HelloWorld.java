package org.example.hexlet;

import io.javalin.Javalin;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.dto.courses.CoursePage;
//import org.example.hexlet.dto.courses.CoursePage;
//import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.CoursesPage;
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

        var course1 = new Course(0, "Java", "Java description");
        var course2 = new Course(1, "PHP", "PHP description");
        var course3 = new Course(2, "Python", "Python description");
        var course4 = new Course(3, "Kotlin", "Kotlin description");
        var coursesList = List.of(course1, course2, course3, course4);

        app.get("/", ctx -> {
//            var page = new CoursePage(courses);
//            ctx.render("index.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Integer.class).getOrDefault(1);
            var page = new CoursePage(coursesList.get(id));
            ctx.render("courses/show.jte", Collections.singletonMap("page", page));
        });

        app.get("/courses", ctx -> {
            var nameTerm = ctx.queryParamAsClass("nameTerm", String.class).getOrDefault("Zero");
//            var description = ctx.queryParamAsClass("descriptionTerm", String.class).get();
            List<Course> res = new ArrayList<>();
            if(nameTerm != null) {
                res.addAll(coursesList.stream()
                        .filter(x -> x.getName().contains(nameTerm))
                        .toList());
                var page = new CoursesPage(res);
                ctx.render("courses/index.jte", Collections.singletonMap("page", page));
            } else {
                var page = new CoursesPage(coursesList);
                ctx.render("courses/index.jte", Collections.singletonMap("page", page));
            }

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
