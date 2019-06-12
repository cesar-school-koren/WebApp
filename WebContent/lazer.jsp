<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
<meta charset="UTF-8">
<title>Lazer</title>
</head>
<body>
	<s:menu/>
    <h4 class="categoria">Lazer</h4>
    <!-- mostra os post da categoria -->
	<div class="show-posts">
		<c:if test="${posts.isEmpty()}">
			<h2>Essa TAG nao tem postagens</h2>
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