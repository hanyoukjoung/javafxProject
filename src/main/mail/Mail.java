package main.mail;



import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	public void sendMail(String from,String to,String cc,String subject,String content) throws Exception{
		
		Properties props = new Properties();
		
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host","smtp.naver.com");
		props.put("mail.smtp.port","587");
		props.put("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		
		Authenticator auth = new SMTPAuthenticator();
		Session mailSession = Session.getDefaultInstance(props,auth);
		
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(from));
		
		msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to,false));
		
		if(!cc.trim().equals("")) {
			msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to,false));
			
		}
		
		msg.setSentDate(new Date());
		
		msg.setSubject(subject);
		
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(content);
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		//multipart.addBodyPart(messageBodyPart);
		
//		messageBodyPart = new MimeBodyPart();
//		File file = new File("D:/sumin.txt");
//		FileDataSource fds = new FileDataSource(file);
//		messageBodyPart.setDataHandler(new DataHandler(fds));
//		messageBodyPart.setFileName(fds.getName());
	//	multipart.addBodyPart(messageBodyPart);
		
//		messageBodyPart = new MimeBodyPart();
//		File file2 = new File("D:/A_TeachingMaterial/5.JQuery/workspace/webpro/WebContent/button1.html");
//		fds = new FileDataSource(file2);
//		messageBodyPart.setDataHandler(new DataHandler(fds));
//		String fileName = fds.getName();
//		fileName = new String(fileName.getBytes("KSC5601"),"8859_1");
//		messageBodyPart.setFileName(fileName);
	//	multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		
		
		Transport.send(msg);	
	}
}
