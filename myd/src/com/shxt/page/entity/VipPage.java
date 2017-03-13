package com.shxt.page.entity;

import java.util.ArrayList;
import java.util.List;

import com.shxt.entity.Vip;

public class VipPage {

	private List<FoodBill> foodBills = new ArrayList<FoodBill>();

	private List<FoodBill> orderFormEds = new ArrayList<FoodBill>();

	private List<FoodBill> orderFormIngs = new ArrayList<FoodBill>();

	public List<FoodBill> getFoodBills() {
		return foodBills;
	}

	public void setFoodBills(List<FoodBill> foodBills) {
		this.foodBills = foodBills;
	}

	public List<FoodBill> getOrderFormEds() {
		return orderFormEds;
	}

	public void setOrderFormEds(List<FoodBill> orderFormEds) {
		this.orderFormEds = orderFormEds;
	}

	public List<FoodBill> getOrderFormIngs() {
		return orderFormIngs;
	}

	public void setOrderFormIngs(List<FoodBill> orderFormIngs) {
		this.orderFormIngs = orderFormIngs;
	}

	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

	private Vip vip = new Vip();

}
