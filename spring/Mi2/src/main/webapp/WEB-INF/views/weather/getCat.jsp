<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.dto.SkillDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고양이 정보</title>
<style>

body {
	background-color: white;
	font-family: Arial, sans-serif;    /* 깔끔한 영문 폰트 적용  */
	text-align: center; /* 전체 텍스트 가운데 정렬 */
}

.container {                              /* 정렬 배치 움직이기 */
	display: flex;
	flex-direction: column;  /* 위에서 아래로 나열 */
	gap: 21px;                /* 각 박스 사이 간격 */
	margin-top: 40px ;        /* 위쪽 여백 */
}

.box {
	padding: 10px; /*전체 크기  */
	border: 10px solid gray; /*테두리 두깨 지금은 그레이  */
	border-radius: 30px; /*테두리 10px로 하면 각이짐  */
	background-color: floralwhite;
	width: 200px; /* 타원형 모양 크기 조절 */
	font-family: Arial, sans-serif;
	margin: 40px /* Auto */;
  
	/* box-shadow: 3px 3px 8px lightgray; */
}

.skill-level {
	font-size: 18px;
	color: darkslategray;
	font-weight: bold;
}

.skill-name {
	font-size: 22px;
	color: orange;
	margin-top: 5px;
}
</style>

</head>
<body>
	<%
	ArrayList<SkillDto> skill = (ArrayList<SkillDto>) request.getAttribute("catName");
	ArrayList<SkillDto> name = (ArrayList<SkillDto>) request.getAttribute("catName");
	%>


<div class="container">
	<% for (int i = 0; i < skill.size(); i++) { %>
		<div class="box">
			<div class="skill-level">레벨: <%= skill.get(i).level %></div>
			<div class="skill-name">기술 이름: <%= skill.get(i).name %></div>
			
			
		</div>
	<% } %>
</div>



<%-- 	<div class="box">
		<div class="skill-level">
			레벨:
			<%=skill.get(0).level%></div>
		<div class="skill-name">
			기술 이름:
			<%=name.get(0).name%></div>
	</div>
	
	
	<div class="box">
		<div class="skill-level">
			레벨:
			<%=skill.get(1).level%></div>
		<div class="skill-name">
			기술 이름:
			<%=name.get(1).name%></div>
	</div>

	<div class="box">
		<div class="skill-level">
			레벨:
			<%=skill.get(2).level%></div>
		<div class="skill-name">
			기술 이름:
			<%=name.get(2).name%></div>
	</div>
 --%>






</body>

</html>