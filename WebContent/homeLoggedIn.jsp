<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="logout.jsp">Logout</a>
    <!-- mostra o nome do usuario logado -->
    <h4 class="user"><c:out value="${username}" /></h4>
    <div class="post">
        <a href="createPost.jsp">Fazer postagem</a>
        <a href="userPost.jsp">Postagens do user</a>
    </div>
    <div class="categorias">
        <a href="seteAdez.jsp">Sete A Dez Anos</a>
    </div>
    <h2 class="homePageTitle">Home Page</h2>
</body>
</html>
