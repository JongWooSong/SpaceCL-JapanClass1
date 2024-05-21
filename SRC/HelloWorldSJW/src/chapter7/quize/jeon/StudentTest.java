package chapter7.quize.jeon;

public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student(1001,"Lee");
		studentLee.addSubject("국어", 100);
		studentLee.addSubject("수학", 50);
		studentLee.addSubject("영어", 100);
		
		Student studentKim = new Student(1002,"Kim");
		studentKim.addSubject("국어", 70);
		studentKim.addSubject("수학", 85);
		studentKim.addSubject("영어", 100);
		
		Student studentPark = new Student(1003,"Park");
		studentPark.addSubject("국어", 90);
		studentPark.addSubject("수학", 45);
		studentPark.addSubject("영어", 100);
		
		studentLee.showStudentInfo();
		studentLee.showRankList();
		System.out.println("=====================================");
		studentKim.showStudentInfo();
		studentKim.showRankList();
		System.out.println("=====================================");
		studentPark.showStudentInfo();
		studentPark.showRankList();
		
	}
}
