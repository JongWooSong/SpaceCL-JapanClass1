package chapter7;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		
		
		Integer ii = 1;
		int i2 = 2;
		long l2 = 100;
		
		if(  ii == i2 ) {
			
		}
		
		Book book = new Book();
			
		arrayList.add(1);
		arrayList.add(1.1);
		arrayList.add("안녕하세요?");
		arrayList.add(book);
		
		for(int i=0; i<arrayList.size(); i++) {
			System.out.println( arrayList.get(i) );
		}
		
	}

}
