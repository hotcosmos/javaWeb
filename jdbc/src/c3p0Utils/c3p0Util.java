package c3p0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Util {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	/**
	 * 获取DataSource对象
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	/**
	 * 获取连接Connection
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
	 * 释放资源
	 * @param conn
	 * @param pst
	 * @param rs
	 */
	public static void release(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pst != null) pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
