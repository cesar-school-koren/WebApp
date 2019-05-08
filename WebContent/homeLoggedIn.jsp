<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="home.css">
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
    <div class="post">
        <a href="createPost.jsp">Fazer postagem</a>
        <a href="userPosts.jsp">Postagens do user</a>
    </div>
    <div class="categorias">
        <a href="seteAdez.jsp">Sete A Dez Anos</a>
    </div>
    <h2 class="homePageTitle">Home Page</h2>
</body>
</html>