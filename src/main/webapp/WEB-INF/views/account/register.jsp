<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@ include file = "../jspf/head_config.jspf" %>

</head>
<body>
<%@ include file = "../jspf/header.jspf" %>

<h1>Registration</h1>

<p>${msg}</p>
<form:form method="post" modelAttribute="user">
	<p>First Name<form:input path="firstName" /><form:errors path="firstName"></form:errors></p>
	<p>Lastname<form:input path="lastName" /><form:errors path="lastName"></form:errors></p>
	<p>Age<form:input path="age" /><form:errors path="age"></form:errors></p>
	<p>Phone<form:input path="phone" /><form:errors path="phone"></form:errors></p>
	<p>Email<form:input path="email" /><form:errors path="email"></form:errors></p>
	<p>Password<form:password path="password" /><form:errors path="password"></form:errors></p>
<p><input type="submit" /></p>
</form:form>


<!-- END MAIN -->
<%@ include file = "../jspf/footer.jspf" %>
</div>
</body>
</html>