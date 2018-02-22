package com.fruit.dao;

import java.util.List;
import java.util.Map;

import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;

public interface FruitManagerDao {
	// ��dao����չ���Ա�û�������Ϣ,�����ݿ��в�ѯ,����true/false
	public abstract boolean getManager(Manager manager);

	// ���ˮ����Ϣ
	public abstract boolean add(Fruit fruit);

	// �޸�ˮ����Ϣ
	public abstract boolean update(Fruit fruit);

	// ɾ��ˮ����Ϣ
	public boolean delete(Fruit fruit);

	// ��ѯӪҵ��¼
	public List<Customer> query(String startDate, String endDate);

	// ��ѯ�û��Ĺ�����Ϣ
	public List<Map<String,Object>> checkCustomer(int id);
}
