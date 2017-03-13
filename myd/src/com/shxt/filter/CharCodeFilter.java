package com.shxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.shxt.myclass.MyHttpServletRequest;

public class CharCodeFilter implements Filter {
	public CharCodeFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String urlStr = ((HttpServletRequest) request).getRequestURI();

		System.out.println("there is charCodeFilter->>>>>" + urlStr);

		// 只过滤 jsp html 和 aciotn 文件
		if (urlStr.endsWith(".jsp") || urlStr.endsWith(".html") || urlStr.endsWith(".action")) {
			MyHttpServletRequest myRequest = new MyHttpServletRequest((HttpServletRequest) request);
			System.out.println("过滤器" + myRequest.getParameter("adress"));
			chain.doFilter(myRequest, response);
			return;
		}
		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
