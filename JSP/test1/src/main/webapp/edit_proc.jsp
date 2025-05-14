<%@page import="com.peisia.db.Dto"%>
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
	request.getParameter("text")
	);
	Da dao = new Da();
	dao.edit(dto,request.getParameter("no"));
%>

</body>
</html>