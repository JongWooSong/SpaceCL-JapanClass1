package chapter7.quiz.song;

public class StudentComparator  implements java.util.Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		System.out.print(o1.getStuName() + ", " + o1.getAverage() + " <=====> ");
		System.out.println(o2.getStuName() + ", " + o2.getAverage());
		
		return o1.getAverage() - o2.getAverage();
	}

}
