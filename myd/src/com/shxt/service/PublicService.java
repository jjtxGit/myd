package com.shxt.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shxt.dao.FoodDao;
import com.shxt.entity.infor.FoodInfor;

public class PublicService {

	private FoodDao foodDao = null;

	private PublicService() {
		foodDao = FoodDao.getInstance();

	}

	private static PublicService publicService = null;

	public static PublicService getInstance() {
		if (publicService == null) {
			publicService = new PublicService();
		}
		return publicService;
	}

	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<FoodInfor> list = null;

		list = foodDao.getFoodInfors();

		request.setAttribute("foodInfors", list);

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
