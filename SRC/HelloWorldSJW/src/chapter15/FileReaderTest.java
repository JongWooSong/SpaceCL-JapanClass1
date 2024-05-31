package chapter15;

import java.io.FileReader;

public class FileReaderTest {

	public static void main(String[] args) {

		FileReader fr;
		
		try {
			fr = new FileReader("C:/DEV/WORKS/SpaceCL-JapanClass1/README.md");
			
			int i;
			while( (i=fr.read()) != -1 ) {
				System.out.print( (char)i );
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
