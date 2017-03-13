package com.shxt.page.entity;

import java.util.ArrayList;
import java.util.List;

import com.shxt.entity.Food;
import com.shxt.entity.Shope;
import com.shxt.entity.ShopeComment;

public class ShopePage extends Shope {

	private int goodLevel = 0;
	private int badLevel = 0;
	private int normalLevel = 0;
	
	private List<ShopeComment> comments = new ArrayList<ShopeComment>();
	private List<Food> foods = new ArrayList<Food>();
	
	
	
	
	
	
	
	
	
	
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

	public List<ShopeComment> getComments() {
		return comments;
	}

	public void setComments(List<ShopeComment> comments) {
		this.comments = comments;
	}

	/**
	 * 添加一个对商铺的评论类
	 * 
	 * @param shopeComment
	 */
	public void addComment(ShopeComment shopeComment) {
		this.comments.add(shopeComment);

	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

}
