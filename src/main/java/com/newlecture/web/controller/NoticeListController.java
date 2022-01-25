package com.newlecture.web.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.newlecture.web.entity.*;
import com.newlecture.web.service.*;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService service = new NoticeService();
		List<Notice> list = service.getNoticeList();
				
		request.setAttribute("list", list);
		
		request
			.getRequestDispatcher("/WEB-INF/view/notice/list.jsp")
			.forward(request, response);
	}
}
