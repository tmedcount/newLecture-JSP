package com.newlecture.web;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/spaghetti")
public class Spaghetti extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if(num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		
		String result;;
		if(num%2 != 0) {
			result = "홀수";
		} else {
			result = "짝수";
		}
		
		request.setAttribute("result", result);
		
		String[] names = {"newlec", "dragon"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요");
		request.setAttribute("notice", notice);
		
		//forward - 현재 작업한 내용을 이어 갈 수 있게 공유 cf.) redirect
		RequestDispatcher dispatcher = request.getRequestDispatcher("spaghetti.jsp");
		dispatcher.forward(request, response);
	}
}
