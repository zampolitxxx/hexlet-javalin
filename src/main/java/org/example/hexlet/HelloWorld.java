package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/hello", ctx -> {
            String result = "Hello, " + ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result(result);
        });
        app.start(7070); // Стартуем веб-сервер
    }
}
