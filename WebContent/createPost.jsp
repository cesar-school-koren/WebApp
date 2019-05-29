<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="inputPages.css" type="text/css">
    <meta charset="UTF-8">
    <title>Post</title>
</head>
<body>
    <h2>Criar postagem</h2>
    <form action="CreatePost" method="POST">
        <pre>
            Titulo : <input type="text" name="titulo">
                     <input type="text" name="texto">
                     <select multiple class="select-checkbox" name="tags">
                     	<option value="EDUCACAO">Educação</option>
                     	<option value="SAUDE">Saúde</option>
                     	<option value="SOCIAL">Social</option>
                     	<option value="Autonomia">Autonomia</option>
                     </select>
                     <input type="submit" value="enviar">
        </pre>
    </form>
</body>
</html>