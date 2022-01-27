package com.newlecture.web.controller.admin.notice;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request
			.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp")
			.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; UTF-8");
		
		PrintWriter out = response.getWriter();
		out.printf("title: %s<br >", title);
		out.printf("content: %s<br >", content);
		out.printf("open: %s<br >", isOpen);
	}
}
