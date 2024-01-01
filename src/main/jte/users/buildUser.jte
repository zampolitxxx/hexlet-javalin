@import org.example.hexlet.dto.users.BuildUserPage
@import org.example.hexlet.util.NamedRoutes
@param BuildUserPage page
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
    <form action="${NamedRoutes.getUsersPath()}" method="post">
        <div>
            <label>
                <input type="text" name="name" placeholder="name" value="${page.getName()}">
            </label>
        </div>
        <div>
            <label>
                <input type="text" name="surname" placeholder="surname" value="${page.getSurname()}">
            </label>
        </div>
        <div>
            <label>
                <input type="text" name="email" placeholder="email" value="${page.getEmail()}">
            </label>
        </div>
        <div>
            <label>
                <input type="password" name="password" placeholder="password">
            </label>
        </div>
        <div>
            <label>
                <input type="password" name="passwordConfirm" placeholder="Confirmation Password">
            </label>
        </div>
        <div>
            <label>
                <input type="submit" value="Register">
            </label>
        </div>
    </form>
</body>
</html>