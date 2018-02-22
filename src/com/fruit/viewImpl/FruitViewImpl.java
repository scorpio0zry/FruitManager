package com.fruit.viewImpl;

import java.util.Scanner;

import com.fruit.view.FruitView;

//视图层(用于用户交互显示)

public class FruitViewImpl implements FruitView {
	FruitManagerView fmv = new FruitManagerView();
	FruitShopperView sfv = new FruitShopperView();
	Scanner sc = new Scanner(System.in);

	// 运行系统
	@Override
	public void run() {
		while (true) {
			System.out.println("-------欢迎光临水果管理系统-------");
			System.out.println("请输入您的身份(1.顾客    2.管理员   3.退出)");
			String status = sc.nextLine();
			switch (status) {
			case "1":
				shopper();
				break;
			case "2":
				manager();
				break;
			case "3":
				System.exit(0);
			default:
				System.out.println("操作输入错误！请重新输入");
			}
		}
	}

	// 进入管理员界面
	@Override
	public void manager() {
		fmv.run();
	}

	// 进入顾客界面
	@Override
	public void shopper() {
		sfv.run();
	}

}
