package com.fruit.service;

import com.fruit.domain.Fruit;

public interface FruitService {
	// �鿴ˮ��
	public abstract void check();

	// �ж�ˮ���Ƿ����
	public abstract Fruit existFruit(String brand);
}
