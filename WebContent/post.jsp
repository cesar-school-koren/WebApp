<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${sessionScope.post.getTitle()}" /></title>
        <link rel="stylesheet" type="text/css" href="CSS/menu.css">
        <link rel="stylesheet" type="text/css" href="CSS/post.css">
</head>
<body>
	<s:menu/>
    <c:if test="${post.getAccountId().getUsername() == sessionScope.conta.getUsername() || sessionScope.conta.getPrivilege() == 0}">
		<form action="DeletePost" method="post">
			<button type="submit" class="btn">Deletar post</button>
		</form>
		<hr>
    </c:if>
    <div style="border-bottom: 1px solid;">
		<h3 class="titulo">${post.getTitle()} <span>autor: ${post.getAccountId().getUsername()}</span></h3>
		<ul class="tags">
			<c:forEach items="${post.getTags()}" var="tags">
			<li><div class="tag">${tags}</div></li>
			</c:forEach>
		</ul>
		<div class="data">Data da Publicação: ${post.getCreationDate()}</div>
	    <div class="texto">
			<p> ${post.getText()}</p>
		</div>
	</div>
	<div class="comentarios">
		<h4>Comentários</h4>
	<c:forEach var="comentario" items="${sessionScope.comentarios}">
		<div style="margin-left:${80*comentario.getDepth()}px; width:auto; border-left: 1px dashed #000; padding-left:5px;">
  		<span> Autor: <c:out value = "${comentario.getAccountId().getUsername()}" /></span>
  		<p class="textoComentario"><c:out value= "${comentario.getText()}" /> </p>
  		<c:if test="${comentario.getAccountId().getUsername() == sessionScope.conta.getUsername() || sessionScope.conta.getPrivilege() == 0 }">
		<form action="DeleteComment" method="POST">
				<button type="submit" name="commentId" value="${comentario.getCommentaryId()}" class="btn">Deletar comentario</button>
		</form>
		</c:if> 
  		<c:if test="${sessionScope.conta != null}">
	  		<form action="<c:url value='AnswerComment'/>" method="post">
	  			<input type="hidden" name="postId" value="${sessionScope.post.getPostId()}" />
	  			<br>Comentar: <br><textarea name="conteudo" rows="1" cols="50" required></textarea><br><br>
	  			<input type="hidden" name="commentId" value="${comentario.getCommentaryId()}" />
	  			<button type="submit" class="btn">Responder</button>
			</form>
		</c:if>
		</div>
	</c:forEach>
	</div>
	<c:if test="${sessionScope.conta != null}">
		<div style="text-align: center;">
		    <form action="<c:url value='CommentPost'/>" method="post">
		    	<input type="hidden" name="id" value="${sessionScope.post.getPostId()}" />
				<br>Comentar: <br><textarea name="conteudo" rows="4" cols="50" required></textarea><br><br>
				<button type="submit" class="btn">Comentar</button>
			</form>
		</div>
	</c:if>
</body>
</html>