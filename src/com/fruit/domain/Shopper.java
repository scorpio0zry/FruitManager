package com.fruit.domain;

import java.util.ArrayList;

//顾客类
public class Shopper {
	//金额
	private double money = 0;
	//购买商品列表
	private ArrayList<BuyFruit> fruit;
	//购买时间
	private String datetime;

	public Shopper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money += money;
	}
	
	public void setFruit(ArrayList<BuyFruit> fruit){
		this.fruit = fruit;
	}
	
	public ArrayList<BuyFruit> getFruit(){
		return fruit;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	

	
}
