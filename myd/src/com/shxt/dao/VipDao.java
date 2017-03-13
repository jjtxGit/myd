package com.shxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shxt.dbutil.DBUtil;
import com.shxt.entity.Bill;
import com.shxt.entity.Food;
import com.shxt.entity.Vip;
import com.shxt.page.entity.FoodBill;

public class VipDao {

	private static VipDao vipDao = null;

	public static VipDao getInstance() {
		if (vipDao == null) {
			vipDao = new VipDao();
		}
		return vipDao;
	}

	private VipDao() {

	}

	/**
	 * 娣诲姞涓�鏉＄敤鎴蜂俊鎭�
	 * 
	 * @param vip
	 * @return
	 */
	public boolean addVip(Vip vip) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement("insert into user(name,paw,pnum,mail,adress) values (?,?,?,?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			pStatement.setString(1, vip.getName());
			pStatement.setString(2, vip.getPaw());
			pStatement.setString(3, vip.getPnum());
			pStatement.setString(4, vip.getMail());
			pStatement.setString(5, vip.getAdress());
			pStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 楠岃瘉鐢ㄦ埛鍚嶆槸鍚﹀瓨鍦�
	 * 
	 * @param name
	 * @return
	 */
	public boolean verifyName(String name) {
		Connection connection = DBUtil.getConnetion();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = statement.executeQuery("select count(*) from user where name='" + name + "'");
			if (rs.next()) {
				return rs.getInt(1) == 1;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 楠岃瘉mail鏄惁瀛樺湪
	 * 
	 * true瀛樺湪
	 * 
	 * false 涓嶅瓨鍦�
	 * 
	 * @param mail
	 * @return
	 */
	public boolean verifyMail(String mail) {
		Connection connection = DBUtil.getConnetion();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rSet = null;
		try {

			rSet = statement.executeQuery("select count(*) from user where mail='" + mail + "'");

			if (rSet.next()) {

				return rSet.getInt(1) == 1;

			}

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void saveVip(Vip vip) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection
					.prepareStatement("insert into user_temp(name,paw,pnum,adress,mail)values(?,?,?,?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pStatement.setString(1, vip.getName());
			pStatement.setString(2, vip.getPaw());
			pStatement.setString(3, vip.getPnum());
			pStatement.setString(4, vip.getAdress());
			pStatement.setString(5, vip.getMail());
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 浠庝复鏃跺尯鍙栧嚭vip
	 * 
	 * @param mail
	 * @return
	 */
	public Vip getVipByMail(String mail) {
		Connection connection = DBUtil.getConnetion();
		Vip vip = new Vip();

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("select * from user_temp where mail=?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.setString(1, mail);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				vip.setName(rs.getString("name"));
				vip.setAdress(rs.getString("adress"));
				vip.setMail(rs.getString("mail"));
				vip.setPaw(rs.getString("paw"));
				vip.setPnum(rs.getString("pnum"));
			}

			ps = connection.prepareStatement("delete from user_temp where mail=?");
			ps.setString(1, mail);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vip;

	}

	public boolean verifyVip(String name, String paw) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("select count(*) from user where name=? and paw = ? ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.setString(1, name);
			ps.setString(2, paw);
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				return rSet.getInt(1) == 1;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public int getIdByName(String name) {
		Connection connection = DBUtil.getConnetion();
		int id = -1;
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {

			ResultSet rs = statement.executeQuery("select id from user where name = '" + name + "'");
			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	/**
	 * 根据vip的id号获取其购物车里的信息
	 * 
	 * @param vipid
	 */
	public List<FoodBill> getFoodBills(int vipid) {

		List<FoodBill> list = new ArrayList<FoodBill>();
		Connection connection = DBUtil.getConnetion();

		FoodBill foodBill = null;

		try {

			PreparedStatement ps = connection
					.prepareStatement("select id,foodid,time from shopping_cart where userid=?");
			ps.setInt(1, vipid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				foodBill = new FoodBill();

				int cartId = rs.getInt("id");
				int foodId = rs.getInt("foodid");
				String time = rs.getString("time");

				Food food = FoodDao.getInstance().getfoodById(foodId);

				foodBill.setCartId(cartId);
				foodBill.setDes(food.getDes());
				foodBill.setFoodImgPath(food.getPicPath());
				foodBill.setFoodName(food.getName());
				foodBill.setFoodType(food.getType());
				foodBill.setPrice(food.getPrice());

				int shopeid = food.getShopeId();
				String shopeName = ShopeDao.getInstance().getNameById(shopeid);

				foodBill.setShopeName(shopeName);
				foodBill.setTime(time);

				list.add(foodBill);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;

	}

	/**
	 * 根据vipid获取所有的已完成订单信息
	 * 
	 * @param vipid
	 */
	public List<FoodBill> getOrderFormEds(int vipid) {

		List<FoodBill> lists = new ArrayList<FoodBill>();
		FoodBill foodBill = null;
		Connection connection = DBUtil.getConnetion();

		try {
			Statement statement = connection.createStatement();
			ResultSet rSet = statement
					.executeQuery("select id,foodid,time from orderform where status = 2 and userid =" + vipid);

			while (rSet.next()) {
				int cartId = rSet.getInt("id");
				int foodid = rSet.getInt("foodid");
				String time = rSet.getString("time");
				Food food = FoodDao.getInstance().getfoodById(foodid);
				String shopeName = ShopeDao.getInstance().getNameById(food.getShopeId());

				foodBill = new FoodBill();

				foodBill.setCartId(cartId);
				foodBill.setDes(food.getDes());
				foodBill.setFoodImgPath(food.getPicPath());
				foodBill.setFoodName(food.getName());
				foodBill.setFoodType(food.getType());
				foodBill.setFoodId(food.getId());
				foodBill.setShopeId(food.getShopeId());
				foodBill.setPrice(food.getPrice());
				foodBill.setShopeName(shopeName);
				foodBill.setTime(time);
				lists.add(foodBill);

			}

			return lists;

		} catch (SQLException e) {
			e.printStackTrace();
			return lists;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 根据vipid获取所有的未完成订单信息
	 * 
	 * @param vipid
	 */
	public List<FoodBill> getOrderFormIngs(int vipid) {

		List<FoodBill> lists = new ArrayList<FoodBill>();
		FoodBill foodBill = null;
		Connection connection = DBUtil.getConnetion();

		try {
			Statement statement = connection.createStatement();
			ResultSet rSet = statement
					.executeQuery("select id,foodid,time from orderform where status = 1 and userid =" + vipid);

			while (rSet.next()) {
				int cartId = rSet.getInt("id");
				int foodid = rSet.getInt("foodid");
				String time = rSet.getString("time");
				Food food = FoodDao.getInstance().getfoodById(foodid);
				String shopeName = ShopeDao.getInstance().getNameById(food.getShopeId());

				foodBill = new FoodBill();

				foodBill.setCartId(cartId);
				foodBill.setDes(food.getDes());
				foodBill.setFoodImgPath(food.getPicPath());
				foodBill.setFoodName(food.getName());
				foodBill.setFoodType(food.getType());
				foodBill.setPrice(food.getPrice());
				foodBill.setShopeName(shopeName);
				foodBill.setTime(time);
				lists.add(foodBill);
				foodBill.setFoodId(food.getId());
				foodBill.setShopeId(food.getShopeId());

			}

			return lists;

		} catch (SQLException e) {
			e.printStackTrace();
			return lists;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 根据id获取一个Vip对象
	 * 
	 * @param vipid
	 * @return
	 */
	public Vip getVipById(int vipid) {

		Connection connection = DBUtil.getConnetion();
		Vip vip = new Vip();
		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select name,pnum,adress,mail from user where id =" + vipid);
			while (rs.next()) {
				String name = rs.getString("name");
				String pnum = rs.getString("pnum");
				String adress = rs.getString("adress");
				String mail = rs.getString("mail");

				vip.setAdress(adress);
				vip.setId(vipid);
				vip.setMail(mail);
				vip.setName(name);
				vip.setPnum(pnum);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vip;

	}

	/**
	 * 从购物车里购买一条信息
	 * 
	 * @param cartId
	 */
	public void buyFromShoppingCart(int cartId) {

		Connection connection = DBUtil.getConnetion();
		Bill bill = new Bill();

		try {
			Statement statement = connection.createStatement();

			ResultSet rSet = statement.executeQuery("select foodid,userid from shopping_cart where id=" + cartId);
			if (rSet.next()) {

				int foodid = rSet.getInt("foodid");
				int userid = rSet.getInt("userid");
				bill.setFoodid(foodid);
				bill.setUserid(userid);

				VipDao.getInstance().addBill(bill);
				VipDao.getInstance().removeFromShoppingCart(cartId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 往订单里添加一条未完成订单
	 * 
	 * @param bill
	 */
	public void addBill(Bill bill) {
		Connection connection = DBUtil.getConnetion();

		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into orderform(foodid,userid,status)values(?,?,1)");

			ps.setInt(1, bill.getFoodid());
			ps.setInt(2, bill.getUserid());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 从购物车里移除一条食品信息
	 * 
	 * @param cartId
	 */
	public void removeFromShoppingCart(int cartId) {

		Connection connection = DBUtil.getConnetion();

		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate("delete from shopping_cart where id=" + cartId);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 确认收货，即把订单的状态由1改为2
	 * 
	 * @param orderid
	 */
	public void confirmBill(int orderid) {

		Connection connection = DBUtil.getConnetion();

		try {
			Statement statement = connection.createStatement();
			statement.execute("update orderform set status = 2 where id =" + orderid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
