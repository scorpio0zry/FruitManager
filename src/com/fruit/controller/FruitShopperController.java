package com.fruit.controller;

import java.util.ArrayList;

import com.fruit.domain.BuyFruit;

import com.fruit.domain.Shopper;

//�˿������Ϣ�����controller��
public interface FruitShopperController {
	// �û�����
	public abstract Shopper account(Shopper shopper, ArrayList<BuyFruit> list);
}
