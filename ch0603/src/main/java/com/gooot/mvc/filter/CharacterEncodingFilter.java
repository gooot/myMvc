package com.gooot.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

@WebFilter("/")
public class CharacterEncodingFilter implements Filter {

	private static final String DEFAULT_ENCODING = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
		IOException,
		ServletException {

		servletRequest.setCharacterEncoding(DEFAULT_ENCODING);
		servletResponse.setCharacterEncoding(DEFAULT_ENCODING);

		filterChain.doFilter(servletRequest, servletResponse);

	}

	@Override
	public void destroy() {

	}
}
