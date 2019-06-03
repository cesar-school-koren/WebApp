<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:choose>
	<c:when test="${sessionScope.conta == null}">
		<a href="home.jsp">Home</a>
		<a href="login.jsp">Login</a>
	    <a href="register.jsp">Register</a>
	    <a href="search.jsp">Search</a>
	</c:when>
	<c:otherwise>
		<!-- mostra o nome do usuario logado -->
		<h4 class="user"><c:out value="${sessionScope.conta.getUsername()}" /></h4>
	    <a href="logout.jsp">Logout</a>
	    <div class="post">
	    	<a href="home.jsp">Home</a>
	        <a href="createPost.jsp">Fazer postagem</a>
	        <a href="UserPosts">Postagens do usuario</a> <!-- chama o servlet que redireciona para o jsp -->
	        <a href="search.jsp">Search</a>
	    </div>
	    <p></p>
	</c:otherwise>
</c:choose>