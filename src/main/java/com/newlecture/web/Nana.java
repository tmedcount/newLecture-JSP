package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String cnt_ = req.getParameter("cnt");
		int cnt = 100;
		
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
			
		for(int i=0; i<cnt; i++)
			// chrome - text, Edge - html로 해석 따라서 출력 형식을 지정해 줘야 한다.
			out.println((i+1)+": 안녕 Servlet~!<br />");
	}
}
