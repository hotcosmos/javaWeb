package dbcpUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class dbcpUtil {
	private static DataSource dataSource;
	/**
	 * 使用静态代码块加载properties配置文件
	 */
	static {
		try {
			ClassLoader classLoader = dbcpUtil.class.getClassLoader();
			InputStream ips = classLoader.getResourceAsStream("db.properties");
			Properties props = new Properties();
			props.load(ips);
			//创建数据源
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取DataSource对象
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	/**
	 * 获得连接Connection
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
