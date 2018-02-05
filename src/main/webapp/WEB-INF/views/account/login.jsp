<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/main_menu.jspf"%>

<h1>Login</h1>
<p>${msg}</p>

<form:form method="post" modelAttribute="loginData">
	<p>
		Email
		<form:input path="email" />
	</p>
	<p>
		Password
		<form:password path="password" />
	</p>
	<p>
		<input type="submit" />
	</p>
	<form:errors></form:errors>
</form:form>

<%@ include file="../jspf/footer.jspf"%>
