package com.newlecture.web;

import java.io.IOException;

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
			result = "Ȧ��";
		} else {
			result = "¦��";
		}
		
		// ���� �����(4��) cf. )Ŭ���̾�Ʈ(1�� - cookie)
		// 1) �ϳ��� ���� �������� ���� ����� - pageContext
		// 2) �ϳ��� WebApplication�� ���� ����� - ServletContext
		// 3) forward���迡�� ���Ǵ� ����� - request
		// 4) Ư�� session�� ���� ����� - session
		
		req.setAttribute("result", result);
		
		// forward => ���� �̾��. cf. )redirect => ���� ��û.
		RequestDispatcher dispatcher = req.getRequestDispatcher("spag.jsp");
		dispatcher.forward(req, resp);
		
	}
}
