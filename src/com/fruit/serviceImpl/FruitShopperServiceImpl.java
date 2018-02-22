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

	// ���û����˵����ݴ��ݵ�Dao��
	@Override
	public void account(Shopper shopper, ArrayList<BuyFruit> list) {
		// ��service��Թ˿Ͷ�����д�������������Dao��
		shopper.setFruit(list);
		// ������
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
