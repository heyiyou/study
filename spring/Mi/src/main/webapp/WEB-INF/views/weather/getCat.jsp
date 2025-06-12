<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.dto.SkillDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고양이 정보</title>
</head>
<body>
<%
	ArrayList<SkillDto> skill = (ArrayList<SkillDto>)request.getAttribute("catName");
%>
<%=skill.get(0).level %>
ㄷㄷㄷ
</body>
</html>