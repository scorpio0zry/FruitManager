package com.fruit.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fruit.daoImpl.FruitShopperDaoImpl;
import com.fruit.domain.BuyFruit;
import com.fruit.domain.Shopper;
import com.fruit.service.FruitShopperService;

public class FruitShopperServiceImpl implements FruitShopperService {
	FruitShopperDaoImpl fsdi = new FruitShopperDaoImpl();

	// 将用户结账的数据传递到Dao层
	@Override
	public void account(Shopper shopper, ArrayList<BuyFruit> list) {
		// 在service层对顾客对象进行处理，并将数据向Dao层
		shopper.setFruit(list);
		// 总消费
		double sum = 0;
		for (BuyFruit buyFruit : list) {
			sum += buyFruit.getNum() * buyFruit.getPrice();
		}
		shopper.setMoney(sum);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = sdf.format(new Date());
		shopper.setDatetime(datetime);
		fsdi.account(shopper);
	}
}
