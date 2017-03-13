package com.shxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.mail.search.StringTerm;

import org.apache.catalina.User;

import com.shxt.dbutil.DBUtil;
import com.shxt.entity.Food;
import com.shxt.entity.Shope;
import com.shxt.entity.ShopeComment;
import com.shxt.entity.Vip;
import com.shxt.page.entity.ShopeOrder;

public class ShopeDao {

	private ShopeDao() {
	}

	private static ShopeDao shopeDao = null;

	public static ShopeDao getInstance() {
		if (shopeDao == null) {
			shopeDao = new ShopeDao();
		}
		return shopeDao;
	}

	/**
	 * 将一个店铺的信息保存到临时表里(这是第一步 ，第一步不保存图片的路径位置)
	 * 
	 * @param shope
	 * @return
	 */
	public boolean saveShope1(Shope shope) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(
					"insert into shope_temp(name,paw,shopename,pnum,mail,adress,logopath) values(?,?,?,?,?,?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.setString(1, shope.getName());
			ps.setString(2, shope.getPaw());
			ps.setString(3, shope.getShopName());
			ps.setString(4, shope.getPnum());
			ps.setString(5, shope.getMail());
			ps.setString(6, shope.getAdress());
			ps.setString(7, shope.getLogopath());

			ps.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
	 * 保存logo的图片路径
	 * 
	 * @param mail
	 * @param logoPath
	 * @return
	 */
	public boolean saveImgLogopath(String mail, String logoPath) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement("update shope_temp set logopath =? where mail =?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pStatement.setString(1, logoPath);
			pStatement.setString(2, mail);
			pStatement.executeUpdate();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();

			return false;
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
	 * 验证商铺的登陆信息
	 * 
	 * @param name
	 * @param paw
	 * @return
	 */

	public boolean verifyShope(String name, String paw) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("select count(*) from shope where name=? and paw =? ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.setString(1, name);
			ps.setString(2, paw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return 1 == rs.getInt(1);
			}
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
	 * 根据name获取id
	 * 
	 * @param name
	 * @return
	 */
	public int getIdByName(String name) {
		Connection connection = DBUtil.getConnetion();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ResultSet rs = statement.executeQuery("select id from shope where name ='" + name + "'");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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
	 * 通过id获取商铺好评数
	 * 
	 * @param id
	 * @return
	 */
	public int getGooDLevelById(int id) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("select count(*) from shopcomment where level=3 and shopid =?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.setInt(1, id);
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				return rSet.getInt(1);
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

		return 0;

	}

	/**
	 * 通过id获取商铺中评数
	 * 
	 * @param id
	 * @return
	 */
	public int getNormalLevelById(int id) {
		Connection connection = DBUtil.getConnetion();

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("select count(*) from shopcomment where level=2 and shopid =?");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			ps.setInt(1, id);
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				return rSet.getInt(1);
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

		return 0;

	}

	/**
	 * 通过id获取商铺差评数
	 * 
	 * @param id
	 * @return
	 */
	public int getBadLevelById(int id) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("select count(*) from shopcomment where level=1 and shopid =?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.setInt(1, id);
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				return rSet.getInt(1);
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

		return 0;

	}

	/**
	 * 根据id获取一个shope对象
	 * 
	 * @param id
	 * @return
	 */
	public Shope getShopeById(int id) {
		Shope shope = new Shope();
		Connection connection = DBUtil.getConnetion();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			ResultSet rs = statement.executeQuery("select * from shope where id =" + id);

			if (rs.next()) {

				String name = rs.getString("name");
				String shopName = rs.getString("shopeName");
				String paw = rs.getString("paw");
				String pnum = rs.getString("pnum");
				String mail = rs.getString("mail");
				String adress = rs.getString("adress");
				String logopath = rs.getString("logopath");
				int opened = rs.getInt("opened");

				shope.setId(id);
				shope.setName(name);
				shope.setPaw(paw);
				shope.setShopName(shopName);
				shope.setPnum(pnum);
				shope.setMail(mail);
				shope.setAdress(adress);
				shope.setOpened(opened);
				shope.setLogopath(logopath);

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
		return shope;
	}

	/**
	 * 获取一个商铺里的所有的食品
	 * 
	 * @param Shopeid
	 * @return
	 */

	public List<Food> getFoodsByShopeId(int Shopeid) {
		List<Food> list = new ArrayList<Food>();
		Connection connection = DBUtil.getConnetion();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement("select * from food where shopid=?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			pStatement.setInt(1, Shopeid);
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {

				Food food = new Food();

				int id = rSet.getInt("id");
				String name = rSet.getString("name");
				int type = rSet.getInt("type");
				double price = rSet.getDouble("price");
				String picpath = rSet.getString("picpath");

				food.setId(id);
				food.setName(name);
				food.setType(type);
				food.setShopeId(Shopeid);
				food.setPrice(price);
				food.setPicPath(picpath);

				list.add(food);
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
	 * 获取所有的与该店铺的评论
	 * 
	 * @param shopeId
	 * @return
	 */

	public List<ShopeComment> getCommentsByid(int shopeId) {
		Connection connection = DBUtil.getConnetion();
		List<ShopeComment> shopeComments = new ArrayList<ShopeComment>();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			ResultSet rs = statement.executeQuery("select * from shopcomment where shopid =" + shopeId);
			while (rs.next()) {

				ShopeComment shopeComment = new ShopeComment();

				int id = rs.getInt("id");
				int userid = rs.getInt("userid");
				int level = rs.getInt("level");
				String time = rs.getString("time");
				String comment = rs.getString("comment");

				shopeComment.setComment(comment);
				shopeComment.setId(id);
				shopeComment.setUserid(userid);
				shopeComment.setLevel(level);
				shopeComment.setTime(time);

				shopeComments.add(shopeComment);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return shopeComments;

	}

	/**
	 * 更新商品数据的第一步
	 * 
	 * @param shope
	 */

	public void updateShopeInfor1(Shope shope) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("update shope set shopename=?,pnum=?,mail=?,adress=? where id=?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			ps.setString(1, shope.getShopName());
			ps.setString(2, shope.getPnum());
			ps.setString(3, shope.getMail());
			ps.setString(4, shope.getAdress());

			ps.setInt(5, shope.getId());

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

	}

	/**
	 * 改变店铺的营业状态
	 * 
	 * @param opened
	 * @param name
	 */
	public void changeOpened(int opened, String name) {
		Connection connection = DBUtil.getConnetion();
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement("update shope set opened =? where name = ?");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			pStatement.setInt(1, opened);
			pStatement.setString(2, name);

			pStatement.executeUpdate();

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
	 * 通过id获取商铺的名字
	 * 
	 * @param shopeid
	 */
	public String getNameById(int shopeid) {

		Connection connection = DBUtil.getConnetion();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ResultSet rs = statement.executeQuery("select shopename from shope where id =" + shopeid);
			if (rs.next()) {
				return rs.getString(1);
			}
			return "";
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<ShopeOrder> getShopeBillbyShopeId(int shopeId) {

		List<ShopeOrder> list = new ArrayList<>();
		Connection connection = DBUtil.getConnetion();
		ShopeOrder shopeOrder = null;
		try {

			PreparedStatement ps = connection.prepareStatement(
					"select userid,food.id from food,orderform where food.id=orderform.foodid and orderform.STATUS =1 and food.shopid =? ");

			ps.setInt(1, shopeId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int userid = rs.getInt("userid");

				int foodid = rs.getInt(2);

				
				Food food = FoodDao.getInstance().getfoodById(foodid);
				Vip user = VipDao.getInstance().getVipById(userid);

				shopeOrder = new ShopeOrder();
				shopeOrder.setFood(food);
				shopeOrder.setUser(user);

				list.add(shopeOrder);

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

		return list;

	}
}