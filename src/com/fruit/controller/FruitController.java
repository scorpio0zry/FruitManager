package com.fruit.controller;

import com.fruit.domain.Fruit;

public interface FruitController {
	// 查看水果
	public abstract void check();

	// 判断水果(名称)是否存在
	public abstract Fruit existFruit(String brand);

}
