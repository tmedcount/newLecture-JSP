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
		//list?f=title&q=a
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		
		String field = "title";
		if(field_ != null) {
			field = field_;
		}
		String query = "";
		if(query_ != null) {
			query = query_;
		}
		
		NoticeService service = new NoticeService();
		List<Notice> list = service.getNoticeList(field, query, 1);
				
		request.setAttribute("list", list);
		
		request
			.getRequestDispatcher("/WEB-INF/view/notice/list.jsp")
			.forward(request, response);
	}
}
