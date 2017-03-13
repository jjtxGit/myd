package com.shxt.page.entity;

import java.util.ArrayList;
import java.util.List;

import com.shxt.entity.Food;

public class FoodPage extends Food {

	private int goodLevel = 0;// 好评
	private int badLevel = 0;// 差评
	private int normalLevel = 0;// 中评
	private String shopeName = "";// 商店名称
	private List<String> comments = new ArrayList<>();// 食品的评论

	public int getGoodLevel() {
		return goodLevel;
	}

	public void setGoodLevel(int goodLevel) {
		this.goodLevel = goodLevel;
	}

	public int getBadLevel() {
		return badLevel;
	}

	public void setBadLevel(int badLevel) {
		this.badLevel = badLevel;
	}

	public int getNormalLevel() {
		return normalLevel;
	}

	public void setNormalLevel(int normalLevel) {
		this.normalLevel = normalLevel;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public String getShopeName() {
		return shopeName;
	}

	public void setShopeName(String shopeName) {
		this.shopeName = shopeName;
	}

}
