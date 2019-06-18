<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tres a Cinco Anos</title>
    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
    <link rel="stylesheet" type="text/css" href="CSS/showPosts.css">
</head>
<body>
	<s:menu/>
    <h4 class="categoria">Tres A Cinco Anos</h4>
    <!-- mostra os post da categoria -->
	<div class="show-posts">
		<c:if test="${posts.isEmpty()}">
			<h2>Essa categoria nao tem postagens</h2>
		</c:if>
		<c:if test="${posts.isEmpty() == false}">
				<c:forEach items="${posts}" var="post">
				<div class="post">
					<form action="<c:url value='ShowPost'/>" method="get">
						<h3 class="titulo">${post.getTitle()} <span>autor: ${post.getAccountId().getUsername()}</span></h3>
						<ul class="tags">
								<c:forEach items="${post.getTags()}" var="tags">
									<li><div class="tag">${tags}</div></li>
								</c:forEach>
						</ul>
						<div class="texto">
							<p> ${post.getText()}</p>
						</div>
						<div class="data">Data da Publicação: ${post.getCreationDate()}</div>				
						<button type="submit" name ="id" value ="${post.getPostId()}" class="btn-verPost">Ver postagem completa</button><br><br> 	
					</form>	
				</div>
				</c:forEach>
		</c:if>
	</div>
</body>
</html>