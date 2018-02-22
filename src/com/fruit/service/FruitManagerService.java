package com.fruit.service;

import java.util.List;

import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;

public interface FruitManagerService {
	// ��controller����չ���Ա�û�������Ϣ,���ݸ�dao��
	public abstract boolean getManager(Manager manager);

	// ���ˮ����Ϣ
	public abstract boolean add(Fruit fruit);

	// �޸�ˮ����Ϣ
	public abstract boolean update(Fruit fruit);

	// ɾ��ˮ����Ϣ
	public abstract boolean delete(Fruit fruit);

	// ��ѯӪҵ��¼
	public abstract List<Customer> query(String startDate, String endDate);

	// ��ѯ�û��Ĺ�����Ϣ
	public void checkCustomer(Customer customer);

}
