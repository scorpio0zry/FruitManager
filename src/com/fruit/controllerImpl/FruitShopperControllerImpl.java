package com.fruit.controllerImpl;

import java.util.ArrayList;

import com.fruit.controller.FruitShopperController;
import com.fruit.domain.BuyFruit;

import com.fruit.domain.Shopper;
import com.fruit.serviceImpl.FruitShopperServiceImpl;

//�˿Ϳ��Ʋ�
public class FruitShopperControllerImpl implements FruitShopperController {
	FruitShopperServiceImpl fssi = new FruitShopperServiceImpl();

	// �û�����
	@Override
	public Shopper account(Shopper shopper, ArrayList<BuyFruit> list) {
		// ��������service�㴫��

		fssi.account(shopper, list);
		return shopper;
	}

}
