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
	// �����û������ַ���
	Scanner sc1 = new Scanner(System.in);
	// �����û���������
	Scanner sc2 = new Scanner(System.in);

	public void run() {
		System.out.println("-------��ӭ���ٹ���Ա����-------");
		System.out.println("�������û�����: ");
		String username = sc1.nextLine();
		System.out.println("����������: ");
		String password = sc1.nextLine();
		Manager manager = new Manager(username, password);
		boolean flag = fmci.getManager(manager);
		if (flag) {
			// ���й���Աϵͳ
			manager(manager);
		} else {
			System.out.println("�û��������������!�˳�����ϵͳ");
		}
	}

	// ���й���Աϵͳ
	private void manager(Manager manager) {
		System.out.println("��ӭ " + manager.getUsername() + " �������ϵͳ");
		while (true) {
			System.out
					.println("���������Ĳ����� 1.�鿴ˮ����Ϣ  2.���ˮ����Ϣ   3.�޸�ˮ����Ϣ   4.ɾ��ˮ����Ϣ   5.��ѯӪҵ��¼   6.�˳�����ϵͳ");
			String select = sc1.nextLine();
			switch (select) {
			case "1":
				// �鿴ˮ����Ϣ
				fci.check();
				break;
			case "2":
				// ���ˮ����Ϣ
				add();
				break;
			case "3":
				// �޸�ˮ����Ϣ
				update();
				break;
			case "4":
				// ɾ��ˮ����Ϣ
				delete();
				break;
			case "5":
				// ��ѯӪҵ��¼
				check();
				break;
			case "6":
				System.out.println("�˳�����ϵͳ��...�ټ� " + manager.getUsername());
				return;
			default:
				System.out.println("���������������������");
			}
		}

	}

	// ��ѯӪҵ��¼
	private void check() {
		System.out.println("������Ҫ��ѯ����ʼ���ڷ�Χ�������� 2017-12-1��");
		String startDate = sc1.nextLine();
		System.out.println("������Ҫ��ѯ�Ľ������ڷ�Χ:������ 2017-12-1��");
		String endDate = sc2.nextLine();
		List<Customer> list = fmci.query(startDate, endDate);
		if (list.size() != 0) {
			System.out.println("�Ƿ��ѯ�˿͵Ĺ�����Ϣ��1.��ѯ   2.����ѯ");
			String select = sc2.nextLine();
			switch (select) {
			case "1":
				// ��ѯ�˿͵Ĺ�����Ϣ
				checkCustomer(list);
				break;
			case "2":
				break;
			default:
				System.out.println("����Ĳ������룡");
				break;
			}
		} else {
			System.out.println("û�в�ѯ����¼");
		}

	}

	// ��ѯ�˿͵Ĺ�����Ϣ
	private void checkCustomer(List<Customer> list) {
		System.out.println("�������ѯ�˿͵�ID��");
		int id = sc2.nextInt();
		boolean flag = false;
		for (Customer customer : list) {
			//��ѯ�˿���Ϣ
			if (customer.getId() == id) {
				fmci.checkCustomer(customer);
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("�˿�ID����ʧ��");
		}

	}

	// ɾ��ˮ����Ϣ
	private void delete() {
		fci.check();
		System.out.println("������Ҫɾ����ˮ������");
		String brand = sc1.nextLine();
		Fruit fruit = fci.existFruit(brand);
		if (fruit != null) {
			//ɾ��ˮ�����������Ƿ�ɹ�
			boolean flag = fmci.delete(fruit);
			if (flag) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ��");
			}
		} else {
			System.out.println("��ˮ�������ڣ�");
		}
	}

	// �޸�ˮ����Ϣ
	private void update() {
		fci.check();
		System.out.println("������Ҫ�޸ĵ�ˮ������");
		String brand = sc1.nextLine();
		//��ѯ��ˮ���Ƿ�����ڿ����
		Fruit fruitC = fci.existFruit(brand);
		if (fruitC != null) {
			System.out.println("������" + brand + "�ĵ���");
			double price = sc2.nextDouble();
			System.out.println("������" + brand + "�Ŀ��");
			int stock = sc2.nextInt();
			Fruit fruit = new Fruit(0, brand, price, stock);
			boolean flag = fmci.update(fruit);
			if (flag) {
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("�޸�ʧ��");
			}
		} else {
			System.out.println("��ˮ�������ڣ�");
		}
	}

	// ���ˮ����Ϣ
	private void add() {
		fci.check();
		System.out.println("������Ҫ��ӵ�ˮ������");
		String brand = sc1.nextLine();
		Fruit fruitC = fci.existFruit(brand);
		if (fruitC == null) {
			System.out.println("������" + brand + "�ĵ���");
			double price = sc2.nextDouble();
			System.out.println("������" + brand + "�Ŀ��");
			int stock = sc2.nextInt();
			Fruit fruit = new Fruit(0, brand, price, stock);
			boolean flag = fmci.add(fruit);
			if (flag) {
				System.out.println("��ӳɹ�");
			} else {
				System.out.println("���ʧ��");
			}
		} else {
			System.out.println("��ˮ���Ѵ��ڣ��벻Ҫ�ظ���ӣ�");
		}

	}
}
