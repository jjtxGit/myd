package com.shxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.ShopeService;

public class ShopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopeService shopeService = null;

	public ShopeServlet() {
		super();
		shopeService = ShopeService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String optype = request.getParameter("optype");

		System.out.println("there is shopeservlet and optype=" + optype);

		switch (optype) {

		case "addShope1":
			shopeService.addShope1(request, response);
			break;

		case "addShope2":
			shopeService.addShope2(request, response);
			break;

		case "verifyShope":
			shopeService.verifyShope(request, response);
			break;

		case "loginShope":
			shopeService.loginShope(request, response);
			break;

		case "manage":
			shopeService.Shope(request, response);
			break;

		case "showShopeInfor":
			shopeService.showShopeInfor(request, response);
			break;

		case "updateShopeInfor1":
			shopeService.updateShopeInfor1(request, response);
			break;

		case "updateShopeInfor2":
			shopeService.updateShopeInfor2(request, response);
			break;

		case "updateShopeInfor3":
			shopeService.updateShopeInfor3(request, response);
			break;

		case "changeOpened":
			shopeService.changeOpened(request, response);
			break;

		case "showBill":
			shopeService.showBill(request, response);
			break;
			
		case "showcode":
			shopeService.showcode(request,response);
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
