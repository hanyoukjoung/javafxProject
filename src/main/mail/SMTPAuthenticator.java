package main.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
	
	public PasswordAuthentication getPasswordAuthentication() {
		String username = "woodudfo@naver.com";
		String password = "dkspahsp77";
		return new PasswordAuthentication(username, password);
	}

}