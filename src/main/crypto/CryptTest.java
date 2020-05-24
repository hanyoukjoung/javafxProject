package main.crypto;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class CryptTest {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		System.out.println("AES256");
		System.out.println(Aes256.getInstance().encrypt("403012"));
		
		System.out.println("SHA256");
		System.out.println(Sha256.encrypt("java"));
	}
}
