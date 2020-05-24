package main.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 	단방향 암호화 알고리즘 SHA-256 적용
 * 
 * 	@author	정재훈
 * 	==== 적용 jar file ====
 * 	======================
 */

public class Sha256 {
	/**
     * SHA-256으로 해싱하는 메소드
     * 
     * @param str
     * 			암호화할 문자열
     * @return 암호화 한 문자열
     * @throws NoSuchAlgorithmException
     * 				자바 버전이 낮아 해당 알고리즘을 사용할 수 없을 때 발생 
     */
    public static String encrypt(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes());
        
        return bytesToHex(md.digest());
    }
 
 
    /**
     * 바이트를 헥스값으로 변환한다
     * 
     * @param bytes
     * 			암호화 할 문자열의 byte 배열
     * @return String
     * 			암호화 한 문자열
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes) {
          builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
