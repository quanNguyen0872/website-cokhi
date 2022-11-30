package com.iuh.nhom12.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.iuh.nhom12.model.Email;

public class EmailUtils {
	
	public static void send(Email email) {
		String host = "smtp.gmail.com";
		String password = "Test1234@";
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.starttls.required", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getFrom(), email.getFromPassword());
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email.getFrom()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
			message.setSubject(email.getSubject());
			message.setContent(email.getContent(), "text/html; charset=utf-8");
			
//			Transport.send(message);
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, email.getFrom(), password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
