package chapter10.quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortTest {

	public static void main(String[] args) throws IOException {
		System.out.println("정렬 방식 선택");
		System.out.println("B : BubbleSort");
		System.out.println("H : HeapSort");
		System.out.println("Q : QuickSort");

		int ch = System.in.read();
		Sort sort = null;

		switch (ch) {
		case 'b':
		case 'B':
			sort = new Bubble();
			break;
		case 'h':
		case 'H':
			break;
		case 'q':
		case 'Q':
			break;
		}
		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		arr.add(7);
		arr.add(30);
		arr.add(8);
		arr.add(27);
		arr.add(16);
		
		
		// arr = sort.acending(arr);
		arr = sort.descending(arr);
		//sort.description();
		
		for(int i =0; i< arr.size(); i++) {
			System.out.print(arr.get(i) + "\t");
		}
		
		
	}

}
