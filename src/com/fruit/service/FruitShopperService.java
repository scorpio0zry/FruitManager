package com.fruit.service;


import java.util.ArrayList;

import com.fruit.domain.BuyFruit;
import com.fruit.domain.Shopper;

public interface FruitShopperService {
	//���û����˵����ݴ��ݵ�Dao��
	public abstract void account(Shopper shopper, ArrayList<BuyFruit> list);
}
