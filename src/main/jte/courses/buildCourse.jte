@import org.example.hexlet.dto.courses.BuildCoursePage
@param BuildCoursePage page

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
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/courses" method="post">
        <dev>
            <label>
                <input type="text" placeholder="name" name="name">
            </label>
        </dev>
        <dev>
            <label>
                <input type="text" placeholder="description" name="description">
            </label>
        </dev>
        <dev>
            <label>
                <input type="submit" value="Отправить">
            </label>
        </dev>
    </form>
</body>
</html>