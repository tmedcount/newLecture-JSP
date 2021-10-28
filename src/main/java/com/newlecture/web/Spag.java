package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = 0;

		String num_ = req.getParameter("n");
		if(num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		
		String result;
		
		if(num%2 != 0) {
			result = "홀수";
		} else {
			result = "짝수";
		}
		
		// 서버 저장소(4개) cf. )클라이언트(1개 - cookie)
		// 1) 하나의 서블릿 페이지에 대한 저장소 - pageContext
		// 2) 하나의 WebApplication에 대한 저장소 - ServletContext
		// 3) forward관계에서 사용되는 저장소 - request
		// 4) 특정 session에 대한 저장소 - session
		
		req.setAttribute("result", result);

		String[] names = {"newlec", "yamto"};
		req.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요!");
		req.setAttribute("notice", notice);
		
		// forward => 일을 이어간다. cf. )redirect => 새로 요청.
		RequestDispatcher dispatcher = req.getRequestDispatcher("spag.jsp");
		dispatcher.forward(req, resp);
		
	}
}
