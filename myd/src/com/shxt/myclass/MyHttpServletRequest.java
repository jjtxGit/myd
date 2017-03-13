package com.shxt.myclass;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper {

	private String charset = "utf-8";
	private HttpServletRequest request = null;

	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	public MyHttpServletRequest(HttpServletRequest request, String charset) {
		super(request);

		this.charset = charset;
	}

	@Override
	public String getParameter(String name) {

		String parameter = super.getParameter(name);

		String requestCharSet = request.getCharacterEncoding();

		requestCharSet = requestCharSet == null ? "ISO-8859-1" : requestCharSet;

		parameter = parameter == null ? null : changeCode(parameter, requestCharSet);

		return parameter;
	}

	private String changeCode(String value, String requestCharSet) {
		try {
			return new String(value.getBytes(requestCharSet), charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return value;
		}
	}

}
