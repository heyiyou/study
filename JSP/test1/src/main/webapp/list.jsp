<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Da"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호, 제목, 작성자<hr>
<%
Da dao=new Da();
ArrayList<Dto> posts=dao.list();

for(int i=0;i<posts.size();i=i+1){
%>

<%=posts.get(i).no%>
<%=posts.get(i).title%>
<%=posts.get(i).id%>
<hr>

<%
}
%>

</body>
</html>