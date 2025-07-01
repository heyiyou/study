<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="login-box">
    <h2>로그인</h2>
    <form action="${cp}/member/login" method="post">
        <input type="text" name="id" placeholder="아이디">
        <input type="password" name="pw" placeholder="비밀번호">
        <button type="submit">로그인</button>
    </form>
    <a href="${cp}/member/join">회원가입</a>
</div>
</body>
</html>