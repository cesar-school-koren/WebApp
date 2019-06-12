<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/menu.css">
	<title>Resultado da pesquisa</title>
</head>
<body>
	<s:menu/>
		<a href="homeLoggedIn.jsp">Home</a>
		<form action="SearchText" method="POST">
			<p>Novo Texto Para Pesquisa : <input type="text" name="search" required></p>
			<input type="submit" value="enviar">
		</form>
		<p><a href="search.jsp">Fazer uma nova pesquisa utilizando Categoria e Tags</a></p>
	    <div class="show-posts">
			<c:if test="${posts.isEmpty()}">
				<h2>Não existem Posts nos termos procurados</h2>
			</c:if>
			<c:if test="${posts.isEmpty() == false}">
				<c:forEach items="${posts}" var="post">
					<form action="<c:url value='ShowPost'/>" method="get">
						<h3>Titulo: ${post.getTitle()}</h3>
						<label><b>Categoria:</b> ${post.getCategoryId().getTitle()}</label><br><br>
						<label><b>Tema:</b> ${post.getTags()}</label><br><br>
						<label><b>Conteúdo:</b></label>
						<div class="conteudo-postagem">
							<p> ${post.getText()}</p>
						</div>						
						<button type="submit" name ="id" value ="${post.getPostId()}" class="btn-verPost">Ver postagem completa</button><br><br> 	
					</form>	
				</c:forEach>
			</c:if>
		</div>
</body>
</html>