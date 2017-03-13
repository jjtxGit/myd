package com.shxt.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.activation.ActivationGroupID;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shxt.dao.FoodCommentDao;
import com.shxt.dao.FoodDao;
import com.shxt.dao.ShoppingCartDao;
import com.shxt.dao.VipDao;
import com.shxt.entity.Bill;
import com.shxt.entity.Food;
import com.shxt.entity.FoodComment;
import com.shxt.entity.ShopeComment;
import com.shxt.entity.Vip;
import com.shxt.page.entity.FoodBill;
import com.shxt.page.entity.VipPage;
import com.sxht.service.mail.MailSender;

public class VipService {

	private VipDao vipDao = null;

	private VipService() {
		vipDao = VipDao.getInstance();
	}

	private static VipService vipService = null;

	public static VipService getInstance() {
		if (vipService == null) {
			vipService = new VipService();
		}
		return vipService;
	}

	public void addVip(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String mail = request.getParameter("mail");

		Vip vip = vipDao.getVipByMail(mail);

		boolean result = false;

		if (!vipDao.verifyMail(mail)) {
			vipDao.addVip(vip);
			result = true;
		}

		response.sendRedirect("/myd/addResult.jsp?result=" + result);

	}

	public void verifyName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.print(vipDao.verifyName(name));
	}

	public void verifyMail(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String mail = request.getParameter("mail");
		PrintWriter out = response.getWriter();
		out.print(vipDao.verifyMail(mail));

	}

	public void saveVip(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Vip vip = new Vip();

		String name = request.getParameter("name");
		String paw = request.getParameter("paw");
		String pnum = request.getParameter("pnum");
		String mail = request.getParameter("mail");
		String adress = request.getParameter("adress");

		vip.setAdress(adress);
		vip.setMail(mail);
		vip.setName(name);
		vip.setPaw(paw);
		vip.setPnum(pnum);

		vipDao.saveVip(vip);

		MailSender mSender = new MailSender("m17839927862@163.com", "javamail00");
		mSender.sendMailTo(mail);

		mSender.setMailMessage("美易点邮箱验证系统", "欢迎使用美易点点餐系统，请点击一下链接完成邮箱认证："
				+ "http://localhost/myd/vipServlet.action?optype=addVip&mail=" + mail);
		mSender.send();
		// response.sendRedirect("/myd/main.html");
	}

	public void verifyVip(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String paw = request.getParameter("paw");
		PrintWriter out = null;
		try {

			out = response.getWriter();

		} catch (IOException e) {

			e.printStackTrace();

		}
		out.print(vipDao.verifyVip(name, paw));
	}

	/**
	 * vip登陆
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void loginVip(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String name = request.getParameter("name");
		int id = vipDao.getIdByName(name);
		HttpSession session = request.getSession();
		session.setAttribute("Vipname", name);
		session.setAttribute("Vipid", id);
		response.sendRedirect("/myd/main.html");
	}

	/**
	 * 添加到购物车
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	public void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String foodidStr = request.getParameter("foodid");

		HttpSession session = request.getSession();

		Integer userid = (Integer) session.getAttribute("Vipid");

		if (userid == null) {

			PrintWriter out = response.getWriter();
			out.print(false);
			return;

		} else {

			int foodid = Integer.parseInt(foodidStr);
			ShoppingCartDao.getInstance().addFoodToCart(foodid, userid);
			PrintWriter out = response.getWriter();
			out.print(true);

		}

	}

	/**
	 * 跳转到vip的主页面上
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void vip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VipPage vipPage = new VipPage();

		List<FoodBill> foodBills = null;
		List<FoodBill> orderFormEds = null;
		List<FoodBill> orderFormIngs = null;
		Vip vip = new Vip();

		HttpSession session = request.getSession();

		Integer vipid = (Integer) session.getAttribute("Vipid");

		if (vipid == null) {
			try {
				response.sendRedirect("/myd/error.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			foodBills = vipDao.getFoodBills(vipid);
			orderFormEds = vipDao.getOrderFormEds(vipid);
			orderFormIngs = vipDao.getOrderFormIngs(vipid);
			vip = vipDao.getVipById(vipid);

			vipPage.setFoodBills(foodBills);
			vipPage.setOrderFormEds(orderFormEds);
			vipPage.setOrderFormIngs(orderFormIngs);
			vipPage.setVip(vip);

			request.setAttribute("vipPage", vipPage);
			request.getRequestDispatcher("vip.jsp").forward(request, response);
		}

	}

	/**
	 * 从购物车里购买
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void buyFromShoppingCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		vipDao.buyFromShoppingCart(id);

		response.sendRedirect("/myd/vipServlet.action?optype=vip");
	}

	/**
	 * 从购物车里移除一条信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void removeFromShoppingCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		vipDao.removeFromShoppingCart(id);

		response.sendRedirect("/myd/vipServlet.action?optype=vip");

	}

	/**
	 * 确认收货
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void confirmBill(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String orderidStr = request.getParameter("orderid");

		int orderid = Integer.parseInt(orderidStr);

		vipDao.confirmBill(orderid);

		response.sendRedirect("/myd/vipServlet.action?optype=vip");

	}

	/**
	 * 往数据库里添加一条食物评论信息
	 * 
	 * @throws IOException
	 */
	public void commentFood(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String comment = request.getParameter("gb_word");
		String foodIdStr = request.getParameter("foodId");
		String levelStr = request.getParameter("level");
		int foodId = Integer.parseInt(foodIdStr);
		int level = Integer.parseInt(levelStr);
		FoodComment foodComment = new FoodComment();

		HttpSession session = request.getSession();

		Integer Vipid = (Integer) session.getAttribute("Vipid");

		if (Vipid == null) {
			response.sendRedirect("/myd/main.html");
			return;
		}

		foodComment.setComment(comment);
		foodComment.setFoodid(foodId);
		foodComment.setLevel(level);
		foodComment.setUserid(Vipid);

		FoodCommentDao.getInstance().addFoodComment(foodComment);

		response.sendRedirect("/myd/vipServlet.action?optype=vip");

	}

	/**
	 * 往数据库里添加一条店铺的评论信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void commentShope(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String comment = request.getParameter("gb_word");
		String shopeIdStr = request.getParameter("shopeId");
		String levelStr = request.getParameter("level");
		int shopeId = Integer.parseInt(shopeIdStr);
		int level = Integer.parseInt(levelStr);

		ShopeComment shopeComment = new ShopeComment();

		HttpSession session = request.getSession();
		Integer Vipid = (Integer) session.getAttribute("Vipid");

		if (Vipid == null) {
			response.sendRedirect("/myd/main.html");
			return;
		}

		shopeComment.setComment(comment);
		shopeComment.setShopeid(shopeId);
		shopeComment.setLevel(level);
		shopeComment.setUserid(Vipid);

		FoodCommentDao.getInstance().addShopeComment(shopeComment);

		response.sendRedirect("/myd/vipServlet.action?optype=vip");

	}

	/**
	 * 立即购买食物
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public void buyItNow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String foodidStr = request.getParameter("foodId");
		int foodid = Integer.parseInt(foodidStr);

		HttpSession session = request.getSession();

		Integer vipId = (Integer) session.getAttribute("Vipid");

		if (vipId == null) {
			Food food = FoodDao.getInstance().getfoodById(foodid);
			request.setAttribute("food", food);
			request.getRequestDispatcher("/buyFood.jsp").forward(request, response);
		} else {

			Bill bill = new Bill();
			bill.setFoodid(foodid);
			bill.setUserid(vipId);

			response.sendRedirect("/myd/main.html");

		}
	}

}
