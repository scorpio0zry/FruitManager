package com.fruit.dao;

import java.util.List;
import java.util.Map;

import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;

public interface FruitManagerDao {
	// 从dao层接收管理员用户密码信息,在数据库中查询,返回true/false
	public abstract boolean getManager(Manager manager);

	// 添加水果信息
	public abstract boolean add(Fruit fruit);

	// 修改水果信息
	public abstract boolean update(Fruit fruit);

	// 删除水果信息
	public boolean delete(Fruit fruit);

	// 查询营业记录
	public List<Customer> query(String startDate, String endDate);

	// 查询用户的购买信息
	public List<Map<String,Object>> checkCustomer(int id);
}
