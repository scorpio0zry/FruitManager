package com.fruit.controllerImpl;

import com.fruit.controller.FruitController;
import com.fruit.domain.Fruit;
import com.fruit.serviceImpl.FruitServiceImpl;

//controller控制层： 用来存放管理员和顾客公用的功能
public class FruitControllerImpl implements FruitController {
	FruitServiceImpl fsi = new FruitServiceImpl();

	// 判断水果是否存在
	@Override
	public Fruit existFruit(String brand) {
		Fruit fruit = fsi.existFruit(brand);
		return fruit;
	}

	// 判断水果(名称)是否存在
	@Override
	public void check() {
		fsi.check();
	}
}
