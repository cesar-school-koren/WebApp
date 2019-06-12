<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/home.css">
    <link rel="stylesheet" type="text/css" href="CSS/menu.css">
    <link rel="stylesheet" type="text/css" href="CSS/searchText.css">
	<meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
	<s:menu/>
    <div class="direcionamentos">
        <a href="ZeroADois" class="Retngulo-20">0 A 2 Anos</a>
        <a href="TresACinco" class="Retngulo-20">3 A 5 Anos</a>
        <a href="CincoADez" class="Retngulo-20">5 A 10 Anos</a>
        <a href="DezAQuinze" class="Retngulo-20">10 A 15 Anos</a>
        <a href="QuinzeEmDiante" class="Retngulo-20">15 em Diante</a>
    </div>
    <div class="container">
		<form action="SearchText" method="POST" style="text-align:center" class="index-search-form">
	 	<input class="barra-pesquisa" type="text" placeholder="Pesquisar" required>
		<button name="submit" type="submit" class="">Ir</button>
	 	</form>
    </div>
	
	<div style="text-align: center;">
	   	<div class="csslider infinity" id="slider1">
		  <input type="radio" name="slides" checked="checked" id="slides_1"/>
		  <input type="radio" name="slides" id="slides_2"/>
		  <input type="radio" name="slides" id="slides_3"/>
		  <ul>
		    <li class="item-1">
				<a href="ZeroADois"><img src="Media/faq36.png"/></a>
		    </li>
		    <li class="item-2"><a href="ZeroADois"><img src="Media/noticias.png"/></a>
		    </li>
		    <li class="item-3">
		      <a href="ZeroADois"><img src="Media/eventos.png"/></a>
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
	<div style="padding-top: 140px;">
		<img src="Media/tags.png" usemap="#image-map">
		
		<map name="image-map">
		    <area target="" alt="Saúde" title="Saúde" href="saude" coords="78,84,66,93,62,111,62,141,63,156,69,164,75,168,218,168,226,162,230,153,232,142,232,119,232,99,227,90,217,86" shape="poly">
		    <area target="" alt="Educação" title="Educação" href="educacao" coords="288,85,274,95,270,108,270,125,270,143,271,152,277,163,284,169,425,168,435,163,440,157,441,146,440,99,435,91,426,85,314,85" shape="poly">
		    <area target="" alt="Autonomia" title="Autonomia" href="autonomia" coords="80,182,67,189,62,202,63,239,62,251,66,259,75,264,104,265,218,265,226,257,231,246,231,224,231,194,221,185,206,184" shape="poly">
		    <area target="" alt="Social" title="Social" href="social" coords="272,256,272,197,282,184,303,180,423,179,441,196,440,211,439,255,429,265,298,266,282,264" shape="poly">
		</map>
	</div>
	<div style="padding-top: 160px;">
		<img src="Media/depoimentos.png"/>	
	</div>
</body>
</html>
