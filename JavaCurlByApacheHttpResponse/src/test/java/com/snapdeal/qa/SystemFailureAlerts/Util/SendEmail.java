/**
 * 
 */
package com.snapdeal.qa.SystemFailureAlerts.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author mohammad.akhtar
 */
public class SendEmail {

	/**
	 * @param string
	 * @param failedSystems
	 * 
	 */
	public static void sendEmail(ArrayList<String> failedSystems, String recipient) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("automation.set@gmail.com", "qatesting");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("automation.set@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject("Systems Failure Alert On Staging Test Environment | " + new Date());
			String body = "Hi Team,\n\nBelow Systems are not responding on staging.\n";
			int index = 1;
			for (String system : failedSystems) {
				body = body.concat(index + ". " + system + "\n");
			}
			message.setText(body);
			Transport.send(message);
			System.out.println("Message Sending Done!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
