<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Postagens do usuário</title>
</head>
<body>
	<a href="logout.jsp">Logout</a>
	<a href="homeLoggedIn.jsp">Home</a>
    <!-- mostra o nome do usuario logado -->
    <h4 class="user"><c:out value="${username}" /></h4>
    <!-- mostra os post dos usuarios -->
	<div class="show-posts">
		<!-- por algum motivo o jsp nao chama o servlet -->
		<c:if test="${posts.isEmpty()}">
			<h2>Esse usuario nao tem postagens</h2>
		</c:if>
		<c:if test="${posts.isEmpty() == false}">
			<c:forEach items="${posts}" var="post">
				<div>
					<hr>
					<h3><c:out value="${post.getTitle()}" /></h3>
					<p><c:out value="${post.getText()}" /></p>
				</div>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>