package com.fruit.controller;

import java.util.ArrayList;

import com.fruit.domain.BuyFruit;

import com.fruit.domain.Shopper;

//顾客相关信息处理的controller层
public interface FruitShopperController {
	// 用户结账
	public abstract Shopper account(Shopper shopper, ArrayList<BuyFruit> list);
}
