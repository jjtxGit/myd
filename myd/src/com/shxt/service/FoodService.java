package com.shxt.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

import com.mysql.jdbc.Field;
import com.shxt.dao.FoodDao;
import com.shxt.entity.Food;
import com.shxt.entity.FoodComment;

public class FoodService {

	private static FoodService foodService = null;

	public static FoodService getInstance() {
		if (foodService == null) {
			foodService = new FoodService();
		}
		return foodService;
	}

	private FoodService() {
		foodDao = FoodDao.getInstance();
	}

	private FoodDao foodDao = null;

	/**
	 * 添加食品信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	public void addFood(HttpServletRequest request, HttpServletResponse response) throws IOException {

		DiskFileItemFactory dff = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dff);
		FileItemIterator fii = null;
		FileItemStream fis = null;
		InputStream is = null;

		int count = 0;

		String countOffood = foodDao.getMaxId() + "";

		String shopeId = "";
		String foodname = "";
		String foodprice = "";
		String foodtype = "";
		String des = "";

		try {
			fii = sfu.getItemIterator(request);

			while (fii.hasNext()) {

				fis = fii.next();
				is = fis.openStream();

				if (fis.isFormField()) {
					count++;

					switch (count) {

					case 1:
						shopeId = Streams.asString(is, "utf-8");
						break;

					case 2:
						foodname = Streams.asString(is, "utf-8");
						break;

					case 3:
						foodprice = Streams.asString(is, "utf-8");
						break;

					case 4:

						foodtype = Streams.asString(is, "utf-8");
						break;

					case 5:

						des = Streams.asString(is, "utf-8");
						break;
					}

				} else {
					saveImg(is, countOffood);
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		int shopeIdInt = Integer.parseInt(shopeId);
		int foodTypeInt = Integer.parseInt(foodtype);
		double foodPrice = Double.parseDouble(foodprice);
		String picPath = "E:\\foodimgs\\" + countOffood + ".jpg";

		Food food = new Food();
		food.setName(foodname);
		food.setPrice(foodPrice);
		food.setPicPath(picPath);
		food.setShopeId(shopeIdInt);
		food.setType(foodTypeInt);
		food.setDes(des);

		foodDao.addFood(food);
		response.sendRedirect("/myd/shopeServlet.action?optype=manage");

	}

	/**
	 * 存放图片到本地硬盘
	 * 
	 * @param is
	 * @param name
	 * @throws IOException
	 */
	private void saveImg(InputStream is, String name) throws IOException {
		File file = new File("E:\\foodimgs\\" + name + ".jpg");

		OutputStream os = new FileOutputStream(file);

		if (file.exists()) {
			file.delete();
		} else {
			file.createNewFile();
		}

		byte bytes[] = new byte[1024];
		int length = 0;

		while ((length = is.read(bytes)) != -1) {
			os.write(bytes, 0, length);
		}

		os.close();
		is.close();

	}

	/**
	 * 删除一条食物
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void deleteFood(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String foodidStr = request.getParameter("foodid");

		int foodid = Integer.parseInt(foodidStr);

		foodDao.deleteFood(foodid);

		response.sendRedirect("/myd/shopeServlet.action?optype=manage");

	}

	/**
	 * 显示食物的评论
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void showFoodComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<FoodComment> foodComments = null;
		
		
		String foodIdStr =request.getParameter("foodId");
		
		
		int foodId =Integer.parseInt(foodIdStr);
		
		foodComments=foodDao.getFoodCommentById(foodId);	
		
		request.setAttribute("foodComments", foodComments);

		
		request.getRequestDispatcher("showFoodComment.jsp").forward(request, response);
		
		

	}

}
