package com.shxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.Decoder.Text;

public class SessionFilter implements Filter {

	public SessionFilter() {
	}

	public void destroy() {
	}
	
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hRequest = (HttpServletRequest) request;
		String requestURIString = hRequest.getRequestURI();
		
		System.out.println("there is sessionFilter requestURIString=" + requestURIString);
	
		// 只过滤jsp和html
		if (requestURIString.endsWith(".jsp") || requestURIString.endsWith(".html")) {

			if (requestURIString.endsWith("login.jsp") || requestURIString.endsWith("error.html")) {
				chain.doFilter(request, response);
				return;
			}

			HttpSession session = hRequest.getSession();
			if (session.getAttribute("username") == null) {
				// if not login
				((HttpServletResponse) response).sendRedirect("/admin/error.html");
			}

		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
