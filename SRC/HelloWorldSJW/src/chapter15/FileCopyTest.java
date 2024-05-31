package chapter15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {

		double millsecond = 0;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			FileInputStream fis = 
					new FileInputStream("C:/Program Files (x86)/Microsoft/Edge/Application/125.0.2535.67/msedge.dll");
			bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream("msedge.dll");
			bos = new BufferedOutputStream(fos);

			// 파일을 복사하기 전 시간
			millsecond = System.currentTimeMillis();

			int i;
			while ((i = bis.read()) != -1) {
				bos.write(i);
			} // end while

			// 파일을 복사하는데 거리는 시간 계산
			millsecond = (System.currentTimeMillis() - millsecond) / 1000 / 60;
			
		} // end try
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// end catch
		

		System.out.println("파일 복사하는 데 " + millsecond + " millseconds 소요되었습니다.");

	}// end main

}// end class