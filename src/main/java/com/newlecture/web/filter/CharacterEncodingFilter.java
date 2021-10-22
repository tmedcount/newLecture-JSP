package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req,
			ServletResponse resp,
			FilterChain chain)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8"); //before
		
		chain.doFilter(req, resp);
		
		// after
	}

}
