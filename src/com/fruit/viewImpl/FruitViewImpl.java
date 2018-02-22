package com.fruit.viewImpl;

import java.util.Scanner;

import com.fruit.view.FruitView;

//��ͼ��(�����û�������ʾ)

public class FruitViewImpl implements FruitView {
	FruitManagerView fmv = new FruitManagerView();
	FruitShopperView sfv = new FruitShopperView();
	Scanner sc = new Scanner(System.in);

	// ����ϵͳ
	@Override
	public void run() {
		while (true) {
			System.out.println("-------��ӭ����ˮ������ϵͳ-------");
			System.out.println("�������������(1.�˿�    2.����Ա   3.�˳�)");
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
				System.out.println("���������������������");
			}
		}
	}

	// �������Ա����
	@Override
	public void manager() {
		fmv.run();
	}

	// ����˿ͽ���
	@Override
	public void shopper() {
		sfv.run();
	}

}
