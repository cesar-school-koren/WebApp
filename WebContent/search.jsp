<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/createPost.css" type="text/css">
    <link rel="stylesheet" href="CSS/menu.css" type="text/css">
    <meta charset="UTF-8">
	<title>Busca</title>
</head>
<body>
	<s:menu/>
    <h4>Buscar postagem</h4>
   	<div style="text-align: center;">
	   	<form action="SearchPost" method="POST">
	        <pre>
	                     <p>Selecione uma Categoria</p>
	                     <select class="select-checkbox" name="categoria" required>
	                     	<option value="0">Qualquer Categoria</option>
	                     	<option value="1">Zero a Dois</option>
	                     	<option value="2">Tres a Cinco</option>
	                     	<option value="3">Cinco a Dez</option>
	                     	<option value="4">Dez a Quinze</option>
	                     	<option value="5">Quinze em Diante</option>
	                     </select>
	                     <p>Selecione uma ou mais Tag</p>
	                     <select multiple class="select-checkbox" size="5" name="tags" required>
	                     	<option value="EDUCACAO">Educação</option>
	                     	<option value="SAUDE">Saúde</option>
	                     	<option value="LAZER">Lazer</option>
	                     	<option value="TRABALHO">Trabalho</option>
	                     	<option value="QUALQUER">Qualquer</option>
	                     </select>
	                     <input class="btn-createPost" type="submit" value="enviar">
	        </pre>
	    </form>
	   </div>
</body>
</html>