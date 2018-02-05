<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/main_menu.jspf"%>

<c:choose>
	<c:when test="${sessionScope.user == null}">
	Log first if you want to add new movie!
	</c:when>

	<c:otherwise>
		<form:form method="post" modelAttribute="auditory">
			<p>
				Title:
				<form:input path="name" />
				<form:errors path="name" />
			</p>
			<p>
				Seats quantity:
				<form:input path="seatQuantity" />
				<form:errors path="seatQuantity" />
			</p>
			<p>
				Cinema:
				<form:select type="text" path="cinema">
					<form:options items="${availableCinemas}" itemValue="id"
						itemLabel="name" />
				</form:select>
				<form:errors path="cinema" />
			</p>

			<p>
				<input type="submit" />
			</p>
		</form:form>
	</c:otherwise>

</c:choose>

<!-- END MAIN -->

<%@ include file="../jspf/footer.jspf"%>