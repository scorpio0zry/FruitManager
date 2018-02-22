package com.fruit.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.fruit.dao.FruitShopperDao;
import com.fruit.domain.BuyFruit;
import com.fruit.domain.Shopper;
import com.fruit.utils.JDBCUtils;

public class FruitShopperDaoImpl implements FruitShopperDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	// ���˿͹�������ݴ洢���ݿ���
	@Override
	public void account(Shopper shopper) {
		// ���˿������еĽ�ʱ�����customer����
		insertCustomer(shopper);
		// ���˿�������fruit���ϴ��뵽buyfruit����
		insertBuyFruit(shopper);
		// �޸�fruit���еĿ��
		updateFruit(shopper);

	}

	// �޸�fruit���еĿ��
	private void updateFruit(Shopper shopper) {
		ArrayList<BuyFruit> fruit = shopper.getFruit();
		for (BuyFruit buyFruit : fruit) {
			// ��ѯ��ˮ����ԭ���
			String sql = "SELECT stock FROM fruit WHERE brand = ?";
			int stock;
			try {
				stock = qr.query(sql, new ScalarHandler<Integer>(),
						buyFruit.getFruit());
				sql = "UPDATE fruit SET stock = ? WHERE brand = ?";
				Object[] params = { stock - buyFruit.getNum(),
						buyFruit.getFruit() };
				qr.update(sql, params);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�޸Ŀ��ʧ��");
			}

		}
	}

	// ���˿�������fruit���ϴ��뵽buyfruit����
	private void insertBuyFruit(Shopper shopper) {
		// �ҵ��ù˿Ͷ������customer���е�id
		int id = select(shopper);
		// ����shopper�е�list���ϣ����δ��뵽buyfruit���У�����idֵ��customer��buyfruit��ϵ����
		ArrayList<BuyFruit> fruit = shopper.getFruit();
		for (BuyFruit buyFruit : fruit) {
			String sql = "INSERT INTO buyfruit VALUES (NULL,?,?,?)";
			Object[] params = { buyFruit.getFruit(), buyFruit.getNum(), id };
			try {
				qr.update(sql, params);
			} catch (SQLException e) {
				throw new RuntimeException("�˿�����buyfruit�����ʧ��");
			}
		}
	}

	// ���˿������еĽ�ʱ�����customer����
	private void insertCustomer(Shopper shopper) {
		String sql = "INSERT INTO customer VALUES (NULL,?,?)";
		Object[] params = { shopper.getMoney(), shopper.getDatetime() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException("�˿�����customer�����ʧ��");
		}
	}

	// ��ѯ�˿ʹ������ݵ�id
	private int select(Shopper shopper) {
		String sql = "SELECT id FROM customer WHERE time = ?";
		try {
			int id = qr.query(sql, new ScalarHandler<Integer>(),
					shopper.getDatetime());
			return id;
		} catch (SQLException e) {
			throw new RuntimeException("�˿�id��ѯʧ��");
		}
	}

}
