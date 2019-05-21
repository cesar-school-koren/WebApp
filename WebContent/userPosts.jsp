<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Postagens do Usuario</title>
</head>
<body>
<script>
function onLoadSubmit() {
	document.load.submit();
}
</script>
</head>
<body onload = "onLoadSubmit()">
	<a href="logout.jsp">Logout</a>
	<a href="homeLoggedIn.jsp">Home</a>
    <!-- mostra o nome do usuario logado -->
    <div class="user">
        <%
        	// pega o username a partir do atributo adicionado durante a etapa de login no servlet (src/com/school/koren/controller/Login.java)
            out.print(session.getAttribute("username"));
        %>
    </div>
    <!-- mostra os post dos usuarios -->
	<form name="load">
		<!-- por algum motivo o jsp nao chama o servlet -->
		<jsp:include page="/userPosts">
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
	</form>
</body>
</body>
</html>