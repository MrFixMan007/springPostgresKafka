<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Книги</h1>
<div>
    <#if books??>
        <#list books as book>
            <p>
                <b>Название:</b> ${book.name}<br>
                Имя автора: ${book.firstName}<br>
                Фамилия автора: ${book.secondName}<br>
                Жанр: ${book.genre}<br>
                Страна издания: ${book.country}<br>
            </p>
        </#list>
    </#if>
</div>
</body>
</html>