package com.cosmos.service;

import java.sql.SQLException;
import java.util.List;

import com.cosmos.dao.BirthdayDao;
import com.cosmos.domain.Customer;

public class BirthdayService {

	public List<Customer> getBirthday(String currentDate) {
		
		BirthdayDao birthdayDao = new BirthdayDao();
		List<Customer> customerList = null;
		try {
			customerList = birthdayDao.getBirthday(currentDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customerList;
	}

}
