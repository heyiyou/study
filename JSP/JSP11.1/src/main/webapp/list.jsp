<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<style>
    table { border-collapse: collapse; width: 80%; margin: auto; }
    th, td { border: 1px solid #888; padding: 8px; text-align: center; color:blue; }
    th { background-color: #f2f2f2; }   
     
    h2 { text-align: center; }
</style>
</head>
<body>
<h2>🐱 고양이 게시판 - 리스트</h2>
<a href="write.jsp">[글쓰기]</a> | <a href="index.jsp">[홈]</a>
<br><br>

<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
    </tr>

<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM cat_board ORDER BY num DESC");

		while (rs.next()) {
			String num = rs.getString("num");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String id = rs.getString("id");
%>
	<tr>
		<td><%= num %></td>
		<td><a href="read.jsp?num=<%= num %>"><%= title %></a></td>
		<td><%= content %></td>
		<td><%= id %></td>
	</tr>
<%
		}
		rs.close();
		st.close();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
</table>
</body>
</html>
