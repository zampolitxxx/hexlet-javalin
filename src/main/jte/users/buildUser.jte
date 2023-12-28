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
    <form action="/users" method="post">
        <div>
            <label>
                <input type="text" name="name" placeholder="name">
            </label>
        </div>
        <div>
            <label>
                <input type="text" name="surname" placeholder="surname">
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