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
		
		// get, post �� ���� ó�� �ʿ�. => super.service() override�� ���� + get, post ovrride�� ����.
		if(req.getMethod().equals("GET")) {
			System.out.println("GET��û�� �Խ��ϴ�.");
		} else if(req.getMethod().equals("POST")) {
			System.out.println("POST��û�� �Խ��ϴ�.");
		}
		
		super.service(req, resp);
		
	}
	
	// get, post ���� ó��. => service() override ����.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet �޼ҵ尡 ȣ�� �Ǿ����ϴ�.");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost �޼ҵ尡 ȣ�� �Ǿ����ϴ�.");
	}
}
