package com.fruit.dao;

import com.fruit.domain.Fruit;

public interface FruitDao {
	// �鿴ˮ��
	public abstract void check();

	// �����ݿ�鿴ˮ���Ƿ����
	public abstract Fruit existFruit(String brand);
}
