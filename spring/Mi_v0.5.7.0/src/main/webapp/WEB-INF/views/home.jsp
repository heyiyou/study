<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>🌟 유희왕 카드 시스템에 오신 걸 환영합니다!</h1>

	<p>📅 현재 서버 시간: ${serverTime}</p>

	<hr>

	<h3>🔗 이동 링크</h3>


		<!-- 앞 부분 조금 띄우는 역할 -->
		<a href="${cp }/ygo/paged">[1페이지]</a>
		<a href="${cp }/ygo/test">test</a>
		<%-- <li><a href="${cp }/ygo/paged?page=2">[2페이지]</a></li> --%>
		<%-- <li><a href="${cp }/ygo/paged?page=3">[3페이지]</a></li> --%>
	<a href=/ygo/paged?page=3>[3페이지]</a>



</body>
</html>
