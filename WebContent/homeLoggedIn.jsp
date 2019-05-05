<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="homeLoggedIn.css">
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
    <!-- ainda falta referencia para pagina de criar postagem -->
    <a href="logout.jsp">Logout</a>
    <!-- mostra o nome do usuario logado -->
    <div class="user">
        <%
        	// pega o username a partir do atributo adicionado durante a etapa de login no servlet (src/com/school/koren/controller/Login.java)
            out.print(session.getAttribute("username"));
        %>
    </div>
    <h2>Home Page</h2>
</body>
</html>