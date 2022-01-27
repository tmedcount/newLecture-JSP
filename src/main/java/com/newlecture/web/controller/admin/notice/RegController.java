package com.newlecture.web.controller.admin.notice;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.newlecture.web.entity.*;
import com.newlecture.web.service.*;

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
		boolean pub = false;
		if(isOpen != null) {
			pub = true;
		}
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterId("newlec");
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		response.sendRedirect("list");
	}
}
