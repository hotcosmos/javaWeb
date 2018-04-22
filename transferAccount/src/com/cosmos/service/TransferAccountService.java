package com.cosmos.service;

import com.cosmos.dao.TransferAccountDao;
import com.cosmos.utils.DataSourceUtils;

public class TransferAccountService {
	/**
	 * 实现转账方法
	 * 使用ThreadLocal进行线程绑定，存储当前线程的Connection对象，进行事务操作
	 * 
	 * @param out
	 * @param in
	 * @param money
	 * @return
	 */
	public boolean transfer(String out, String in, double money) {

		TransferAccountDao transferAccountDao = new TransferAccountDao();
		boolean isTransfer = true;
		
		//开启事务
			DataSourceUtils.statTransaction();
		try {
			//开始转账
			transferAccountDao.out(out, money);
			//int i = 1/0;   //制造转账失败原因
			transferAccountDao.in(in, money);
			
		} catch (Exception e) {
			DataSourceUtils.rollback();   //事务回滚
			isTransfer = false;
			e.printStackTrace();
		} finally {
			DataSourceUtils.commit();    //事务提交
		}

		return isTransfer;
	}

}
