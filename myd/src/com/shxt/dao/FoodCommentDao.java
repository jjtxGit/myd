package com.shxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shxt.dbutil.DBUtil;
import com.shxt.entity.FoodComment;
import com.shxt.entity.ShopeComment;

public class FoodCommentDao {

	private FoodCommentDao() {

	}

	private static FoodCommentDao foodComment = null;

	public static FoodCommentDao getInstance() {

		if (foodComment == null) {
			foodComment = new FoodCommentDao();
		}
		return foodComment;
	}

	/**
	 * 获取好评数
	 * 
	 * @param foodId
	 * @return
	 */
	public int getGoodLevelByFoodid(int foodId) {

		int count = 0;
		Connection connection = DBUtil.getConnetion();
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {

			ResultSet rs = statement
					.executeQuery("select count(*) from foodcomment where level=3 and foodid=" + foodId);

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
	 * 获取差评数
	 * 
	 * @param foodId
	 * @return
	 */
	public int getBadLevelByFoodid(int foodId) {

		int count = 0;

		Connection connection = DBUtil.getConnetion();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {

			ResultSet rs = statement
					.executeQuery("select count(*) from foodcomment where level=2 and foodid=" + foodId);

			if (rs.next()) {
				count = rs.getInt(1);
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

		return count;

	}

	/**
	 * 获取中评数
	 * 
	 * @param foodId
	 * @return
	 */
	public int getNormalLevelByFoodid(int foodId) {

		int count = 0;
		Connection connection = DBUtil.getConnetion();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {

			ResultSet rs = statement
					.executeQuery("select count(*) from foodcomment where level=2 and foodid=" + foodId);

			if (rs.next()) {
				count = rs.getInt(1);
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

		return count;

	}

	/**
	 * 根据食品id 获取所有的评论
	 * 
	 * @param foodid
	 * @return
	 */
	public List<String> getCommentByFoodid(int foodid) {
		List<String> comments = new ArrayList<String>();

		Connection connection = DBUtil.getConnetion();

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			ResultSet rs = statement.executeQuery("select comment from foodcomment where foodid = " + foodid);
			while (rs.next()) {
				String comment = rs.getString(1);
				comments.add(comment);
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
		return comments;
	}

	/**
	 * 添加一条食品的评论
	 * 
	 * @param foodComment
	 */
	public void addFoodComment(FoodComment foodComment) {
		Connection connection = DBUtil.getConnetion();
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into foodcomment(comment,foodid,level,userid) values (?,?,?,?)");
			ps.setString(1, foodComment.getComment());
			ps.setInt(2, foodComment.getFoodid());
			ps.setInt(3, foodComment.getLevel());
			ps.setInt(4, foodComment.getUserid());

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
	 * 添加一条商铺评论信息
	 * 
	 * @param shopeComment
	 */
	public void addShopeComment(ShopeComment shopeComment) {

		Connection connection = DBUtil.getConnetion();
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into shopcomment(comment,shopid,level,userid) values (?,?,?,?)");
			ps.setString(1, shopeComment.getComment());
			ps.setInt(2, shopeComment.getShopeid());
			ps.setInt(3, shopeComment.getLevel());
			ps.setInt(4, shopeComment.getUserid());

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

}
