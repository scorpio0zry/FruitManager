package com.fruit.service;


import java.util.ArrayList;

import com.fruit.domain.BuyFruit;
import com.fruit.domain.Shopper;

public interface FruitShopperService {
	//将用户结账的数据传递到Dao层
	public abstract void account(Shopper shopper, ArrayList<BuyFruit> list);
}
