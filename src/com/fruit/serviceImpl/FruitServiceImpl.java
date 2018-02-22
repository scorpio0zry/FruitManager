package com.fruit.serviceImpl;

import com.fruit.daoImpl.FruitDaoImpl;
import com.fruit.domain.Fruit;
import com.fruit.service.FruitService;

public class FruitServiceImpl implements FruitService {
	FruitDaoImpl fdi = new FruitDaoImpl();

	// �ж�ˮ���Ƿ����
	@Override
	public Fruit existFruit(String brand) {
		Fruit fruit = fdi.existFruit(brand);
		return fruit;
	}

	// �鿴ˮ��
	@Override
	public void check() {
		fdi.check();
	}
}
