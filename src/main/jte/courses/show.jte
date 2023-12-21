@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.dto.courses.CoursePage
@import org.example.hexlet.model.Course;
@param CoursePage page
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
<h3>Курс № ${page.getCourse().getId()}</h3>
    <h5>${page.getCourse().getTitle()}</h5>
    <h5>${page.getCourse().getDescription()}</h5>
</body>
</html>