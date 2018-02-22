package com.fruit.viewImpl;

import java.util.List;
import java.util.Scanner;

import com.fruit.controllerImpl.FruitControllerImpl;
import com.fruit.controllerImpl.FruitManagerControllerImpl;
import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;

public class FruitManagerView {
	FruitManagerControllerImpl fmci = new FruitManagerControllerImpl();

	FruitControllerImpl fci = new FruitControllerImpl();
	// 用于用户输入字符串
	Scanner sc1 = new Scanner(System.in);
	// 用于用户输入数字
	Scanner sc2 = new Scanner(System.in);

	public void run() {
		System.out.println("-------欢迎光临管理员界面-------");
		System.out.println("请输入用户名称: ");
		String username = sc1.nextLine();
		System.out.println("请输入密码: ");
		String password = sc1.nextLine();
		Manager manager = new Manager(username, password);
		boolean flag = fmci.getManager(manager);
		if (flag) {
			// 运行管理员系统
			manager(manager);
		} else {
			System.out.println("用户名密码输入错误!退出管理系统");
		}
	}

	// 运行管理员系统
	private void manager(Manager manager) {
		System.out.println("欢迎 " + manager.getUsername() + " 进入管理系统");
		while (true) {
			System.out
					.println("请输入您的操作： 1.查看水果信息  2.添加水果信息   3.修改水果信息   4.删除水果信息   5.查询营业记录   6.退出管理系统");
			String select = sc1.nextLine();
			switch (select) {
			case "1":
				// 查看水果信息
				fci.check();
				break;
			case "2":
				// 添加水果信息
				add();
				break;
			case "3":
				// 修改水果信息
				update();
				break;
			case "4":
				// 删除水果信息
				delete();
				break;
			case "5":
				// 查询营业记录
				check();
				break;
			case "6":
				System.out.println("退出管理系统中...再见 " + manager.getUsername());
				return;
			default:
				System.out.println("操作输入错误！请重新输入");
			}
		}

	}

	// 查询营业记录
	private void check() {
		System.out.println("请输入要查询的起始日期范围：（例如 2017-12-1）");
		String startDate = sc1.nextLine();
		System.out.println("请输入要查询的结束日期范围:（例如 2017-12-1）");
		String endDate = sc2.nextLine();
		List<Customer> list = fmci.query(startDate, endDate);
		if (list.size() != 0) {
			System.out.println("是否查询顾客的购买信息：1.查询   2.不查询");
			String select = sc2.nextLine();
			switch (select) {
			case "1":
				// 查询顾客的购买信息
				checkCustomer(list);
				break;
			case "2":
				break;
			default:
				System.out.println("错误的操作输入！");
				break;
			}
		} else {
			System.out.println("没有查询到记录");
		}

	}

	// 查询顾客的购买信息
	private void checkCustomer(List<Customer> list) {
		System.out.println("请输入查询顾客的ID：");
		int id = sc2.nextInt();
		boolean flag = false;
		for (Customer customer : list) {
			//查询顾客信息
			if (customer.getId() == id) {
				fmci.checkCustomer(customer);
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("顾客ID查找失败");
		}

	}

	// 删除水果信息
	private void delete() {
		fci.check();
		System.out.println("请输入要删除的水果名称");
		String brand = sc1.nextLine();
		Fruit fruit = fci.existFruit(brand);
		if (fruit != null) {
			//删除水果，并返回是否成功
			boolean flag = fmci.delete(fruit);
			if (flag) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} else {
			System.out.println("该水果不存在！");
		}
	}

	// 修改水果信息
	private void update() {
		fci.check();
		System.out.println("请输入要修改的水果名称");
		String brand = sc1.nextLine();
		//查询该水果是否存在在库存中
		Fruit fruitC = fci.existFruit(brand);
		if (fruitC != null) {
			System.out.println("请输入" + brand + "的单价");
			double price = sc2.nextDouble();
			System.out.println("请输入" + brand + "的库存");
			int stock = sc2.nextInt();
			Fruit fruit = new Fruit(0, brand, price, stock);
			boolean flag = fmci.update(fruit);
			if (flag) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} else {
			System.out.println("该水果不存在！");
		}
	}

	// 添加水果信息
	private void add() {
		fci.check();
		System.out.println("请输入要添加的水果名称");
		String brand = sc1.nextLine();
		Fruit fruitC = fci.existFruit(brand);
		if (fruitC == null) {
			System.out.println("请输入" + brand + "的单价");
			double price = sc2.nextDouble();
			System.out.println("请输入" + brand + "的库存");
			int stock = sc2.nextInt();
			Fruit fruit = new Fruit(0, brand, price, stock);
			boolean flag = fmci.add(fruit);
			if (flag) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
		} else {
			System.out.println("该水果已存在，请不要重复添加！");
		}

	}
}
