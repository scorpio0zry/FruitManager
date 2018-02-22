package com.fruit.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fruit.dao.FruitDao;
import com.fruit.domain.Fruit;
import com.fruit.utils.JDBCUtils;

public class FruitDaoImpl implements FruitDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	// �����ݿ�鿴ˮ���Ƿ����
	@Override
	public Fruit existFruit(String brand) {
		String sql = "SELECT * FROM fruit WHERE brand = ?";
		try {
			Fruit fruit = qr.query(sql, new BeanHandler<Fruit>(Fruit.class),
					brand);
			return fruit;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// ���ݿ��в鿴����ˮ����Ϣ
	@Override
	public void check() {
		String sql = "SELECT * FROM fruit";
		try {
			List<Fruit> list = qr.query(sql, new BeanListHandler<Fruit>(
					Fruit.class));
			System.out.println("Ʒ��\t�۸�\t���\t");
			for (Fruit fruit : list) {
				System.out.println(fruit);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
