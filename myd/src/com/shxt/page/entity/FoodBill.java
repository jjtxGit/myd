package com.shxt.page.entity;

public class FoodBill {

	private int CartId = 0;

	private String foodImgPath = "";
	private String foodName = "";
	private String des = "";
	private int foodType = 0;
	private double price = 0;
	private String time = "";
	private String shopeName = "";
	private int foodId = 0;
	private int shopeId = 0;

	public int getCartId() {
		return CartId;
	}

	public void setCartId(int cartId) {
		CartId = cartId;
	}

	public String getFoodImgPath() {
		return foodImgPath;
	}

	public void setFoodImgPath(String foodImgPath) {
		this.foodImgPath = foodImgPath;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getShopeName() {
		return shopeName;
	}

	public void setShopeName(String shopeName) {
		this.shopeName = shopeName;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getFoodType() {
		return foodType;
	}

	public void setFoodType(int foodType) {
		this.foodType = foodType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getShopeId() {
		return shopeId;
	}

	public void setShopeId(int shopeId) {
		this.shopeId = shopeId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

}
