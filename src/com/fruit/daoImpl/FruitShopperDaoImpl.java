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

	// 将顾客购买的数据存储数据库中
	@Override
	public void account(Shopper shopper) {
		// 将顾客数据中的金额，时间存入customer表中
		insertCustomer(shopper);
		// 将顾客数据中fruit集合存入到buyfruit表中
		insertBuyFruit(shopper);
		// 修改fruit表中的库存
		updateFruit(shopper);

	}

	// 修改fruit表中的库存
	private void updateFruit(Shopper shopper) {
		ArrayList<BuyFruit> fruit = shopper.getFruit();
		for (BuyFruit buyFruit : fruit) {
			// 查询该水果的原库存
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
				throw new RuntimeException("修改库存失败");
			}

		}
	}

	// 将顾客数据中fruit集合存入到buyfruit表中
	private void insertBuyFruit(Shopper shopper) {
		// 找到该顾客对象存入customer表中的id
		int id = select(shopper);
		// 遍历shopper中的list集合，依次存入到buyfruit表中，利用id值将customer和buyfruit联系起来
		ArrayList<BuyFruit> fruit = shopper.getFruit();
		for (BuyFruit buyFruit : fruit) {
			String sql = "INSERT INTO buyfruit VALUES (NULL,?,?,?)";
			Object[] params = { buyFruit.getFruit(), buyFruit.getNum(), id };
			try {
				qr.update(sql, params);
			} catch (SQLException e) {
				throw new RuntimeException("顾客数据buyfruit表存入失败");
			}
		}
	}

	// 将顾客数据中的金额，时间存入customer表中
	private void insertCustomer(Shopper shopper) {
		String sql = "INSERT INTO customer VALUES (NULL,?,?)";
		Object[] params = { shopper.getMoney(), shopper.getDatetime() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException("顾客数据customer表存入失败");
		}
	}

	// 查询顾客存入数据的id
	private int select(Shopper shopper) {
		String sql = "SELECT id FROM customer WHERE time = ?";
		try {
			int id = qr.query(sql, new ScalarHandler<Integer>(),
					shopper.getDatetime());
			return id;
		} catch (SQLException e) {
			throw new RuntimeException("顾客id查询失败");
		}
	}

}
