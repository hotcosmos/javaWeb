package com.cosmos.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cosmos.domain.Customer;
import com.cosmos.utils.DataSourceUtils;

public class BirthdayDao {

	public List<Customer> getBirthday(String currentDate) throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from customer where birthday like ?";
		List<Customer> customerList = queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class), "%"+currentDate+"%");
		
		return customerList;
	}

}
