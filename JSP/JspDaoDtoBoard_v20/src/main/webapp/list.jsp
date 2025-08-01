<%@page import="com.peisia.jsp.board.BoardListProcessor"%>
<%@page import="com.peisia.jsp.board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.jsp.board.dto.Dto"%>
<%@page import="com.peisia.jsp.board.dao.DaoBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fieldset>
	<legend>게시판</legend>
	글번호, 제목, 작성자<hr>
<%
BoardListProcessor blp = (BoardListProcessor)request.getAttribute("blp"); 
ArrayList<Dto> posts = blp.getPosts();




for(int i=0;i<posts.size();i=i+1){
%>

<%=posts.get(i).no%>
<a href="/board/read?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
<%=posts.get(i).id%>
<hr>
<%
}
%>
</fieldset>
<fieldset>
	<legend>페이지 블럭</legend>
	<%=blp.getHtmlPageList()%>
</fieldset>
<fieldset>
	<legend>링크</legend>
	<a href="/write.jsp">쓰기</a><a href="/board/list">list로</a><a href="/">홈으로</a>
</fieldset>
<fieldset>
	<legend>검색</legend>
	<form action="/board/list">
		<input name="word">
		<input type="submit" value="검색">
	</form>
</fieldset>
</body>
</html>