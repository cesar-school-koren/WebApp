<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Eventos</title>
    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
</head>
<body>
	<s:menu/>
    <h4 class="categoria">Eventos</h4>
    <!-- mostra os post da categoria -->
	<div class="show-posts">
		<c:if test="${posts.isEmpty()}">
			<h2>Essa categoria não tem postagens</h2>
		</c:if>
		<c:if test="${posts.isEmpty() == false}">
			<c:forEach items="${posts}" var="post">
				<form action="<c:url value='ShowPost'/>" method="get">
					<h3>Titulo: ${post.getTitle()}</h3>
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