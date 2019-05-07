<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post</title>
</head>
<body>
    <h2>Criar postagem</h2>
    <form action="CreatePost" method="POST">
        <pre>
            Titulo : <input type="text" name="titulo">
            <input type="text" name="texto">
            <input type="submit" value="enviar">
        </pre>
    </form>
</body>
</html>