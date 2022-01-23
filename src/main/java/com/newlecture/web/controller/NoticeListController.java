package com.newlecture.web.controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.newlecture.web.entity.*;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Notice> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE ORDER BY ID DESC";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "newlec", "rufdml13");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				
				Notice notice = new Notice(id, title, writerId, regdate, hit, files, content);
				
				list.add(notice);
			}

			rs.close();
			st.close();
			con.close();	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		request
			.getRequestDispatcher("/WEB-INF/view/notice/list.jsp")
			.forward(request, response);

	}
}
