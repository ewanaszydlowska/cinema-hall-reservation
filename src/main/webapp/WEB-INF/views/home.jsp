<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="jspf/header.jspf"%>
<%@ include file="jspf/main_menu.jspf"%>

${message}

<c:choose>
	<c:when test="${sessionScope.user.firstName!=null}">
		<p>Logged as: ${user.firstName} ${user.lastName}</p>
	</c:when>
</c:choose>

<%@ include file="jspf/footer.jspf"%>