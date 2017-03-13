package com.shxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.VipService;

public class VipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VipService vipService = null;

	public VipServlet() {
		super();
		vipService = VipService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String optype = request.getParameter("optype");

		System.out.println("there is vipServlet and optype=" + optype);

		switch (optype) {

		case "addVip":
			vipService.addVip(request, response);
			break;

		case "verifyName":
			vipService.verifyName(request, response);

			break;

		case "verifyMail":
			vipService.verifyMail(request, response);
			break;

		case "saveVip":
			vipService.saveVip(request, response);
			break;

		case "verifyVip":
			vipService.verifyVip(request, response);
			break;

		case "loginVip":
			vipService.loginVip(request, response);
			break;

		case "addToCart":
			vipService.addToCart(request, response);
			break;

		case "vip":// vipÖ÷Ò³
			vipService.vip(request, response);

			break;
		case "buyFromShoppingCart":

			vipService.buyFromShoppingCart(request, response);
			break;

		case "removeFromShoppingCart":
			vipService.removeFromShoppingCart(request, response);
			break;

		case "confirmBill":
			vipService.confirmBill(request, response);

			break;

		case "commentFood":
			vipService.commentFood(request, response);
			break;

		case "commentShope":
			vipService.commentShope(request, response);
			break;

		case "buyItNow":
			vipService.buyItNow(request, response);

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
