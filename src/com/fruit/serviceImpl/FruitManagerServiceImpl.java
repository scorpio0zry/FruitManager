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

	// ��controller����չ���Ա�û�������Ϣ,���ݸ�dao��
	@Override
	public boolean getManager(Manager manager) {
		boolean flag = fmdi.getManager(manager);
		return flag;
	}

	// // ���ˮ����Ϣ
	@Override
	public boolean add(Fruit fruit) {
		boolean flag = fmdi.add(fruit);
		return flag;
	}

	// �޸�ˮ����Ϣ
	@Override
	public boolean update(Fruit fruit) {
		boolean flag = fmdi.update(fruit);
		return flag;
	}

	// ɾ��ˮ����Ϣ
	@Override
	public boolean delete(Fruit fruit) {
		boolean flag = fmdi.delete(fruit);
		return flag;
	}

	// ��ѯӪҵ��¼
	@Override
	public List<Customer> query(String startDate, String endDate) {
		List<Customer> list = fmdi.query(startDate, endDate);
		// ��List���Ͻ��н�������
		if (list.size() != 0) {
			System.out.println("�˿�ID\t���ѽ��\t\t����ʱ��");
			for (Customer customer : list) {
				System.out.println(customer.getId() + "\t"
						+ customer.getMoney() + "\t" + customer.getTime());
			}
		}
		return list;
	}

	// ��ѯ�û��Ĺ�����Ϣ
	@Override
	public void checkCustomer(Customer customer) {
		List<Map<String, Object>> list = fmdi.checkCustomer(customer.getId());
		if (list.size() != 0) {
			System.out.println("�˿�" + customer.getId() + " �������Ʒ��Ϣ��");
			System.out.println("�����ܶ" + customer.getMoney() + "Ԫ");
			System.out.println("��Ʒ����\t:\t����");
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
			System.out.println("��ѯʧ��");
		}

	}

}
