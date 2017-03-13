package com.shxt.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

import com.google.zxing.qrcode.encoder.QRCode;
import com.mysql.jdbc.Field;
import com.shxt.dao.ShopeDao;
import com.shxt.entity.Food;
import com.shxt.entity.Shope;
import com.shxt.entity.ShopeComment;
import com.shxt.page.entity.FoodBill;
import com.shxt.page.entity.ShopeOrder;
import com.shxt.page.entity.ShopePage;
import com.shxt.util.QRCodeUtil;

public class ShopeService {

	private ShopeDao shopeDao = null;

	private ShopeService() {
		shopeDao = ShopeDao.getInstance();
	}

	private static ShopeService shopeService = null;

	public static ShopeService getInstance() {
		if (shopeService == null) {
			shopeService = new ShopeService();
		}
		return shopeService;
	}

	/**
	 * 添加商铺的第一步
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void addShope1(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Shope shope = new Shope();

		String name = request.getParameter("name");
		String paw = request.getParameter("paw");
		String shopeName = request.getParameter("shopename");
		String pnum = request.getParameter("pnum");
		String mail = request.getParameter("mail");
		String adress = request.getParameter("adress");

		shope.setName(name);
		shope.setShopName(shopeName);
		shope.setPaw(paw);
		shope.setAdress(adress);
		shope.setMail(mail);
		shope.setPnum(pnum);

		shopeDao.saveShope1(shope);

		response.sendRedirect("/myd/store_add2.jsp?mail=" + mail);

	}

	/**
	 * 添加商铺的第二步
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	public void addShope2(HttpServletRequest request, HttpServletResponse response) throws IOException {

		DiskFileItemFactory dff = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dff);

		FileItemIterator fii = null;
		FileItemStream fis = null;
		InputStream is = null;

		String mail = "";

		try {
			fii = sfu.getItemIterator(request);

			while (fii.hasNext()) {

				fis = fii.next();
				is = fis.openStream();

				if (fis.isFormField()) {

					mail = Streams.asString(is);

				} else {
					saveImg(is, mail);
					shopeDao.saveImgLogopath(mail, "E:\\shopimgs\\" + mail + ".jpg");
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/myd/alertMsg.jsp?url=/myd/main.html");

	}

	/**
	 * 把图片保存到本地文件夹下 ，并以 mail 来命名
	 * 
	 * @param is
	 * @param name
	 * @throws IOException
	 */

	private void saveImg(InputStream is, String name) throws IOException {

		File file = new File("E:\\shopimgs\\" + name + ".jpg");

		System.err.println("there is shopeImgs and imgpath=" + file.getAbsolutePath());

		if (!file.exists()) {
			file.createNewFile();
		} else {

			file.delete();
		}

		byte bytes[] = new byte[1024];
		int length = 0;

		FileOutputStream fos = new FileOutputStream(file);

		while ((length = is.read(bytes)) != -1) {
			fos.write(bytes, 0, length);
		}

		fos.close();
		is.close();

	}

