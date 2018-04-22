package com.cosmos.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cosmos.service.TransferAccountService;

public class TransferAccountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取数据
		request.setCharacterEncoding("UTF-8");
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		double money = Double.parseDouble(request.getParameter("money"));
		
		//实现转账
		TransferAccountService transferAccountService = new TransferAccountService();
		boolean isTransfer = transferAccountService.transfer(out,in,money);
		
		//输出页面提示
		response.setContentType("text/html; charset=UTF-8");
		if(isTransfer) {
			response.getWriter().write("转账成功");
		}else {
			response.getWriter().write("转账失败");
		}
	}
}