package jdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * jdbc连接工具类 v2
 * @author Administrator
 * @date 2018年4月3日
 */
public class jdbcUtil_v2 {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	/**
	 * 使用db.propertise配置文件加载数据库信息
	 * 使用ResourcBundle对象
	 */
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
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
