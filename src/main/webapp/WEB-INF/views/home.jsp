<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="jspf/header.jspf"%>
<%@ include file="jspf/main_menu.jspf"%>

Home page
${message}
<%@ include file="jspf/header.jspf" %>

Logged as: <p>${msg}</p>

<a href="/cinema-hall-reservation/register">Zarejestruj sie</a>
<a href="/cinema-hall-reservation/login">Zaloguj sie</a>

<%@ include file="jspf/footer.jspf"%>