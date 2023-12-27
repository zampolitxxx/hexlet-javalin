package org.example.hexlet;

import io.javalin.Javalin;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.dto.courses.CoursePage;
//import org.example.hexlet.dto.courses.CoursePage;
//import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

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
            var nameTerm = ctx.queryParam("nameTerm");
            var descriptionTerm = ctx.queryParam("descriptionTerm");
            List<Course> res = new ArrayList<>();
            if(nameTerm != null && descriptionTerm != null) {
                res.addAll(coursesList.stream()
                        .filter(x -> x.getName().contains(nameTerm))
                        .filter(x -> x.getDescription().contains(descriptionTerm))
                        .toList());
                var page = new CoursesPage(res, nameTerm, descriptionTerm);
                ctx.render("courses/index.jte", Collections.singletonMap("page", page));
            } else {
                var page = new CoursesPage(coursesList, nameTerm, descriptionTerm);
                ctx.render("courses/index.jte", Collections.singletonMap("page", page));
            }
        });

        app.get("/users", ctx -> {
            var page = new UsersPage(UserRepository.getEntities());
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });
        app.post("/users", ctx -> {
            var name = ctx.formParam("name");
            var surname = ctx.formParam("surname");
            var email = ctx.formParam("email");
            var user = new User(name, surname, email);
            UserRepository.addUser(user);
            ctx.redirect("/users");

        });
        app.get("/users/build", ctx -> {
            ctx.render("users/buildUser.jte");
        });
        app.start(7070);
    }
}
