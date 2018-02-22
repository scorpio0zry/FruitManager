package com.fruit.controllerImpl;

//controller������: ���Ʋ�   (��ȡ�����ϵ�����,Ϊ������������; ��Ҫʵ�ֵĹ��ܽ���ҵ��㴦��)
import java.util.List;

import com.fruit.controller.FruitManagerController;
import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;
import com.fruit.serviceImpl.FruitManagerServiceImpl;

//����Ա���Ʋ�
public class FruitManagerControllerImpl implements FruitManagerController {
	FruitManagerServiceImpl fmsi = new FruitManagerServiceImpl();

	// ���չ���Ա�û�������Ϣ,���ݸ�service��
	@Override
	public boolean getManager(Manager manager) {
		boolean flag = fmsi.getManager(manager);
		return flag;
	}

	// ���ˮ����Ϣ
	@Override
	public boolean add(Fruit fruit) {
		boolean flag = fmsi.add(fruit);
		return flag;
	}

	// �޸�ˮ����Ϣ
	@Override
	public boolean update(Fruit fruit) {
		boolean flag = fmsi.update(fruit);
		return flag;
	}

	// ɾ��ˮ����Ϣ
	@Override
	public boolean delete(Fruit fruit) {
		boolean flag = fmsi.delete(fruit);
		return flag;
	}

	// ��ѯӪҵ��¼
	@Override
	public List<Customer> query(String startDate, String endDate) {
		List<Customer> list = fmsi.query(startDate, endDate);
		return list;
	}

	// ��ѯ�û��Ĺ�����Ϣ
	@Override
	public void checkCustomer(Customer customer) {
		fmsi.checkCustomer(customer);
	}

}
