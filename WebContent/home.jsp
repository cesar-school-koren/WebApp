<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/home.css">
    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
	<meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
	<s:menu/>

	<div style="text-align: center;">
	   	<div class="csslider infinity" id="slider1">
		  <input type="radio" name="slides" checked="checked" id="slides_1"/>
		  <input type="radio" name="slides" id="slides_2"/>
		  <input type="radio" name="slides" id="slides_3"/>
		  <ul>
		    <li class="item-1">
				<a href="faq.jsp"><img src="Media/faq36.png"/></a>
		    </li>
		    <li class="item-2"><a href="Noticias"><img src="Media/noticias.png"/></a>
		    </li>
		    <li class="item-3">
		      <a href="Eventos"><img src="Media/eventos.png"/></a>
		    </li>
		  </ul>
		  <div class="arrows">
		    <label for="slides_1"></label>
		    <label for="slides_2"></label>
		    <label for="slides_3"></label>
		    <label class="goto-first" for="slides_1"></label>
		    <label class="goto-last" for="slides_3"></label>
		  </div>
		</div>
		<div style="padding-top: 100px;">
			<img src="Media/tags.png" usemap="#image-map">
			
			<map name="image-map">
			    <area target="" alt="Saude" title="Saude" href="Saude" coords="91,96,74,104,70,122,69,177,76,188,86,191,249,191,259,184,263,176,262,111,254,102,243,97" shape="poly">
			    <area target="" alt="Educacao" title="Educacao" href="Educacao" coords="326,97,310,108,307,125,309,181,314,188,322,191,487,193,495,186,501,177,502,116,495,104,483,99" shape="poly">
			    <area target="" alt="Trabalho" title="Trabalho" href="Trabalho" coords="88,207,76,214,70,229,69,283,77,297,85,303,246,304,258,297,263,286,263,226,257,214,247,210,218,209" shape="poly">
			    <area target="" alt="Lazer" title="Lazer" href="Lazer" coords="326,210,314,215,308,226,310,287,315,298,325,302,481,303,493,300,504,282,502,229,495,218,483,209" shape="poly">
			</map>
		</div>
		<div style="padding-top: 160px;">
			<img src="Media/depoimentos.png"/>	
		</div>
	</div>
</body>
</html>
