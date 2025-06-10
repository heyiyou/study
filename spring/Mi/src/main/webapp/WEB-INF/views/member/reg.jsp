<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->
<link rel="stylesheet" href="${cp}/resources/common.css" >

<div class="login-box">
    <h2>회원가입</h2>
    <form action="${cp}/member/regProc" method="post">
        <input type="text" name="id" placeholder="아이디">
        <input type="password" name="pw" placeholder="비밀번호">
        <input type="text" name="name" placeholder="이름">
        <input type="submit" value="회원가입"></input>
    </form>
</div>