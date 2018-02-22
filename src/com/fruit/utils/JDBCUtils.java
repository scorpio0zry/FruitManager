package com.fruit.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private JDBCUtils() {
	}

	private static BasicDataSource ds = new BasicDataSource();
	private static String classDriver;
	private static String url;
	private static String user;
	private static String password;

	static {
		try {
			read();
			ds.setDriverClassName(classDriver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(" ˝æ›ø‚º”‘ÿ ß∞‹!");
		}
	}

	public static DataSource getDataSource() {
		return ds;
	}

	private static void read() throws IOException {
		Properties p = new Properties();
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream(
				"fruit.properties");
		p.load(is);
		classDriver = p.getProperty("classDriver");
		url = p.getProperty("url");
		user = p.getProperty("user");
		password = p.getProperty("password");
	}
}
