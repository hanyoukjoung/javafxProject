package main.crypto;

public class RandomChar {
	
	/**
	 * @author 정재훈
	 * @param  서버에서 파일을 저장할 때 고유값을 생성하는 메서드
	 * @return 서버 시간값 기반 String 타입 고유값
	 */
	public static String longToBase64() {	
	    final char[] digits = {
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
	        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
	        'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
	        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
	        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
	        'Y', 'Z', '#', '$'
	    };
	    
	    int shift = 6;
	    char[] buf = new char[64];
	    int charPos = 64;
	    int radix = 1 << shift;
	    long mask = radix - 1;
	    long number = System.currentTimeMillis();
	 
	    do {
	        buf[--charPos] = digits[(int) (number & mask)];
	        number >>>= shift;
	    } while (number != 0);
	 
	    return new String(buf, charPos, (64 - charPos));
	}
}
