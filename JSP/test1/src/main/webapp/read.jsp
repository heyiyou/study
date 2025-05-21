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
String no=request.getParameter("no");

Da dao=new Da();
Dto d=dao.read(no);
%>

<%=d.no%>
<%=d.title%>
<%=d.id%>
<%=d.text%>

</body>
</html>