package com.shxt.dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSource;

public class DBUtil {

	private static DruidDataSource ds = new DruidDataSource();

	static {

		Properties pro = new Properties();
		InputStream is = DBUtil.class.getResourceAsStream("sql.properties");
		String port = null;
		String url = null;
		String userName = null;
		String password = null;
		String dataBaseName = null;
		String driver = null;
		String jdbcurl = null;

		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		port = pro.getProperty("jdbc.port");
		url = pro.getProperty("jdbc.url");
		userName = pro.getProperty("jdbc.userName");
		password = pro.getProperty("jdbc.password");
		dataBaseName = pro.getProperty("jdbc.dataBaseName");
		driver = pro.getProperty("jdbc.driver");

		ds.setDriverClassName(driver);
		ds.setUsername(userName);
		ds.setPassword(password);
		jdbcurl = "jdbc:mysql://" + url + ":" + port + "/" + dataBaseName;
		ds.setUrl(jdbcurl);
		ds.setMinIdle(2);
		ds.setMaxActive(50);
		ds.setPoolPreparedStatements(false);

	}

	/*
	 * public static Connection connection = null;
	 * 
	 * public static Statement getStatement() { Statement statement = null; try
	 * { connection = ds.getConnection(); statement =
	 * connection.createStatement(); } catch (SQLException e) {
	 * e.printStackTrace(); }
	 * 
	 * return statement; }
	 * 
	 * public static PreparedStatement getPreparedSta(String sql) {
	 * PreparedStatement ps = null; try {
	 * 
	 * connection = ds.getConnection(); ps = connection.prepareStatement(sql); }
	 * catch (SQLException e) { e.printStackTrace(); } return ps;
	 * 
	 * }
	 */

	public static Connection getConnetion() {
		Connection connection = null;
		try {
			connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
