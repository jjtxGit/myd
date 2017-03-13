package com.shxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.sql.visitor.functions.Function;
import com.shxt.dbutil.DBUtil;
import com.shxt.entity.Food;
import com.shxt.entity.FoodComment;
import com.shxt.entity.Shope;
import com.shxt.entity.infor.FoodInfor;

public class FoodDao {

	private FoodDao() {
	}

	private static FoodDao foodDao = null;

	public static FoodDao getInstance() {
		if (foodDao == null) {

			foodDao = new FoodDao();
		}
		return foodDao;
	}

	/**
	 * 添加一个食物
	 * 
	 * @param food
	 */
	public void addFood(Food food) {

		Connection connection = DBUtil.getConnetion();

		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("insert into food(name,type,price,shopid,picpath,des) values (?,?,?,?,?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			ps.setString(1, food.getName());
			ps.setInt(2, food.getType());
			ps.setDouble(3, food.getPrice());
			ps.setInt(4, food.getShopeId());
			ps.setString(5, food.getPicPath());
			ps.setString(6, food.getDes());
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
	 * 获取食品的总数
	 * 
	 * @return
	 */
	public int getcount() {
		int count = 0;
		Connection connection = DBUtil.getConnetion();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			ResultSet rs = statement.executeQuery("select count(*) from food");

			if (rs.next()) {
				count = rs.getInt(1);
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

		return count;

	}

	/**
	 * 获取最大的id
	 * 
	 * @return
	 */
	public int getMaxId() {
		int count = 0;
		Connection connection = DBUtil.getConnetion();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			ResultSet rs = statement.executeQuery("select max(id) from food");

			if (rs.next()) {
				count = rs.getInt(1);
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

		return count;
	}

	/**
	 * 删除一个食品的信息
	 * 
	 * @param foodid
	 */
	public void deleteFood(int foodid) {
		Connection connection = DBUtil.getConnetion();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {

			statement.executeUpdate("delete from food where id=" + foodid);

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
	 * 获取所有食物信息
	 * 
	 * @return
	 */
	public List<FoodInfor> getFoodInfors() {
		Connection connection = DBUtil.getConnetion();

		List<FoodInfor> list = new ArrayList<FoodInfor>();
		FoodInfor foodInfor = null;
		Food food = null;
		Shope shope = null;

		int goodLevel = 0;
		int badLevel = 0;
		int normalLevel = 0;

		List<String> comments = new ArrayList<String>();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			ResultSet rs = statement.executeQuery("select * from food");

			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int type = rs.getInt("type");
				double price = rs.getDouble("price");
				int shopeid = rs.getInt("shopid");
				String picpath = rs.getString("picpath");
				String des = rs.getString("des");

				food = new Food();
				food.setName(name);
				food.setPicPath(picpath);
				food.setType(type);
				food.setShopeId(shopeid);
				food.setDes(des);
				food.setPrice(price);
				food.setId(id);

				shope = ShopeDao.getInstance().getShopeById(shopeid);
				goodLevel = FoodCommentDao.getInstance().getGoodLevelByFoodid(food.getId());
				badLevel = FoodCommentDao.getInstance().getBadLevelByFoodid(food.getId());
				normalLevel = FoodCommentDao.getInstance().getNormalLevelByFoodid(food.getId());
				comments = FoodCommentDao.getInstance().getCommentByFoodid(food.getId());

				foodInfor = new FoodInfor();

				foodInfor.setBadLevel(badLevel);
				foodInfor.setComments(comments);
				foodInfor.setGoodLevel(goodLevel);
				foodInfor.setNormal(normalLevel);

				foodInfor.setShope(shope);
				foodInfor.setFood(food);

				list.add(foodInfor);

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

	/**
	 * 通过id获取一个food对象
	 * 
	 * @return
	 */
	public Food getfoodById(int foodid) {
		Food food = null;
		Connection connection = DBUtil.getConnetion();

		try {

			PreparedStatement ps = connection.prepareStatement("select * from food where id =?");
			ps.setInt(1, foodid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int type = rs.getInt("type");
				double price = rs.getDouble("price");
				int shopid = rs.getInt("shopid");
				String picpath = rs.getString("picpath");
				String des = rs.getString("des");

				food = new Food();

				food.setDes(des);
				food.setId(id);
				food.setName(name);
				food.setPicPath(picpath);
				food.setPrice(price);
				food.setShopeId(shopid);
				food.setType(type);
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

		return food;

	}

	/**
	 * 获取关于该食物的评论
	 * 
	 * @param foodid
	 * @return
	 */
	
	public List<FoodComment> getFoodCommentById(int foodid) {

		List<FoodComment> lists = new ArrayList<FoodComment>();
	
		FoodComment foodComment = null;

		Connection connection = DBUtil.getConnetion();

		try {
		
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select comment,level,time from foodcomment where foodid=" + foodid);

			String comment = "";

			int level = 0;

			String time = "";
			while (rs.next()) {

				comment = rs.getString("comment");
				level = rs.getInt("level");
				time = rs.getString("time");

				foodComment = new FoodComment();
				foodComment.setComment(comment);
				foodComment.setLevel(level);
				foodComment.setTime(time);

				lists.add(foodComment);

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
		
		return lists;
	}

}
