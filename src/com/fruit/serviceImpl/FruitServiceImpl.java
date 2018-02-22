package com.fruit.serviceImpl;

import com.fruit.daoImpl.FruitDaoImpl;
import com.fruit.domain.Fruit;
import com.fruit.service.FruitService;

public class FruitServiceImpl implements FruitService {
	FruitDaoImpl fdi = new FruitDaoImpl();

	// 判断水果是否存在
	@Override
	public Fruit existFruit(String brand) {
		Fruit fruit = fdi.existFruit(brand);
		return fruit;
	}

	// 查看水果
	@Override
	public void check() {
		fdi.check();
	}
}
