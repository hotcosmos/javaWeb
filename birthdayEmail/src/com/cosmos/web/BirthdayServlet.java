package com.cosmos.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cosmos.domain.Customer;
import com.cosmos.service.BirthdayService;

public class BirthdayServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("hello Servlet...");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public List<Customer> getBirthday(String currentDate) {
		
		BirthdayService birthdayService = new BirthdayService();
		List<Customer> customerList = birthdayService.getBirthday(currentDate);
		
		return customerList;
	}
}