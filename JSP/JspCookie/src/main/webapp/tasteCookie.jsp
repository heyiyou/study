<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie [] cookies = request.getCookies();
	System.out.println("쿠키길이:"+cookies.length);
	if(cookies!=null){
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("myCookie")){
%>
				쿠키 이름: <%=cookies[i].getName() %>
				쿠키 값: <%=cookies[i].getValue() %>

<%				
			}
		}
	}
%>
<a href="index.html">홈으로</a>
<hr>
EL 로 쿠키 키 myCookie 의 값 찍어보기 :
${cookie.myCookie.value}

</body>
</html>