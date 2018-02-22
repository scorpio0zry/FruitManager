package com.fruit.service;

import com.fruit.domain.Fruit;

public interface FruitService {
	// 查看水果
	public abstract void check();

	// 判断水果是否存在
	public abstract Fruit existFruit(String brand);
}
