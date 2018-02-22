package com.fruit.serviceImpl;

import java.util.List;

import java.util.Map;

import com.fruit.daoImpl.FruitManagerDaoImpl;
import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;
import com.fruit.service.FruitManagerService;

public class FruitManagerServiceImpl implements FruitManagerService {
	FruitManagerDaoImpl fmdi = new FruitManagerDaoImpl();

	// 从controller层接收管理员用户密码信息,传递给dao层
	@Override
	public boolean getManager(Manager manager) {
		boolean flag = fmdi.getManager(manager);
		return flag;
	}

	// // 添加水果信息
	@Override
	public boolean add(Fruit fruit) {
		boolean flag = fmdi.add(fruit);
		return flag;
	}

	// 修改水果信息
	@Override
	public boolean update(Fruit fruit) {
		boolean flag = fmdi.update(fruit);
		return flag;
	}

	// 删除水果信息
	@Override
	public boolean delete(Fruit fruit) {
		boolean flag = fmdi.delete(fruit);
		return flag;
	}

	// 查询营业记录
	@Override
	public List<Customer> query(String startDate, String endDate) {
		List<Customer> list = fmdi.query(startDate, endDate);
		// 对List集合进行解析处理
		if (list.size() != 0) {
			System.out.println("顾客ID\t消费金额\t\t消费时间");
			for (Customer customer : list) {
				System.out.println(customer.getId() + "\t"
						+ customer.getMoney() + "\t" + customer.getTime());
			}
		}
		return list;
	}

	// 查询用户的购买信息
	@Override
	public void checkCustomer(Customer customer) {
		List<Map<String, Object>> list = fmdi.checkCustomer(customer.getId());
		if (list.size() != 0) {
			System.out.println("顾客" + customer.getId() + " 购买的商品信息：");
			System.out.println("消费总额：" + customer.getMoney() + "元");
			System.out.println("商品名称\t:\t数量");
			for (Map<String, Object> map : list) {
				for (String key : map.keySet()) {
					Object value = map.get(key);
					if ("brand".equals(key)) {
						System.out.print(value + "\t:\t");
					} else if ("num".equals(key)) {
						System.out.println(value);
					}
				}
			}
		} else {
			System.out.println("查询失败");
		}

	}

}
