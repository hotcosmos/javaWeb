package jdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc连接工具类 v3
 * @author Administrator
 * @date 2018年4月3日
 */
public class jdbcUtil_v3 {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	/**
	 * 使用db.propertise配置文件加载数据库信息
	 * 使用Properties对象
	 */
	static {
		try {
			ClassLoader classloader = jdbcUtil_v3.class.getClassLoader();
			InputStream inps = classloader.getResourceAsStream("db.properties");
			Properties pro = new Properties();
			pro.load(inps);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
