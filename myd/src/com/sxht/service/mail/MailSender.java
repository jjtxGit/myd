package com.sxht.service.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

	private Properties props = null;// 配置文件
	private Session session = null;// 邮件会话
	private MimeMessage message = null;// 邮件内容
	private Transport transport = null;// 邮件发送

	public MailSender(String userName, String password) {

		props = new Properties();
		props.put("mail.smtp.host", "smtp.163.com");// 存储发送邮件服务器的信息
		props.put("mail.smtp.auth", "true");// 同时通过验证

		session = Session.getInstance(props);
		session.setDebug(true);// 打印一些调试信息

		message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(userName));
		} catch (MessagingException e1) {
			System.out.println("发件人地址错误" + userName);
			e1.printStackTrace();
		}

		try {

			transport = session.getTransport();
			transport.connect(userName, password);

		} catch (NoSuchProviderException e) {
			System.out.println("邮件服务器连接错误");
			e.printStackTrace();
			return;
		}

		catch (MessagingException e) {
			System.out.println("邮箱或密码错误");
			e.printStackTrace();
			return;

		}
	}

	/**
	 * 设置发送的地址
	 * 
	 * @param to
	 */
	public void sendMailTo(String to) {
		try {
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		} catch (MessagingException e) {
			System.out.println("发送地址错误");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 设置邮件内容
	 * 
	 * @param subject
	 * @param content
	 */
	public void setMailMessage(String subject, String content) {
		try {
			message.setSubject(subject);
			message.setText(content);
			message.saveChanges();
		} catch (MessagingException e) {
			System.out.println("内容填充错误");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 发送邮件
	 */
	public void send() {
		try {
			transport.sendMessage(message, message.getAllRecipients());
			// transport.close();
		} catch (Exception e) {
			System.out.println("发送时出现错误");
			e.printStackTrace();
			return;
		}
	}
}