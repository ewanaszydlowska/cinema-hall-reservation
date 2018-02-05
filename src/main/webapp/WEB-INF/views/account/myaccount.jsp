<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pl" lang="pl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>
<body>
	<%@ include file="../jspf/header.jspf"%>
	<%@ include file="../jspf/main_menu.jspf"%>

	<c:choose>

		<c:when test="${sessionScope.user == null}">
					You need to be loggined in
				</c:when>

		<c:otherwise>
			<div class="form-style-8">
				<h2>Account details</h2>
				<p>
					<!--User Name:-->
					First name: ${user.firstName }
				</p>
				<p>
					<!--User LastName:-->
					Last name: ${user.lastName }
				</p>
				<p>
					<!--Email:-->
					E-mail: ${user.email }
				</p>
				<p>
					<!--Date of birth:-->
					Year of birth: ${user.age }
				</p>
				<p>
					<!--Phone:-->
					Phone: ${user.phone }
				</p>

				<a class="box" href="./account/editUser">Edytuj</a>
				<a class="box" href="./account/delete">Usuń</a>
			</div>
		</c:otherwise>
	</c:choose>
	<%@ include file="../jspf/footer.jspf"%>
	
</body>
</html>