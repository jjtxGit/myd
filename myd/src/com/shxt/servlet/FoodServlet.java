package com.shxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.service.FoodService;

public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodService foodService = null;

	public FoodServlet() {
		super();
		foodService = FoodService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String optype = request.getParameter("optype");
		switch (optype) {

		case "addFood":
			foodService.addFood(request, response);
			break;

		case "deleteFood":
			foodService.deleteFood(request, response);
			break;
			
		case "showFoodComment":
			foodService.showFoodComment(request,response);
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
