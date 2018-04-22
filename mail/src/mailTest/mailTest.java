package mailTest;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import mailUtils.MailUtils;

public class mailTest {

	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		String email = "hotcosmos@126.com";
		String subject = "测试邮件";
		String emailMsg = "<h1>这是一封测试邮件</h1>,请<a href='#'>点击激活</a>。";
		MailUtils.sendMail(email, subject, emailMsg);
	}

}
