<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/main_menu.jspf"%>



<form:form method="post" modelAttribute="cinema">
	<p>
		Address:
		<form:input type="text" path="address" />
		<form:errors path="address" />
	</p>
	<p>
		Email:
		<form:input type="text" path="email" />
		<form:errors path="email" />
		${message}
	</p>
	<p>
		Name:</p>
		<form:input type="text" path="name" />
		<form:errors path="name" />
	<p>
		Phone:
		<form:input type="text" path="phone" />
		<form:errors path="phone" />
	</p>
	<p>
		<input type="submit" value="Dodaj" />
	</p>


</form:form>


<%@ include file="../jspf/footer.jspf"%>
