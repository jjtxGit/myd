package com.shxt.page.entity;

import java.util.ArrayList;
import java.util.List;

import com.shxt.entity.Food;

public class FoodPage extends Food {

	private int goodLevel = 0;// ����
	private int badLevel = 0;// ����
	private int normalLevel = 0;// ����
	private String shopeName = "";// �̵�����
	private List<String> comments = new ArrayList<>();// ʳƷ������

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
