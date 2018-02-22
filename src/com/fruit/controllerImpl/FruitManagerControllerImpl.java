package com.fruit.controllerImpl;

//controller层作用: 控制层   (获取界面上的数据,为界面设置数据; 将要实现的功能交给业务层处理)
import java.util.List;

import com.fruit.controller.FruitManagerController;
import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;
import com.fruit.serviceImpl.FruitManagerServiceImpl;

//管理员控制层
public class FruitManagerControllerImpl implements FruitManagerController {
	FruitManagerServiceImpl fmsi = new FruitManagerServiceImpl();

	// 接收管理员用户密码信息,传递给service层
	@Override
	public boolean getManager(Manager manager) {
		boolean flag = fmsi.getManager(manager);
		return flag;
	}

	// 添加水果信息
	@Override
	public boolean add(Fruit fruit) {
		boolean flag = fmsi.add(fruit);
		return flag;
	}

	// 修改水果信息
	@Override
	public boolean update(Fruit fruit) {
		boolean flag = fmsi.update(fruit);
		return flag;
	}

	// 删除水果信息
	@Override
	public boolean delete(Fruit fruit) {
		boolean flag = fmsi.delete(fruit);
		return flag;
	}

	// 查询营业记录
	@Override
	public List<Customer> query(String startDate, String endDate) {
		List<Customer> list = fmsi.query(startDate, endDate);
		return list;
	}

	// 查询用户的购买信息
	@Override
	public void checkCustomer(Customer customer) {
		fmsi.checkCustomer(customer);
	}

}
