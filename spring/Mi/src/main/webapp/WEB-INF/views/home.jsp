<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<img src="${cp}/resources/OIP.jpg" class="left" alt="리트리버">

<br><br>       <!-- 칸 띄우기용 -->

<a href="${cp}/test/getOnePlusTwo">1+2 결과 보러가기</a>  //  


<a href="${cp}/guest/getList?currentPage=1">[방명록]</a>  //  
<%-- <a href="${cp}/guest/getList?currentPage=1">[방명록]</a> --%>              <!--페이지 1 수정 -->

<a href="${cp}/guest/read?bno=1">방명록 1번글 보기</a>  //  

<a href="${cp}/guest/write">방명록 글쓰러 가기</a>  //  

<a href="${cp}/guest/modify?bno=2">방명록 2번글 수정하러 가기</a>  //  

<a href="${cp}/weather/w">날씨</a>  //  

<a href="${cp}/member/reg"> 회원가입 </a><hr>

<form action="/member/login">
	<input name="id" placeholder="id:" value="${cookieSavedId}">
	<input name="pw" placeholder="pw:">
	<input type="checkbox" name="saveId">아이디 저장
	<input type="submit" value="로그인">
</form>

세션에 저장된 아이디: ${savedId}

</body>
</html>