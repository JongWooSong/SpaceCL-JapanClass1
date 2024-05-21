package chapter7.quize.jeon;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		//ArrayList< >는 객체만 담을 수 있다, 레퍼클래스만 담을 수 있다.
		ArrayList arrayList = new ArrayList();
		
		Book book = new Book();
		
		
		
		arrayList.add(1);
		arrayList.add(1.1);
		arrayList.add("안녕하세요");
		arrayList.add(book);
		
		for(int i = 0; i<arrayList.size(); i ++) {
			System.out.println(arrayList.get(i));
		}
	}

}
