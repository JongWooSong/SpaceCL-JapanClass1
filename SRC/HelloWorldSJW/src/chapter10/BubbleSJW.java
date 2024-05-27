package chapter10;

import java.util.Comparator;
import java.util.List;

import chapter10.quiz.Sort;

public class BubbleSJW implements Sort {

	@Override
	public String toString() {
		return "안녕? 난 버블이야";
	}
	
	@Override
	public List<Integer> acending(List<Integer> list) {
		list.sort( Comparator.naturalOrder() );
		return list;
	}

	@Override
	public List<Integer> descending(List<Integer> list) {
		list.sort( Comparator.reverseOrder() );
		return list;
	}

	@Override
	public void description(List<Integer> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.print( "===> " + list.get(i) + ", " );
		}
	}

}
