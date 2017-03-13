package com.shxt.page.entity;

import com.shxt.entity.Food;
import com.shxt.entity.FoodComment;

public class FoodCommentPage {

	private Food food = null;
	private FoodComment foodComment = null;

	public FoodComment getFoodComment() {
		return foodComment;
	}

	public void setFoodComment(FoodComment foodComment) {
		this.foodComment = foodComment;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

}
