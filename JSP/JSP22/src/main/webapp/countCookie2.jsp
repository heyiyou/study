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
	int cookieCount = 0;
	Cookie [] cookies = request.getCookies();
	if(cookies!=null){
		for(Cookie cookie :cookies){
			String name = cookie.getName();
			if(name.equals("cookieCount")){
				cookieCount = Integer.parseInt(cookie.getValue());
			}
		}
	}
	cookieCount++;
%>
	방문자 수 : <%=cookieCount%>

<%
	Cookie cookie = new Cookie("cookieCount", cookieCount + "" );
	response.addCookie(cookie);
	System.out.println("방문자수:"+cookies.length);
%>
			

			
			
	




</body>
</html>
