package com.fruit.dao;

import com.fruit.domain.Fruit;

public interface FruitDao {
	// 查看水果
	public abstract void check();

	// 从数据库查看水果是否存在
	public abstract Fruit existFruit(String brand);
}
