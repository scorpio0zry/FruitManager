package com.fruit.controller;

import java.util.List;

import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;

public interface FruitManagerController {
	// 接收管理员用户密码信息,传递给service层
	public abstract boolean getManager(Manager manager);

	// 添加水果信息
	public abstract boolean add(Fruit fruit);

	// 修改水果信息
	public abstract boolean update(Fruit fruit);

	// 删除水果信息
	public abstract boolean delete(Fruit fruit);

	// 查询营业记录
	public abstract List<Customer> query(String startDate, String endDate);

	// 查询用户的购买信息
	public void checkCustomer(Customer customer);

}
