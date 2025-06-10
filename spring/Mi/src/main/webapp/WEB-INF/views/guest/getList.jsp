<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp}/resources/common.css" >        <!-- 화면 색 입히기 -->
</head>
<body>

<table>
	<tr>
		<td>글번호</td>
		<td>글내용</td>
	</tr>
<!-- jstl 로 처리하면 더 짧게 가능 -->
<c:forEach var="guest" items="${list}">
	<tr>
		<td>${guest.bno}</td>
		
		<%-- 1 버전 밑에가 2버전인데 EL버전임 <a href="/guest/read?bno=<%=bno%>"> <%=btext %> </a> --%>
		<td><a href="/guest/read?bno=${guest.bno}">${guest.btext}</a></td>
    </tr>
</c:forEach>

</table>

<div class="center">
	뭐임?${cp}
	<a href="${cp}/guest/write">새글 쓰기</a>  ========   
	
	<a href="${cp}/">홈페이지로 돌아가라!!</a>
</div>
<h1 class="center">
	동물 LOVE다
</h1>
<%-- <c:forEach var="guest" items="${list}"> --%>
<%--     <c:set var="bno" value="${guest.bno}" /> --%>
<%--     <c:set var="btext" value="${guest.btext}" /> --%>
<%--     ${bno} --%>
<%--     ${btext} --%>
<!--     <hr> -->
<%-- </c:forEach> --%>








<%-- 	Object o = request.getAttribute("list");
	ArrayList<GuestDto> list = (ArrayList<GuestDto>)o; 
	for(int i=0;i<list.size();i++){
		Long bno = list.get(i).getBno();
		String btext = list.get(i).getBtext();
%>		
		<%=bno %>	
		<%=btext %>	
		<hr>  
<%		
	}

%>
<c:forEach var="guest" items="${list}"> --%>
<%--     <c:set var="bno" value="${guest.bno}" /> --%>
<%--     <c:set var="btext" value="${guest.btext}" /> --%>
<%--     ${bno} --%>
<%--     ${btext} --%>
<!--     <hr> -->
<%-- </c:forEach> --%>


</body>
</html>