package main.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import main.packet.FilePacket;
import main.packet.FileRequestPacket;

public class ServerConnector {
	
	/**
	 * Socket 통신을 통해 서버로의 파일 전송을 위한 정적 메서드
	 * 
	 * @author 정재훈
	 * @param filePacket
	 * @param file
	 * @return True / False
	 * 
	 * 이 메서드는 파일 전송을 위한 FilePacket과 Path값을 포함한 File 객체가 필요합니다.
	 * 
	 */
	public void fileTransfer(FilePacket filePacket, File file) throws IOException{
		Socket socket = new Socket("192.168.203.33", 8887);
		
		ObjectOutputStream fOos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		fOos.flush();
		
		ObjectInputStream fOis = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
		
		// 파일 전송 시작을 알리는 패킷 전송
		fOos.writeObject(filePacket);
		System.out.println("Forward ID : " + filePacket.getForwardId());
		System.out.println("Destination : " + filePacket.getDestinationId());
		System.out.println("FileName : " + filePacket.getFileName());
		System.out.println("File Ext Name : " + filePacket.getFileExtName());
		System.out.println("File Size : " + filePacket.getFileSize());
		System.out.println("roomNum : " + filePacket.getRoomNum());
		System.out.println("File Purpose : " + filePacket.getPurpose().name());
		
		fOos.flush();
		System.out.println("File Packet Transfer");
		
		System.out.println("Make Buffer");
		byte[] buf = new byte[8192];
		System.out.println(buf.length);
		
		System.out.println("Make new Socket(8887)");

		System.out.println("Make I/O Stream");
		
		FileInputStream fis = new FileInputStream(file);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		System.out.print("전송중");
		int i = 0;
		int cnt = 1;
		while((i = fis.read(buf)) != -1) {
			System.out.println("Send size = " + i);
			dos.write(buf, 0, i);
			System.out.println("flush " + cnt++ + " . . .");
		}
		dos.flush();
		System.out.println("파일 전송 완료");
		
		fis.close();
		dos.close();
		
		buf = null;
		
		System.out.println("Socket Closing . . .");
	}
	
	/**
	 * Socket 통신을 통해 서버로부터 파일을 받기 위한 정적 메서드
	 *
	 * @exception IOException - File객체의 경로에 이미 파일이 존재하는 경우
	 * @param fileRequestPacket
	 * @param file
	 * @return True / False
	 * 
	 * 이 메서드는 파일 수신을 위한 FileRequestPacket과 파일을 저장할 Path값을 포함한 File 객체가 필요합니다.
	 * 
	 */
	public static void fileRequest(FileRequestPacket fileRequestPacket, File file) throws IOException{
		if(file.isFile()) {
			throw new IOException("해당 경로에 파일이 이미 존재합니다 .");
		}
		
		System.out.println("Socket Connecting . . .");
		Socket socket = new Socket("192.168.203.33", 8887);
		System.out.println("Socket Connected Successfully");
		
		System.out.println("Oos Connecting . . .");
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		oos.flush();
		System.out.println("Oos Connected Successfully");
		
		System.out.println("Ois Connecting . . .");
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
		System.out.println("Ois Connected Successfully");
		
		
		System.out.println("Start Transfer << FileRequestPacket >>");
		oos.writeObject(fileRequestPacket);
		oos.flush();
		System.out.println("Finish Transfer Successfully");
		
		System.out.println("Make Buffer");
		byte[] buf = new byte[8192];
		System.out.println("Buffer's Length : " + buf.length);
		
		System.out.println("InputStream Connectiong . . .");
		InputStream is = socket.getInputStream();
		System.out.println("InputStream Connected Successfully");
		
		System.out.println("Fos Connecting . . .");
		FileOutputStream fos = new FileOutputStream(file);
		System.out.println("Fos Connected Successfully");
		
		System.out.println("File Receiving . . .");
		int i=0, cnt = 1;
		while(( i = is.read(buf) ) != -1 ) {
			System.out.println("Recv size = " + i);
			fos.write(buf, 0, i);
			System.out.println("Flushing " + cnt++ + " . . .");
		}
		System.out.println("Finish Receiving Successfully");
		
		fos.flush();
		socket.close();
		
		buf = null;
		
		System.out.println("Socket Closing . . .");
	}
}
