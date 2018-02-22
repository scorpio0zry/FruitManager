package com.fruit.controllerImpl;

import java.util.ArrayList;

import com.fruit.controller.FruitShopperController;
import com.fruit.domain.BuyFruit;

import com.fruit.domain.Shopper;
import com.fruit.serviceImpl.FruitShopperServiceImpl;

//顾客控制层
public class FruitShopperControllerImpl implements FruitShopperController {
	FruitShopperServiceImpl fssi = new FruitShopperServiceImpl();

	// 用户结账
	@Override
	public Shopper account(Shopper shopper, ArrayList<BuyFruit> list) {
		// 将数据向service层传递

		fssi.account(shopper, list);
		return shopper;
	}

}
