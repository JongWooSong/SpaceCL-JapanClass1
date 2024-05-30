package chapter14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileException {

	public static void main(String[] arg) {
		
		try {
			FileInputStream fs = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//무조건 실행 되는 곳
			//try 실행되고 에러가 나도 실행되고, 에러가 안나도 실행되고
			System.out.println("finally 실행");
		}
		
	}
	
}
