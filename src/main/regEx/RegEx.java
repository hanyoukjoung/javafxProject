package main.regEx;

import java.util.regex.Pattern;

public class RegEx {
	// 아이디 정규식
	public static boolean checkMemId(String mem_id) {
		String regEx = "[a-zA-Z0-9_-]{5,20}";
		return Pattern.matches(regEx, mem_id);
	}

	// 이름 정규식
	public static boolean checkMemName(String mem_name) {
		String regEx = "[가-힣]{2,5}";
		return Pattern.matches(regEx, mem_name);
	}

	// 비밀번호 정규식
	public static boolean checkMemPw(String mem_pw) {
		String regEx = "^(?=.*[a-zA-Z0-9])(?=.*\\W).{8,16}$";
		return Pattern.matches(regEx, mem_pw);
	}

	// 이메일 정규식
	public static boolean checkMemMail(String mem_mail) {
		String regEx = "^[a-zA-Z0-9._%+-]{5,20}";
		return Pattern.matches(regEx, mem_mail);
	}
	
	// 핸드폰 번호 정규식
	public static boolean checkMemTel(String mem_tel) {
		String regEx = "[0-9]{8}";
		return Pattern.matches(regEx, mem_tel);
	}
}
