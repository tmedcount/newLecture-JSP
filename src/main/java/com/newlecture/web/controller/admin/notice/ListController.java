package com.newlecture.web.controller.admin.notice;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.newlecture.web.entity.*;
import com.newlecture.web.service.*;

@WebServlet("/admin/notice/list")
public class ListController extends HttpServlet {
	//404 - url 없음
	//405 - url은 있으나 메소드 없음
	//403 - 권한 없음
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] openIds = request.getParameterValues("open-id");
		String[] delIds = request.getParameterValues("del-id");
		
		for(String openId : openIds) {
			System.out.printf("open id: %s\n", openId);
		}
		for(String delId : delIds) {
			System.out.printf("del id: %s\n", delId);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list?f=title&q=a
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		
		String field = "title";
		if(field_ != null && !field_.equals("")) {
			field = field_;
		}
		String query = "";
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		NoticeService service = new NoticeService();
		List<NoticeView> list = service.getNoticeList(field, query, page);
		int count = service.getNoticeCount(field, query);
				
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		request
			.getRequestDispatcher("/WEB-INF/view/admin/board/notice/list.jsp")
			.forward(request, response);
	}
}

