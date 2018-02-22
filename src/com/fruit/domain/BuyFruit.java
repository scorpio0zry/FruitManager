package com.fruit.domain;

public class BuyFruit {
	// 顾客购买的水果的名称和个数
	private String fruit;
	private int num;
	private double price;
	
	public BuyFruit(String fruit, int num) {
		super();
		this.fruit = fruit;
		this.num = num;
	}

	public BuyFruit(String fruit, int num,double price) {
		super();
		this.fruit = fruit;
		this.num = num;
		this.price = price;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
