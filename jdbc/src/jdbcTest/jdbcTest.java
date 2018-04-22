package jdbcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import c3p0Utils.c3p0Util;
import dbcpUtils.dbcpUtil;
import jdbcUtils.jdbcUtil;
import jdbcUtils.jdbcUtil_v1;
import jdbcUtils.jdbcUtil_v2;
import jdbcUtils.jdbcUtil_v3;

/**
 * 使用 junit 测试 jdbc工具类和 c3p0工具类
 * @author Administrator
 * @date 2018年4月4日
 */
public class jdbcTest {
	/**
	 * jdbc工具类测试select查询
	 */
	@Test
	public void testQuery() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = jdbcUtil.getConnection();
			String sql = "select user_username,user_password from jdbc_user where user_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 2);
			rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("用户名："+rs.getString("user_username")+"\t密码："+rs.getString("user_password"));
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			jdbcUtil.release(conn, pst, rs);
		}	
	}
	/**
	 * jdbc工具类v1测试插入
	 */
	@Test
	public void testInsert() {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = jdbcUtil_v1.getConnection();
			String sql = "insert into jdbc_user values(null,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1,"lisi");
			pst.setString(2,"111111");
			int i = pst.executeUpdate();
			if(i>0) {
				System.out.println("添加成功");
			}else {
				System.out.println("添加失败");
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			jdbcUtil_v1.release(conn, pst,null);
		}	
	}
	/**
	 * jdbc工具类v2测试删除
	 */
	@Test
	public void testDelete() {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = jdbcUtil_v2.getConnection();
			String sql = "delete from jdbc_user where user_id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,4);
			int i = pst.executeUpdate();
			if(i>0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			jdbcUtil_v2.release(conn, pst,null);
		}	
	}
	/**
	 * jdbc工具类v3测试更新
	 */
	@Test
	public void testUpdate() {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = jdbcUtil_v3.getConnection();
			String sql = "update jdbc_user set user_password='123456' where user_username=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,"lisi");
			int i = pst.executeUpdate();
			if(i>0) {
				System.out.println("更新成功");
			}else {
				System.out.println("更新失败");
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			jdbcUtil_v3.release(conn, pst,null);
		}	
	}
	/**
	 * 使用c3p0工具类测试select
	 */
	@Test
	public void testC3P0Query() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = c3p0Util.getConnection();
			String sql = "select user_id,user_username,user_password from jdbc_user where user_username=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,"zhangsan");
			rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("用户id:"+rs.getInt("user_id")+"\t用户名："+rs.getString("user_username")+"\t密码："+rs.getString("user_password"));
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			c3p0Util.release(conn, pst, rs);
		}	
	}
	/**
	 * 使用dbcp工具类测试select
	 */
	@Test
	public void testDBCPQuery() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = dbcpUtil.getConnection();
			String sql = "select user_id,user_username,user_password from jdbc_user where user_username=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,"张三");
			rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println("用户id:"+rs.getInt("user_id")+"\t用户名："+rs.getString("user_username")+"\t密码："+rs.getString("user_password"));
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			dbcpUtil.release(conn, pst, rs);
		}	
	}
}