	/**
	 * 判断用户名是否存在并返回结果
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void verifyShope(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String paw = request.getParameter("paw");

		boolean result = shopeDao.verifyShope(name, paw);
		PrintWriter out = response.getWriter();
		out.print(result);

	}

	/**
	 * 商铺登陆
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void loginShope(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String shopename = request.getParameter("name");
		HttpSession session = request.getSession();

		session.setAttribute("shopeName", shopename);
		response.sendRedirect("/myd/shopeServlet.action?optype=manage");
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void getinShope(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	/**
	 * 转到商铺的个人主页
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void Shope(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String shopeName = (String) session.getAttribute("shopeName");
		int shopeId = shopeDao.getIdByName(shopeName);

		System.err.println("this is shopeService and shopeid=" + shopeId);

		ShopePage shopePage = new ShopePage();

		int goodLevel = shopeDao.getGooDLevelById(shopeId);
		int normalLevel = shopeDao.getNormalLevelById(shopeId);
		int badLevel = shopeDao.getBadLevelById(shopeId);

		List<ShopeComment> shopeComments = shopeDao.getCommentsByid(shopeId);
		List<Food> foods = shopeDao.getFoodsByShopeId(shopeId);
		Shope shope = shopeDao.getShopeById(shopeId);

		shopePage.setOpened(shope.getOpened());
		shopePage.setName(shope.getName());
		shopePage.setAdress(shope.getAdress());
		shopePage.setLogopath(shope.getLogopath());
		shopePage.setMail(shope.getMail());
		shopePage.setPnum(shope.getPnum());
		shopePage.setId(shopeId);
		shopePage.setShopName(shope.getShopName());

		shopePage.setGoodLevel(goodLevel);
		shopePage.setBadLevel(badLevel);
		shopePage.setNormalLevel(normalLevel);
		shopePage.setComments(shopeComments);
		shopePage.setFoods(foods);

		request.setAttribute("shopePage", shopePage);
		request.getRequestDispatcher("shope.jsp").forward(request, response);

	}

	/**
	 * 显示用户的信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showShopeInfor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("shopeId");
		int id = Integer.parseInt(idString);
		Shope shope = null;

		shope = shopeDao.getShopeById(id);

		request.setAttribute("shope", shope);

		request.getRequestDispatcher("show_shope_infor.jsp").forward(request, response);

	}

	/**
	 * 开始修改店铺信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateShopeInfor1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Shope shope = null;

		shope = shopeDao.getShopeById(id);

		request.setAttribute("shope", shope);

		request.getRequestDispatcher("update_shope_infor1.jsp").forward(request, response);

	}

	/**
	 * 修改店铺信息的第二步
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void updateShopeInfor2(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String idString = request.getParameter("id");

		int id = Integer.parseInt(idString);

		String shopeName = request.getParameter("shopename");

		String pnum = request.getParameter("pnum");

		String mail = request.getParameter("mail");

		String adress = request.getParameter("adress");

		Shope shope = new Shope();

		shope.setId(id);
		shope.setShopName(shopeName);
		shope.setPnum(pnum);
		shope.setMail(mail);
		shope.setAdress(adress);

		System.err.println("there is shopeService and this before shopeDao work");

		shopeDao.updateShopeInfor1(shope);

		System.err.println("there is shopeService and this after shopeDao work");

		response.sendRedirect("/myd/update_shope_infor2.jsp?mail=" + mail);

	}

	/**
	 * 更新商铺数据的第三步 ：更新商铺的图片路径
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void updateShopeInfor3(HttpServletRequest request, HttpServletResponse response) throws IOException {

		DiskFileItemFactory dff = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dff);

		FileItemIterator fii = null;
		FileItemStream fis = null;

		InputStream is = null;

		String mail = "";

		System.out.println("this is updateShopeInfor3 of shopeService ");

		try {

			fii = sfu.getItemIterator(request);

			while (fii.hasNext()) {

				fis = fii.next();
				is = fis.openStream();

				if (fis.isFormField()) {
					System.err.println("this is if fild in shopeserice");

					mail = Streams.asString(is);

				} else {
					System.err.println("this is else fild in shopeserice");
					saveImg(is, mail);
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/myd/alertMsg.jsp?url=/myd/main.html");

	}

	/**
	 * 改变营业状态
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void changeOpened(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String opendedStr = request.getParameter("opened");
		String name = request.getParameter("name");
		int opended = Integer.parseInt(opendedStr);
		shopeDao.changeOpened(opended, name);
		response.sendRedirect("/myd/shopeServlet.action?optype=loginShope&name=" + name);

	}

	/**
	 * 获取订单信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void showBill(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String shopeidStr = request.getParameter("shopeid");
		int shopeId = Integer.parseInt(shopeidStr);

		List<ShopeOrder> shopeOrders = null;

		shopeOrders = shopeDao.getShopeBillbyShopeId(shopeId);
		request.setAttribute("shopeOrders", shopeOrders);

		request.getRequestDispatcher("showShopeOrders.jsp").forward(request, response);

	}

	public void showcode(HttpServletRequest request, HttpServletResponse response) {

		String num = request.getParameter("num");

		try {
			QRCodeUtil.getIn(num);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			response.sendRedirect("/myd/showcode.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
