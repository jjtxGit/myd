package com.shxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shxt.dbutil.DBUtil;

public class ShoppingCartDao {
	private static ShoppingCartDao shoppingCartDao = null;

	private ShoppingCartDao() {
	}

	public static ShoppingCartDao getInstance() {
		if (shoppingCartDao == null) {
			shoppingCartDao = new ShoppingCartDao();
		}
		return shoppingCartDao;
	}
	
	/**
	 * 给购物车里添加一条信息
	 * 
	 * @param foodid
	 * @param userid
	 */
	public void addFoodToCart(int foodid, int userid) {

		Connection connection = DBUtil.getConnetion();
		try {
			PreparedStatement ps = connection.prepareStatement("insert into shopping_cart(foodid,userid) values (?,?)");
			ps.setInt(1, foodid);
			ps.setInt(2, userid);
			ps.execute();
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
