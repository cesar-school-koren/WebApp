<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Zero a Dois Anos</title>
    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
    <link rel="stylesheet" type="text/css" href="CSS/showPosts.css">
</head>
<body>
	<s:menu/>
    <h4>Zero A Dois Anos</h4>
    <!-- mostra os post da categoria -->
	<div class="show-posts">
		<c:if test="${posts.isEmpty()}">
			<h2>Essa categoria nao tem postagens</h2>
		</c:if>
		<c:if test="${posts.isEmpty() == false}">
		<div style="text-align: center; background-color: #ffd2b7">
			<c:forEach items="${posts}" var="post">
				<form action="<c:url value='ShowPost'/>" method="get">
					<h3 class="titulo">${post.getTitle()} <span>autor: ${post.getAccountId().getUsername()}</span></h3>
					<ul class="tags">
							<c:forEach items="${post.getTags()}" var="tags">
								<li><div class="tag">${post.getTags()}</div></li>
							</c:forEach>
					</ul>
					<div class="texto">
						<p> ${post.getText()}</p>
					</div>
					<div class="data">Data da Publicação: ${post.getCreationDate()}</div>				
					<button type="submit" name ="id" value ="${post.getPostId()}" class="btn-verPost">Ver postagem completa</button><br><br> 	
				</form>	
			</c:forEach>
		</div>
		</c:if>
	</div>
</body>
</html>