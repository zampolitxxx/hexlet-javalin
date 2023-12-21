@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.dto.courses.CoursesPage
@import org.example.hexlet.model.Course;
@param CoursesPage page
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h3>Все курсы</h3>
    @for(Course course : page.getCourses())
        <p>${course.getId()} Курс - ${course.getTitle()} Описание - ${course.getDescription()}</p>
    @endfor
</body>
</html>