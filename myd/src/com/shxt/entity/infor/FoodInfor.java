package com.shxt.entity.infor;

import java.util.ArrayList;
import java.util.List;
import com.shxt.entity.Food;
import com.shxt.entity.Shope;

public class FoodInfor {

	private Food food = new Food();
	private Shope shope = new Shope();
	private int goodLevel = 0;
	private int badLevel = 0;
	private int normal = 0;

	private List<String> comments = new ArrayList<String>();

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Shope getShope() {
		return shope;
	}

	public void setShope(Shope shope) {
		this.shope = shope;
	}

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

	public int getNormal() {
		return normal;
	}

	public void setNormal(int normal) {
		this.normal = normal;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

}
