package com.shxt.page.entity;

import org.apache.catalina.User;

import com.shxt.entity.Food;
import com.shxt.entity.Vip;

public class ShopeOrder {

	private Food food = null;

	private Vip user = null;

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Vip getUser() {
		return user;
	}

	public void setUser(Vip user) {
		this.user = user;
	}

}
