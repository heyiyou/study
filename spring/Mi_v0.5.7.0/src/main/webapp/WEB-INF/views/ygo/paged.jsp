<%@page import="com.peisia.dto.YgoCardItemDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>카드 목록</title>
</head>
<body>
    <h2>카드 목록 </h2><%--  (페이지 ${pageNo}) --%>
	<%
		YgoCardItemDto cards = (YgoCardItemDto)request.getAttribute("cards");
		
	%>
        <p>
            <strong><%=cards.cardName %></strong><br>
            속성: <%=cards.attribute %> / 공격력: <%=cards.atk %> / 수비력: <%=cards.def%><br>
            설명: <%=cards.desc%>
        </p>
        <hr>
    <p>
        <%-- <a href="/ygo/paged?page=${pageNo - 1}">[이전]</a> --%>
        |
        <%-- <a href="/ygo/paged?page=${pageNo + 1}">[다음]</a> --%>
    </p>
</body>
</html>