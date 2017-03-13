package com.shxt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImgServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String imgPath = request.getParameter("imgpath");

		System.out.println("there is imgservlet and imgpath=" + imgPath);

		File file = new File(imgPath);

		InputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		int length = 0;
		byte bytes[] = new byte[1024];

		while ((length = is.read(bytes)) != -1) {
			os.write(bytes, 0, length);
		}
		
		is.close();
		
		os.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}