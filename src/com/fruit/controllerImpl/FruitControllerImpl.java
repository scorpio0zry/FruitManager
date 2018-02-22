package com.fruit.controllerImpl;

import com.fruit.controller.FruitController;
import com.fruit.domain.Fruit;
import com.fruit.serviceImpl.FruitServiceImpl;

//controller���Ʋ㣺 ������Ź���Ա�͹˿͹��õĹ���
public class FruitControllerImpl implements FruitController {
	FruitServiceImpl fsi = new FruitServiceImpl();

	// �ж�ˮ���Ƿ����
	@Override
	public Fruit existFruit(String brand) {
		Fruit fruit = fsi.existFruit(brand);
		return fruit;
	}

	// �ж�ˮ��(����)�Ƿ����
	@Override
	public void check() {
		fsi.check();
	}
}
