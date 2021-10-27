package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get, post 한 번에 처리 필요. => super.service() override는 삭제 + get, post ovrride도 삭제.
		if(req.getMethod().equals("GET")) {
			System.out.println("GET요청이 왔습니다.");
		} else if(req.getMethod().equals("POST")) {
			System.out.println("POST요청이 왔습니다.");
		}
		
		super.service(req, resp);
		
	}
	
	// get, post 따로 처리. => service() override 삭제.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 메소드가 호출 되었습니다.");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 메소드가 호출 되었습니다.");
	}
}
