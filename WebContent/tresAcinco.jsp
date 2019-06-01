<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tres a Cinco Anos</title>
</head>
<body>
	<a href="logout.jsp">Logout</a>
	<a href="homeLoggedIn.jsp">Home</a>
    <!-- mostra o nome do usuario logado -->
    <h4 class="categoria">Tres A Cinco Anos</h4>
    <!-- mostra os post da categoria -->
	<div class="show-posts">
		<c:if test="${posts.isEmpty()}">
			<h2>Essa categoria nao tem postagens</h2>
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