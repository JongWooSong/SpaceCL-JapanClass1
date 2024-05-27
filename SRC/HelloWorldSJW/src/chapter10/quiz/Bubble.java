package chapter10.quiz;

import java.util.Comparator;
import java.util.List;

public class Bubble implements Sort{

	@Override
	public List<Integer> acending(List<Integer> list) {
		list.sort(Comparator.naturalOrder());
		return list;
	}

	@Override
	public List<Integer> descending(List<Integer> list) {
		list.sort(Comparator.reverseOrder());

		return list;
	}

	@Override
	public void description(List<Integer> list) {

	}



}
