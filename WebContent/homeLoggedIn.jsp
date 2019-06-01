<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="home.css">
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
	<s:autentication/>
    <a href="logout.jsp">Logout</a>
    <!-- mostra o nome do usuario logado -->
    <h4 class="user"><c:out value="${sessionScope.conta.getUsername()}" /></h4>
    <div class="post">
        <a href="createPost.jsp">Fazer postagem</a>
        <a href="UserPosts">Postagens do usuario</a> <!-- chama o servlet que redireciona para o jsp -->
        <a href="search.jsp">Search</a>
    </div>
    <div class="categorias">
        <a href="ZeroADois">Zero A Dois Anos</a>
        <a href="TresACinco">Tres A Cinco Anos</a>
        <a href="CincoADez">Cinco A Dez Anos</a>
        <a href="DezAQuinze">Dez A Quinze Anos</a>
        <a href="QuinzeEmDiante">Quinze em Diante</a>
    </div>
    <h2 class="homePageTitle">Home Page</h2>
</body>
</html>
