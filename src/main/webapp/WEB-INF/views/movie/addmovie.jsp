<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file = "../jspf/header.jspf" %>
<%@ include file="../jspf/main_menu.jspf"%>

<h1>Add new movie</h1>

<c:choose>
	<c:when test="${sessionScope.user == null}">
	Log first if you want to add new movie!
	</c:when>

		<c:otherwise>
			<form:form method="post" modelAttribute="movie"
				enctype="multipart/form-data">
				<p>
					Title:
					<form:input path="title" />
					<form:errors path="title" />
				</p>
				<p>
					Type:
					<form:select items="${type}" path="type" />
				</p>
				<p>
					Director:
					<form:input path="director" />
					<form:errors path="director" />
				</p>
				<p>
					Cast:
					<form:input path="cast" />
					<form:errors path="cast" />
				</p>
				<p>
					Age Limit:
					<form:select items="${ageLimit}" path="ageLimit" />
					<form:errors path="ageLimit" />
				</p>
				<p>
					Duration:
					<form:input path="duration" />
				</p>

				<p>
					Upload File: <input type="file" name="photo" />
				</p>
				<p>
					<input type="submit" />
				</p>
			</form:form>
		</c:otherwise>

</c:choose>

	<!-- END MAIN -->
<%@ include file = "../jspf/footer.jspf" %>
