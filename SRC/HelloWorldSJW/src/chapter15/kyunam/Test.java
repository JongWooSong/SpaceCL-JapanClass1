package chapter15.kyunam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 1. 이름, 이메일, 주소, 휴대폰번호 입력 받아서 info.txt 파일에 저장한다.
 */

public class Test {

	public static void main(String[] args) {

		// 문자열을 입력받는 객체 선언
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("이메일을 입력하세요");
		String email = sc.nextLine();
		System.out.println("주소를 입력하세요");
		String address = sc.nextLine();
		System.out.println("휴대폰번호 입력하세요");
		String phoneNum = sc.nextLine();

		FileWriter fw = null;

		try {

			fw = new FileWriter("info.txt", true);
			fw.write(name + "\n");
			fw.write(email + "\n");
			fw.write(address + "\n");
			fw.write(phoneNum + "\n");

		} // end try

		catch (Exception e) {
			e.printStackTrace();
		} // end catch

		finally {

			try {
				fw.close();
			} // end try

			catch (IOException e) {
				e.printStackTrace();
			} // end catch

		} // end finally

	}// end main

}// end class
