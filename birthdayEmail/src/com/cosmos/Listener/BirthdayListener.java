package com.cosmos.Listener;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.cosmos.domain.Customer;
import com.cosmos.utils.MailUtils;
import com.cosmos.web.BirthdayServlet;

/**
 * 当工程发布后开始计时，每隔一天时间，查找数据库中今天过生日的人，早上8点定时发动生日祝福邮件
 * @author Administrator
 * @date 2018年4月21日
 */
public class BirthdayListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		//格式化时间，设置发送邮件时间为早上8点
		SimpleDateFormat sendformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sendTime = "2018-04-21 08:00:00";
		Date sendtime = null;
		try {
			sendtime = sendformat.parse(sendTime);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//设置定时器（任务调度）
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				
				//获取当前的日期
				SimpleDateFormat format = new SimpleDateFormat("MM-dd");
				String currentDate = format.format(new Date());
				
				//根据当前日期，从数据库中获取和当前日期相同的生日
				BirthdayServlet birthdayServlet = new BirthdayServlet();
				List<Customer> customerList =  birthdayServlet.getBirthday(currentDate);
				
				if(customerList != null && customerList.size() > 0) {
					for(Customer customer : customerList) {
						
						String emailMsg = "亲爱的：" + customer.getUsername() + "<br />祝你生日快乐！";
						try {
							//发送邮件
							MailUtils.sendMail(customer.getEmail(), "生日祝福", emailMsg);
							System.out.println(customer.getUsername() + "的邮件发送了....");
						} catch (AddressException e) {
							e.printStackTrace();
						} catch (MessagingException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				}
				
			}
		}, sendtime, 1000*60*60*24);
		
	}

}
