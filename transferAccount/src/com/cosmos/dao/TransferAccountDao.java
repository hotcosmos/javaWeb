package com.cosmos.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.cosmos.utils.DataSourceUtils;

public class TransferAccountDao {
	
	/**
	 * 从转出账户转出金额
	 * @param out
	 * @param money
	 * @throws SQLException 
	 */
	public void out(String out, double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		Connection conn = DataSourceUtils.getCurrentConnection();
		String sql = "update account set money=money-? where username=?";
		queryRunner.update(conn,sql, money,out);
	}
	
	/**
	 * 将金额转入指定账户
	 * @param in
	 * @param money
	 * @throws SQLException 
	 */
	public void in(String in, double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		Connection conn = DataSourceUtils.getCurrentConnection();
		String sql = "update account set money=money+? where username=?";
		queryRunner.update(conn,sql, money,in);
	}

}
