<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

글 읽기
<hr>
글번호:${read.bno}
<hr>
글내용:${read.btext}

<%-- <a href="/guest/del?bno=<%=bno%>">글 삭제</a> --%>
<a href="${cp}/guest/del?bno=${read.bno}">글 삭제</a>


<%-- <a href="/guest/modify?bno=<%=bno%>">글 수정</a> --%>
<a href="${cp}/guest/modify?bno=${read.bno}">글 수정</a>


<a href="${cp}/guest/getList">글 리스트</a>

</body>
</html>


<%-- 
글 읽기
<hr>
글번호:${read.bno}
<hr>
글내용:${read.btext}
 --%>