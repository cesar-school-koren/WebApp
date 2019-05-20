<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.school.PostHome"%>
<%@page import="com.school.Post"%>
<%@page import="com.school.AccountHome"%>
<%@page import="com.school.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Postagens do Usuário</title>
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
    <!-- mostra o nome do usuario logado -->
    <div class="user">
        <%
        	// pega o username a partir do atributo adicionado durante a etapa de login no servlet (src/com/school/koren/controller/Login.java)
            out.print(session.getAttribute("username"));
    		
    		String username = session.getAttribute("username").toString();
    		
    		try {
    			Account conta = new Account();
    			AccountHome accountHome = new AccountHome();
    			conta.setUsername(username);
    			
    			Post post = new Post();
    			PostHome postHome = new PostHome();
    			post.setAccountId(accountHome.findByExample(conta).get(0));
    			
    			List<Post> postagens = postHome.findByExample(post);
    			
    			session.setAttribute("posts", postagens);
    			
    		} catch (Exception e) {
    			// TODO: handle exception
    		}
        %>
    </div>
    <!-- mostra os post dos usuários -->
	<form name="load"> 
		<c:if test="${posts.isEmpty()}">
			<h2>Esse usuário não tem postagens</h2>
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