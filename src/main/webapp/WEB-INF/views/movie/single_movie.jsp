<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>
<body>

<%@ include file = "../jspf/header.jspf" %>
<%@ include file = "../jspf/main_menu.jspf" %>


<c:choose>
	<c:when test="${sessionScope.user == null}">
	Log first if you want to check offers!
	</c:when>
	
	<c:otherwise>
	<br/>
<div>
	<p><b>${movie.title}</b></p>

	<p>Type: ${movie.type}</p>
	<p>Director: <b>${movie.director}</b></p>
	<p>Cast: <b>${movie.cast}</b></p>
	<p>Age Limit: <b>${movie.ageLimit}</b> years</p>
	<p>Duration: <b>${movie.duration}</b> min</p>
	<p>Description: <b>${movie.description}</b></p>
	<img src="//localhost:8080/cinema-hall-reservation/resources/picture/${movie.posterUrl}" width="300" height="250"/>	

	<form action="/cinema-hall-reservation/movie/edit/${movie.id}"><button type="submit">Edit movie</button></form>
	<form action="/cinema-hall-reservation/movie/delete/${movie.id}"><button type="submit">Delete movie</button></form>

</div>

	</c:otherwise>
</c:choose>



<!-- END MAIN -->
<%@ include file = "../jspf/footer.jspf" %>

</body>
</html>