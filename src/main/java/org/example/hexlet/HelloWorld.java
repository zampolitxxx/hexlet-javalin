package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloWorld {
    public static <validationException> void main(String[] args) {
        var app = Javalin.create(config ->
                config.plugins.enableDevLogging());

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        //show all courses
        app.get(NamedRoutes.getCoursesPath(), ctx -> {
            var page = new CoursesPage(CourseRepository.getEntities());
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });
        //POST-handler to create course
        app.post(NamedRoutes.getCoursesPath(), ctx -> {
            try{
                var name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.length() > 2, "Length should be more then 2 simbols")
                        .get();
                var description = ctx.formParamAsClass("description", String.class)
                        .check(value -> value.length() > 10, "Minimum length is 10 symbols")
                        .get();
                var course = new Course(name, description);
                CourseRepository.addCourse(course);
                ctx.redirect(NamedRoutes.getCoursesPath());
            } catch(ValidationException e) {
                var page = new BuildCoursePage(e.getErrors());
                ctx.render("courses/buildCourse.jte", Collections.singletonMap("page", page));
            }
        });
        //GET-handler with HTML-form add course
        app.get(NamedRoutes.getBuildCoursePath(), ctx -> {
            var page = new BuildCoursePage();
            ctx.render("courses/buildCourse.jte", Collections.singletonMap("page", page));
        });

        //Show all users
        app.get(NamedRoutes.getUsersPath(), ctx -> {
            var page = new UsersPage(UserRepository.getEntities());
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });
        //POST-hendler to create user
        app.post(NamedRoutes.getUsersPath(), ctx -> {
            var name = ctx.formParam("name");
            var surname = ctx.formParam("surname");
            var email = ctx.formParam("email");
            try {
                var password = ctx.formParam("password");
                var passwordConfirm = ctx.formParamAsClass("passwordConfirm", String.class)
                        .check(value -> value.equals(password), "Passwords are not equals")
                        .check(value -> value.length() > 5, "Password`s length should be more, then 5 symbols")
                        .get();
                var user = new User(name, surname, email, passwordConfirm);
                UserRepository.addUser(user);
                ctx.redirect(NamedRoutes.getUsersPath());
            } catch (ValidationException e) {
                var page = new BuildUserPage(name, surname, email, e.getErrors());
                ctx.render("users/buildUser.jte", Collections.singletonMap("page", page));
            }

        });
        //Get-hendler with HTML-form
        app.get(NamedRoutes.getBuildUserPath(), ctx -> {
            var page = new BuildUserPage();
            ctx.render("users/buildUser.jte", Collections.singletonMap("page", page));
        });
        app.start(7070);
    }
}
