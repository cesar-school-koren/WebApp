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
	<s:menu/>
    <div class="categorias">
        <a href="ZeroADois">Zero A Dois Anos</a>
        <a href="TresACinco">Tres A Cinco Anos</a>
        <a href="CincoADez">Cinco A Dez Anos</a>
        <a href="DezAQuinze">Dez A Quinze Anos</a>
        <a href="QuinzeEmDiante">Quinze em Diante</a>
    </div>
    <form action="SearchText" method="POST">
		<p>Pesquisar : <input type="text" name="search" required></p>
		<input type="submit" value="enviar">
	</form>
    <h2 class="homePageTitle">Home Page</h2>
</body>
</html>
