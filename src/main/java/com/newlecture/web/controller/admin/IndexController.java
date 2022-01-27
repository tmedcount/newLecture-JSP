package com.newlecture.web.controller.admin;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/admin/index")
public class IndexController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request
			.getRequestDispatcher("/WEB-INF/view/admin/index.jsp")
			.forward(request, response);
	}
}
