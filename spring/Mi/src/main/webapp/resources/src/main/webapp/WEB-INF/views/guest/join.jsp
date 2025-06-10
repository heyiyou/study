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
    <h2>회원가입</h2>
    <form action="${cp}/member/join" method="post">
        <input type="text" name="id" placeholder="아이디">
        <input type="password" name="pw" placeholder="비밀번호">
        <input type="text" name="name" placeholder="이름">
        <button type="submit">회원가입</button>
    </form>
</div>
</body>
</html>