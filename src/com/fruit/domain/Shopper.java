package com.fruit.domain;

import java.util.ArrayList;

//�˿���
public class Shopper {
	//���
	private double money = 0;
	//������Ʒ�б�
	private ArrayList<BuyFruit> fruit;
	//����ʱ��
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
