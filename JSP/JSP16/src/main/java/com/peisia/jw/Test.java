package com.peisia.jw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	
	@Override             //get 방식은        Post 방식
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==== 두 포스트");
		System.out.println("id: "+ req.getParameter("id"));
		System.out.println("pw: "+ req.getParameter("pw"));
	
	PrintWriter out = resp.getWriter();	
	out.println("<h1>cat</h1>");	
	
	
	}
	}
	

