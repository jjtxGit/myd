package com.shxt.entity;

public class Food {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getShopeId() {
		return shopeId;
	}

	public void setShopeId(int shopeId) {
		this.shopeId = shopeId;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	private int id = 0;
	private String name = "";
	private int type = 0;
	private double price = 0;
	private int shopeId = 0;
	private String picPath = "";
	private String des = "";

}
