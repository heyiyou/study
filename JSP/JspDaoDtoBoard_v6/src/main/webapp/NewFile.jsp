<%@ page import="com.peisia.db.Da"%>
<%@ page import="com.peisia.db.Dto"%>
<%@ page import="com.peisia.db.Db"%>
<%@ page import="com.peisia.db.Dao"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>insert title here</title>
</head>
<body>
	글번호,제목, 작성자
	<hr>
	<%
	String pageNum = request.getParameter("page");
	pageNum = "1";
	if (pageNum == null) {
	}
	Dao dao = new Dao();
	int totalPage = 0;
	ArrayList<Dto> posts = null;
	String searchWord = request.getParameter("word");
	if (searchWord == null || searchWord.equals("null")) {
		posts = dao.list(pageNum);
		totalPage = dao.getTotalPageCount();
	} else {
		posts = dao.listSearch(searchWord, pageNum);
		totalPage = dao.getSearchTotalPageCount(searchWord);
	}
	for (int i = 0; i < posts.size(); i = i + 1) {
	%>
	<%=posts.get(i).no%>
	<a href="read.jsp?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
	<%=posts.get(i).id%>
	<hr>
	<%
	}
	%>
</body>
</html>