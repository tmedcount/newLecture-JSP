package com.newlecture.web.service;

import java.util.*;

import com.newlecture.web.entity.*;

public class NoticeService {
	public List<Notice> getNoticeList() {
		
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page) {
		
		return getNoticeList("title", "", page);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page) {
		String sql = "SELECT * FROM ("
				+ "    SELECT ROWNUM NUM, N.* "
				+ "    FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N "
				+ ") "
				+ "WHERE NUM BETWEEN 6 AND 10"; //변수화 필요
		
		return null;
	}
	
	public int getNoticeCount() {
		
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) {
		String sql = "SELECT * FROM ("
				+ "    SELECT ROWNUM NUM, N.* "
				+ "    FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) N "
				+ ") "
				+ "WHERE NUM BETWEEN 6 AND 10"; //수정 필요
		
		return 0;
	}
	
	public Notice getNotice(int id) {
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		String sql = "SELECT * FROM NOTICE "
				+ "WHERE ID = ( "
				+ "    SELECT ID FROM ( "
				+ "        SELECT ROWNUM NUM, N.ID "
				+ "        FROM (SELECT * FROM NOTICE WHERE ID > 3) N " //수정 필요
				+ "    ) "
				+ "    WHERE NUM = 1 "
				+ ")";
		
		return null;
	}
	
	public Notice getNextNotice(int id) {
		
		return null;
	}
}
