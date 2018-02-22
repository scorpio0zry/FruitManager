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

	// 从数据库查看水果是否存在
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

	// 数据库中查看所有水果信息
	@Override
	public void check() {
		String sql = "SELECT * FROM fruit";
		try {
			List<Fruit> list = qr.query(sql, new BeanListHandler<Fruit>(
					Fruit.class));
			System.out.println("品种\t价格\t存货\t");
			for (Fruit fruit : list) {
				System.out.println(fruit);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
