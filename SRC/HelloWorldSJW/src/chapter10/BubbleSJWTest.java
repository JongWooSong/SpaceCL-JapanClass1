package chapter10;

import java.util.ArrayList;
import java.util.List;

public class BubbleSJWTest {

	public static void main(String[] args) {

		BubbleSJW b = new BubbleSJW();
		BubbleSJW b2 = new BubbleSJW();
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(1);
		list.add(9);
		list.add(10);
		list.add(0);
		
		//b.acending(list);
		List<Integer> ll = b.descending(list);
		//b.description(ll);
		
//		System.out.println(b);
//		
//		String str = new String("test");
//		System.out.println(str.toString());
//		
//		Long l = 100L;
//		System.out.println( l );
		
		if( b.equals(b2) ) {
			System.out.println("b와 같다.");
		} else {
			System.out.println("b와 같지 않다.");
		}
		
		
		
		
	}

}
