package com.digi.csvfileprocess.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	@Value("${mail.to}")
	private String mailTo;

	@Value("${mail.username}")
	private String from;

	@Value("${mail.password}")
	private String password;

	public void sendMail(String subject, String msg) {
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);// change accordingly
			}
		});
		// compose message

		try {
			MimeMessage message = new MimeMessage(session);
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText(msg);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setRecipients(Message.RecipientType.TO,mailTo);

			try {
				message.setFrom(new InternetAddress("rammailsending@gmail.com", "Subscriber Uploaded Files Count"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			message.setSubject(subject.toString());
			message.setText(msg);

			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}