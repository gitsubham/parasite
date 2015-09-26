package org.nasscom.parasite.base;


import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

public class DbFactory {

	private volatile BasicDataSource ds = null;

	private static DbFactory pool = new DbFactory();

	private DbFactory() {
	}

	public static DbFactory getInstance() {
		return pool;
	}

	public void init() throws Exception {
		ds = new BasicDataSource();
		ds.setDriverClassName(Application.DRIVER_CLASS);
		ds.setUrl(Application.DB_URL);
		ds.setUsername(Application.DB_USER);
		ds.setPassword(Application.DB_PWD);
	}

	public Connection getConnection() throws Exception {
		return getConnection(true);
	}

	public Connection getConnection(boolean autoCommit) throws Exception {
		Connection con = null;
		try {
			if (ds == null) {
				synchronized (DbFactory.class) {
					if (ds == null) {
						init();
					}
				}
			}
			con = ds.getConnection();
			con.setAutoCommit(autoCommit);
		} catch (Exception e) {
			System.out.println("[Error] Enable to get Database connection.");
			throw e;
		}
		return con;
	}
}
