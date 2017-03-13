package com.shxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.PublicService;

public class PublicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicService publicService = null;

	public PublicServlet() {
		super();
		publicService = PublicService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String optype = request.getParameter("optype");
		System.out.println("there is publicServlet and optype=" + optype);

		switch (optype) {
		case "index":

			publicService.index(request, response);

			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
