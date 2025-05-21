package com.peisia.jw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletHelloWorld")        // 이거 주소 ServletHelloworld 를 바꾸면 됨 예) xxx sk sss 로 뭐든 페이지 주소
public class ServletHelloWorld extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/* PrintWriter out = response.getWriter(); */        //JSP 자주 사용      ^위에 resp를 response 로 바꾸면 됨
		
		 PrintWriter out = resp.getWriter();           // 서블릿 코드에서 자주 사용
		out.println("<h1> dogs.png </h1>");  //나오게 하는거 저기에 친구들 이라고 처도 나옴
	}
}
