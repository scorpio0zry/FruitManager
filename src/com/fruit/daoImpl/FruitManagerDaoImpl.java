package com.fruit.daoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.fruit.dao.FruitManagerDao;
import com.fruit.domain.Customer;
import com.fruit.domain.Fruit;
import com.fruit.domain.Manager;
import com.fruit.utils.JDBCUtils;

public class FruitManagerDaoImpl implements FruitManagerDao {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	// ��dao����չ���Ա�û�������Ϣ,�����ݿ��в�ѯ,����true/false

	@Override
	public boolean getManager(Manager manager) {
		String sql = "SELECT * FROM manager WHERE username = ? AND password = ?";
		Object[] params = { manager.getUsername(), manager.getPassword() };
		try {
			Manager m = qr.query(sql, new BeanHandler<Manager>(Manager.class),
					params);
			if (m == null) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return true;
	}

	// ���ˮ����Ϣ
	@Override
	public boolean add(Fruit fruit) {
		String sql = "INSERT INTO fruit VALUES (null,?,?,?)";
		Object[] params = { fruit.getBrand(), fruit.getPrice(),
				fruit.getStock() };
		try {
			int row = qr.update(sql, params);
			if (row != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new RuntimeException("���ˮ����Ϣʧ�ܣ�");
		}
	}

	// �޸�ˮ����Ϣ
	@Override
	public boolean update(Fruit fruit) {
		String sql = "UPDATE fruit SET price= ?,stock= ? WHERE brand = ?";
		Object[] params = { fruit.getPrice(), fruit.getStock(),
				fruit.getBrand() };
		try {
			int row = qr.update(sql, params);
			if (row != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new RuntimeException("�޸�ˮ����Ϣʧ�ܣ�");
		}

	}

	// ɾ��ˮ����Ϣ
	@Override
	public boolean delete(Fruit fruit) {
		String sql = "DELETE FROM fruit WHERE brand = ?";
		try {
			int row = qr.update(sql, fruit.getBrand());
			if (row != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new RuntimeException("ɾ��ˮ����Ϣʧ�ܣ�");
		}
	}

	// ��ѯӪҵ��¼
	@Override
	public List<Customer> query(String startDate, String endDate) {
		String sql = "SELECT * FROM customer WHERE time BETWEEN ? AND ?";
		try {
			List<Customer> list = qr.query(sql, new BeanListHandler<Customer>(
					Customer.class), startDate, endDate);
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("��ѯӪҵ��ʧ�ܣ�");
		}
	}

	// ��ѯ�û��Ĺ�����Ϣ
	@Override
	public List<Map<String, Object>> checkCustomer(int id) {
		String sql = "SELECT brand,num FROM buyfruit WHERE id = ?";
		try {
			List<Map<String, Object>> list = qr.query(sql,
					new MapListHandler(), id);
			return list;

		} catch (SQLException e) {
			throw new RuntimeException("��ѯ�ͻ�������Ϣʧ�ܣ�");
		}
	}

}
