<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Имена</h1>
<div>
    <#if firstNames??>
        <#list firstNames as firstName>
            <p>${firstName}</p>
        </#list>
    </#if>
</div>
</body>
</html>