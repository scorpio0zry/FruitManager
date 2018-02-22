package com.fruit.viewImpl;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import com.fruit.controllerImpl.FruitControllerImpl;
import com.fruit.controllerImpl.FruitShopperControllerImpl;
import com.fruit.domain.BuyFruit;
import com.fruit.domain.Fruit;
import com.fruit.domain.Shopper;

public class FruitShopperView {
	// 顾客控制层
	FruitShopperControllerImpl fsci = new FruitShopperControllerImpl();
	// 公共控制层
	FruitControllerImpl fci = new FruitControllerImpl();
	// 用于用户输入字符串
	Scanner sc1 = new Scanner(System.in);
	// 用于用户输入数字
	Scanner sc2 = new Scanner(System.in);

	// 顾客视图界面
	public void run() {
		System.out.println("-------欢迎光临顾客界面-------");
		// 创建一个客户
		Shopper shopper = new Shopper();
		// 创建该用户的水果篮
		ArrayList<BuyFruit> list = new ArrayList<BuyFruit>();
		while (true) {
			System.out
					.println("请输入你要进行的操作（1.查看已购买的水果   2.购买水果    3.退回水果   4.结账   5.退出）");
			String select = sc1.nextLine();
			switch (select) {
			case "1":
				// 查看已购买的水果
				check(list);
				break;
			case "2":
				// 顾客购买水果
				buy(list);
				break;
			case "3":
				// 顾客退回不想购买的水果
				drawback(list);
				break;
			case "4":
				// 顾客结账
				account(shopper, list);
				break;
			case "5":
				// 退出顾客界面
				System.out.println("退出顾客界面 中...欢迎再次光临");
				return;
			default:
				System.out.println("操作输入错误！请重新输入");
			}
		}
	}

	// 查看已购买的水果
	private void check(ArrayList<BuyFruit> list) {
		if (list.size() > 0) {
			// 查看已购买的水果
			System.out.println("购买的水果种类及个数");
			for (BuyFruit buyfruit : list) {
				System.out.println(buyfruit.getFruit() + "\t:  "
						+ buyfruit.getNum() + "个");
			}
		} else {
			System.out.println("没有购买水果");
		}

	}

	// 查看商店水果的种类和库存
	private void check() {
		fci.check();
	}

	// 购买水果
	private void buy(ArrayList<BuyFruit> list) {
		check();
		System.out.println("请输入您要购买的商品名称");
		String brand = sc1.nextLine();
		// 检查商品是否存在，存在则返回该商品的参数
		Fruit fruit = fci.existFruit(brand);
		if (fruit != null) {
			// 商品存在，则开始购买
			System.out.println(fruit.getBrand() + "的单价为" + fruit.getPrice()
					+ "元，存货为" + fruit.getStock());
			System.out.print("输入你要购买的" + fruit.getBrand() + "的个数: ");
			int num = sc2.nextInt();
			if (num < fruit.getStock()) {
				// 库存有水果，创建BuyFruit对象，添加到水果篮list中
				BuyFruit buyFruit = new BuyFruit(fruit.getBrand(), num,
						fruit.getPrice());
				list.add(buyFruit);
			} else {
				// 超过库存，购买失败
				System.out.println("存货不足，购买失败");
			}
		} else {
			// fruit为null，商品不存在
			System.out.println("不存在该商品");
		}
	}

	// 退回水果
	private void drawback(ArrayList<BuyFruit> list) {
		// 查看已购买的水果
		check(list);
		System.out.println("请选择要退回的水果名称");
		String fruit = sc1.nextLine();
		// 判断水果是否存在
		// 利用ListIterator迭代器移除集合中指定退回的水果
		boolean flag = false;
		ListIterator<BuyFruit> listI = list.listIterator();
		while (listI.hasNext()) {
			BuyFruit buyfruit = listI.next();
			if (buyfruit.getFruit().equals(fruit)) {
				System.out.println("请输入要退回的水果个数");
				int num = sc2.nextInt();
				// 对用户输入的水果数量进行判断
				if (num > buyfruit.getNum()) {
					System.out.println("退回水果个数大于已购买水果个数，退回失败");
					return;
				} else if (num < buyfruit.getNum()) {
					buyfruit.setNum(buyfruit.getNum() - num);
					listI.set(buyfruit);
				} else {
					listI.remove();
				}
				flag = true;
			}
		}

		if (!flag) {
			System.out.println("没有购买该种水果！");
		}

	}

	// 用户结账
	private void account(Shopper shopper, ArrayList<BuyFruit> list) {
		shopper = fsci.account(shopper, list);
		System.out.println("购买时间：" + shopper.getDatetime());
		System.out.println("用户购买的水果：");
		check(list);
		System.out.println("消费的金额一共： " + shopper.getMoney() + "元");
	}
}
