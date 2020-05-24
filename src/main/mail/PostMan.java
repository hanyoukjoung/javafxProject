package main.mail;

import javax.mail.MessagingException;

public class PostMan {
	private static int authNum;

	private static int getAuthNum() {
		return (int) (Math.random() * 100000);
	}

	public static void main(String[] args) {

		authNum = getAuthNum();

		String from = "winterkjoung@naver.com";
		String to = "winterkjoung@naver.com";
		String cc = "";
		String subject = "test��";
		String content = "������ȣ��" + authNum + "�Դϴ�.";

		if (from.trim().equals("")) {
			System.out.println("������ ����� �Է����� �ʾҽ��ϴ�.");
		} else if (to.trim().equals("")) {
			System.out.println("�޴� ����� �Է����� �ʾҽ��ϴ�.");
		} else {
			try {
				Mail mt = new Mail();

				mt.sendMail(from, to, cc, subject, content);
				System.out.println("�������ۿ� ����");
			} catch (MessagingException me) {
				System.out.println("�������۽���");
				System.out.println("��������" + me.getMessage());
				me.printStackTrace();
			} catch (Exception e) {
				System.out.println("�������۽���");
				System.out.println("��������" + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
