package com.shxt.entity;

public class ShopeComment {
	private int id = 0;
	private int shopeid = 0;
	private int userid = 0;
	private int level = 0;
	private String time = "";
	private String comment = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopeid() {
		return shopeid;
	}

	public void setShopeid(int shopeid) {
		this.shopeid = shopeid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
