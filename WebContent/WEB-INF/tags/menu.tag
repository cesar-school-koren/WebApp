<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:choose>
	<c:when test="${sessionScope.conta == null}">
	<div class="nav">
		<ul>
			<li><a href="home.jsp">Home</a></li>
			<li><a href="login.jsp">Login</a></li>
	    	<li><a href="register.jsp">Register</a></li>
	    	<li><a href="search.jsp">Search</a></li>
	    </ul>
	</div>
	<p></p>
	</c:when>
	<c:otherwise>
		<!-- mostra o nome do usuario logado -->
		<div class="nav">
			<ul>
				<!-- <li><c:out value="${sessionScope.conta.getUsername()}" /></li>-->
				<li><a href="logout.jsp">Logout</a></li>
				<li><a href="home.jsp">Home</a></li>
				<!-- <li><a href="createPost.jsp">Fazer postagem</a></li> -->
		    	<li><a href="UserPosts">Meus Posts</a></li>
		    	<li> <a href="search.jsp">Search</a></li>
		    </ul>
		</div>  
		<p></p>
	</c:otherwise>
</c:choose>