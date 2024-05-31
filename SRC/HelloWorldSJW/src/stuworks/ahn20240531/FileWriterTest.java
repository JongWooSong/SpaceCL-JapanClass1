package stuworks.ahn20240531;

import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 입력: ");
		String name = sc.nextLine();
		
		System.out.println("이메일 입력: ");
		String email = sc.nextLine();
		
		System.out.println("주소 입력: ");
		String address = sc.nextLine();
		
		System.out.println("핸드폰 번호 입력: ");
		String phone = sc.nextLine();
		
		sc.close();
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("info.txt");
			fw.write(name + "\n");
			fw.write(email + "\n");
			fw.write(address + "\n");
			fw.write(phone);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			} // end try
		} // end try
		
		System.out.println("info.txt 파일로 출력되었습니다.");
	} // end main
}
