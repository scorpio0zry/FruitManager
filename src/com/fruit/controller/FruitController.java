package com.fruit.controller;

import com.fruit.domain.Fruit;

public interface FruitController {
	// �鿴ˮ��
	public abstract void check();

	// �ж�ˮ��(����)�Ƿ����
	public abstract Fruit existFruit(String brand);

}
