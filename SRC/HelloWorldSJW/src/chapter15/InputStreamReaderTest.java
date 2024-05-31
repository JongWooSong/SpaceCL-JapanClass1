package chapter15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public static void main(String[] args) {
		
		InputStreamReader isr = null;
		
		try {
			FileInputStream fis = 
					new FileInputStream("C:/DEV/WORKS/SpaceCL-JapanClass1/README.md");
			isr = new InputStreamReader( fis );
			
			int i;
			while( (i=isr.read()) != -1 ) {
				System.out.print( (char)i );
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
