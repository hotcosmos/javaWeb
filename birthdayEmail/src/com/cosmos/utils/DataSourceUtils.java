package com.cosmos.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	// 创建连接池
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	// 创建ThreadLoacal对象进行线程绑定
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	/**
	 * 获取DataSource对象
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 获得当前线程(ThreadLocal)的Connection对象
	 * 
	 * @return
	 */
	public static Connection getCurrentConnection() {
		// 从ThreadLocal中查找当前线程是否有Connection
		Connection conn = threadLocal.get();
		if (conn == null) {
			conn = getConnection(); // 获得新的Connection
			threadLocal.set(conn); // 将conn绑定到ThreadLocal中
		}
		return conn;
	}

	/**
	 * 获取一个连接池中的Connection对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 开启事务
	 */
	public static void statTransaction() {
		try {
			getCurrentConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 提交事务
	 */
	public static void commit() {
		try {
			getCurrentConnection().commit();
			threadLocal.remove(); // 将当前连接对象Connection从ThreadLocal中移除
			release(getCurrentConnection(), null, null); // 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 回滚事务
	 */
	public static void rollback() {
		try {
			getCurrentConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 * @param pst
	 * @param rs
	 */
	public static void release(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pst != null)
				pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
