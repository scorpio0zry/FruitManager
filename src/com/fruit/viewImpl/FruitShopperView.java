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
	// �˿Ϳ��Ʋ�
	FruitShopperControllerImpl fsci = new FruitShopperControllerImpl();
	// �������Ʋ�
	FruitControllerImpl fci = new FruitControllerImpl();
	// �����û������ַ���
	Scanner sc1 = new Scanner(System.in);
	// �����û���������
	Scanner sc2 = new Scanner(System.in);

	// �˿���ͼ����
	public void run() {
		System.out.println("-------��ӭ���ٹ˿ͽ���-------");
		// ����һ���ͻ�
		Shopper shopper = new Shopper();
		// �������û���ˮ����
		ArrayList<BuyFruit> list = new ArrayList<BuyFruit>();
		while (true) {
			System.out
					.println("��������Ҫ���еĲ�����1.�鿴�ѹ����ˮ��   2.����ˮ��    3.�˻�ˮ��   4.����   5.�˳���");
			String select = sc1.nextLine();
			switch (select) {
			case "1":
				// �鿴�ѹ����ˮ��
				check(list);
				break;
			case "2":
				// �˿͹���ˮ��
				buy(list);
				break;
			case "3":
				// �˿��˻ز��빺���ˮ��
				drawback(list);
				break;
			case "4":
				// �˿ͽ���
				account(shopper, list);
				break;
			case "5":
				// �˳��˿ͽ���
				System.out.println("�˳��˿ͽ��� ��...��ӭ�ٴι���");
				return;
			default:
				System.out.println("���������������������");
			}
		}
	}

	// �鿴�ѹ����ˮ��
	private void check(ArrayList<BuyFruit> list) {
		if (list.size() > 0) {
			// �鿴�ѹ����ˮ��
			System.out.println("�����ˮ�����༰����");
			for (BuyFruit buyfruit : list) {
				System.out.println(buyfruit.getFruit() + "\t:  "
						+ buyfruit.getNum() + "��");
			}
		} else {
			System.out.println("û�й���ˮ��");
		}

	}

	// �鿴�̵�ˮ��������Ϳ��
	private void check() {
		fci.check();
	}

	// ����ˮ��
	private void buy(ArrayList<BuyFruit> list) {
		check();
		System.out.println("��������Ҫ�������Ʒ����");
		String brand = sc1.nextLine();
		// �����Ʒ�Ƿ���ڣ������򷵻ظ���Ʒ�Ĳ���
		Fruit fruit = fci.existFruit(brand);
		if (fruit != null) {
			// ��Ʒ���ڣ���ʼ����
			System.out.println(fruit.getBrand() + "�ĵ���Ϊ" + fruit.getPrice()
					+ "Ԫ�����Ϊ" + fruit.getStock());
			System.out.print("������Ҫ�����" + fruit.getBrand() + "�ĸ���: ");
			int num = sc2.nextInt();
			if (num < fruit.getStock()) {
				// �����ˮ��������BuyFruit������ӵ�ˮ����list��
				BuyFruit buyFruit = new BuyFruit(fruit.getBrand(), num,
						fruit.getPrice());
				list.add(buyFruit);
			} else {
				// ������棬����ʧ��
				System.out.println("������㣬����ʧ��");
			}
		} else {
			// fruitΪnull����Ʒ������
			System.out.println("�����ڸ���Ʒ");
		}
	}

	// �˻�ˮ��
	private void drawback(ArrayList<BuyFruit> list) {
		// �鿴�ѹ����ˮ��
		check(list);
		System.out.println("��ѡ��Ҫ�˻ص�ˮ������");
		String fruit = sc1.nextLine();
		// �ж�ˮ���Ƿ����
		// ����ListIterator�������Ƴ�������ָ���˻ص�ˮ��
		boolean flag = false;
		ListIterator<BuyFruit> listI = list.listIterator();
		while (listI.hasNext()) {
			BuyFruit buyfruit = listI.next();
			if (buyfruit.getFruit().equals(fruit)) {
				System.out.println("������Ҫ�˻ص�ˮ������");
				int num = sc2.nextInt();
				// ���û������ˮ�����������ж�
				if (num > buyfruit.getNum()) {
					System.out.println("�˻�ˮ�����������ѹ���ˮ���������˻�ʧ��");
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
			System.out.println("û�й������ˮ����");
		}

	}

	// �û�����
	private void account(Shopper shopper, ArrayList<BuyFruit> list) {
		shopper = fsci.account(shopper, list);
		System.out.println("����ʱ�䣺" + shopper.getDatetime());
		System.out.println("�û������ˮ����");
		check(list);
		System.out.println("���ѵĽ��һ���� " + shopper.getMoney() + "Ԫ");
	}
}
