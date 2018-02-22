package com.fruit.dao;

import com.fruit.domain.Shopper;

public interface FruitShopperDao {
	// 将顾客购买的数据存储数据库中
	public void account(Shopper shopper);
}
