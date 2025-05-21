<%@page import="com.peisia.jw.Da"%>
<%@page import="com.peisia.jw.Dto"%>
<%@page import="com.peisia.jw.Dto"%>
<%@page import="com.peisia.jw.Da"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Dto dto = new Dto(
	request.getParameter("title"),
	request.getParameter("id"),
	request.getParameter("text")
	);
	Da dao = new Da();
	dao.write(dto);
%>

</body>
