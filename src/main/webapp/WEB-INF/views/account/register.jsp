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
		<p>
			First name:
			<form:input type="text" path="firstName" />
			<form:errors path="firstName" />
		</p>
		<p>
			Last name:
			<form:input type="text" path="lastName" />
			<form:errors path="lastName" />
		</p>
		<p>
			Year of birth:
			<form:input type="date" path="age" />
			<form:errors path="age" />
		</p>
		<p>
			Phone:
			<form:input type="tel" path="phone" />
			<form:errors path="phone" />
		</p>
		<p>
			Email:
			<form:input type="email" path="email" />
			<form:errors path="email" />
		</p>
		<p>
			Password:
			<form:password path="password" />
			<form:errors path="password" />
		</p>
		<p>
			<input type="submit" />
		</p>
	</form:form>

	<!-- END MAIN -->
<%@ include file = "../jspf/footer.jspf" %>

</body>
</html>