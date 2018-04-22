package jdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc连接工具类 v1
 * @author Administrator
 * @date 2018年4月3日
 */
public class jdbcUtil_v1 {
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb?useUnicode=true&characterEncoding=utf8","root","950426");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
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
