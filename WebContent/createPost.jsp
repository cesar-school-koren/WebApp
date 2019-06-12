<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="inputPages.css" type="text/css">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
    <title>Criar Post</title>
</head>
<body>
	<s:autentication/>
	<s:menu/>
    <h2>Criar postagem</h2>
    <form action="CreatePost" method="POST">
        <pre>
            Titulo : <input type="text" name="titulo" required>
            Texto :  <input type="text" name="texto" required>
                     <c:choose>
						<c:when test="${sessionScope.conta.privilege == 1}">
	 						<p>Selecione uma Categoria</p>
		                    <select class="select-checkbox" name="categoria" required>
		                     	<option value="1">Zero a Dois</option>
		                     	<option value="2">Tres a Cinco</option>
		                     	<option value="3">Cinco a Dez</option>
		                     	<option value="4">Dez a Quinze</option>
		                     	<option value="5">Quinze em Diante</option>
		                    </select>
		                    <p>Selecione uma ou mais Tag</p>
		                    <select multiple class="select-checkbox" name="tags" required>
		                     	<option value="EDUCACAO">Educação</option>
		                     	<option value="SAUDE">Saúde</option>
		                     	<option value="TRABALHO">Trabalho</option>
		                    	<option value="LAZER">Lazer</option>
		                    </select>
						</c:when>
						<c:otherwise>
	 						<p>Selecione uma Categoria</p>
		                    <select class="select-checkbox" name="categoria" required>
		                     	<option value="1">Zero a Dois</option>
		                     	<option value="2">Tres a Cinco</option>
		                     	<option value="3">Cinco a Dez</option>
		                     	<option value="4">Dez a Quinze</option>
		                     	<option value="5">Quinze em Diante</option>
		                     	<option value="6">Noticias</option>
		                     	<option value="7">Eventos</option>
		                    </select>
		                    <p>Selecione uma ou mais Tag</p>
		                    <select multiple class="select-checkbox" name="tags">
		                     	<option value="EDUCACAO">Educação</option>
		                     	<option value="SAUDE">Saúde</option>
		                     	<option value="TRABALHO">Trabalho</option>
		                    	<option value="LAZER">Lazer</option>
		                    </select>
						</c:otherwise>
					</c:choose>
                     <input type="submit" value="enviar">
        </pre>
    </form>
</body>
</html>