package DBUtilsTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import c3p0Utils.c3p0Util;
import domain.User;

public class dbUtilsTest {
	/**
	 * 使用DBUtils简化代码 update()方法 测试insert操作
	 */
	@Test
	public void testInsert() {
		try {
			// 创建QueryRunner类对象，（获取连接池DataSource对象）
			QueryRunner qr = new QueryRunner(c3p0Util.getDataSource());
			String sql = "insert into jdbc_user values(null,?,?)";
			Object[] params = { "王五", "111111" };
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用DBUtils简化代码 update()方法 测试update操作
	 */
	@Test
	public void testUpdate() {
		try {
			// 创建QueryRunner类对象，（获取连接池DataSource对象）
			QueryRunner qr = new QueryRunner(c3p0Util.getDataSource());
			String sql = "update jdbc_user set user_password=? where user_id=?";
			Object[] params = { "123456", 5 };
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("更新成功");
			} else {
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用DBUtils简化代码 update()方法 测试delete操作
	 */
	@Test
	public void testDelete() {
		try {
			// 创建QueryRunner类对象，（获取连接池DataSource对象）
			QueryRunner qr = new QueryRunner(c3p0Util.getDataSource());
			String sql = "delete from jdbc_user where user_id=?";
			Object[] params = { 6 };
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用DBUtils简化代码 query()方法 BeanHandler()封装一条记录
	 */
	@Test
	public void testSelectId() {
		try {
			QueryRunner qr = new QueryRunner(c3p0Util.getDataSource());
			String sql = "select * from jdbc_user where user_id=?";
			Object[] params = { 2 };
			User user = qr.query(sql, new BeanHandler<User>(User.class), params);
			System.out.println(user.getUser_username() + " :  " + user.getUser_password());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 使用DBUtils简化代码 query()方法 BeanListHandler()封装多条记录
	 */
	@Test
	public void testSelectAll() {
		try {
			QueryRunner qr = new QueryRunner(c3p0Util.getDataSource());
			String sql = "select * from jdbc_user";
			List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User user : users) {
				System.out.println(
						user.getUser_id() + "------" + user.getUser_username() + "------" + user.getUser_password());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 使用DBUtils简化代码 query()方法 ScalerHandler()封装单个数据
	 */
	@Test
	public void testSelectSingle() {
		try {
			QueryRunner qr = new QueryRunner(c3p0Util.getDataSource());
			String sql = "select count(*) from jdbc_user";
			Long count = (Long) qr.query(sql, new ScalarHandler());
			System.out.println(count);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 使用DBUtils简化代码 query()方法 MapListHandler()封装多条记录
	 */
	@Test
	public void testSelectAllMap() {
		try {
			QueryRunner qr = new QueryRunner(c3p0Util.getDataSource());
			String sql = "select * from jdbc_user";
			List<Map<String, Object>> lists = qr.query(sql, new MapListHandler());
			for (Map<String, Object> map : lists) {
				System.out.println(map + "    -------" + map.get("user_username"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
