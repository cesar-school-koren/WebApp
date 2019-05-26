<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${post.getTitle()}" /></title>
</head>
<body>
    <a href="homeLoggedIn.jsp">Home</a>
    <a href="UserPosts">Posts</a>
    <a href="logout.jsp">Logout</a>
    <!-- <h1 class="titulo"><c:out value="${post.getTitle()}" /></h1>
    <p class="text"><c:out value="${post.getText()}" /></p> -->
	<h3>${post.getTitle()}</h3>
	<p><b>Autor:</b> <c:out value="${post.getAccountId().getUsername()}" /></p>
    <p><b>Conteúdo:</b> <c:out value="${post.getText()}" /></p>
		
	<h2>Comentários</h2>
	<c:forEach var="comentario" items="${sessionScope.comentarios}">
  		<p><c:out value= "${comentario.getText()}" /> | Autor: <c:out value = "${comentario.getAccountId().getUsername()}" /></p>
	</c:forEach>
	<br>
    <form action="<c:url value='CommentPost'/>" method="post">
    	<input type="hidden" name="id" value="${post.getPostId()}" />
		Comentar: <br><textarea name="conteudo" rows="4" cols="50" required></textarea><br><br>
		<button type="submit" class="btn">Comentar</button>
	</form>	
</body>
</body>
</html>