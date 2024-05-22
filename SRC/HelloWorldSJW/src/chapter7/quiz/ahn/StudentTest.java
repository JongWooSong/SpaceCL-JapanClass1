package chapter7.quiz.ahn;

public class StudentTest {
	public static void main(String[] args) {
		Student studentLee = new Student(1001, "Lee");
		studentLee.addSubject("국어", 100);
		studentLee.addSubject("수학", 50);
		
		Student studentKim = new Student(1002, "Kim");
		studentKim.addSubject("국어", 70);
		studentKim.addSubject("수학", 85);
		studentKim.addSubject("영어", 100);
		
		Student student3 = new Student(1003, "MAN");
		student3.addSubject("국어", 60);
		student3.addSubject("수학", 50);
		student3.addSubject("영어", 60);
		
//		studentLee.showStudentInfo();
//		System.out.println("====================");
//		studentKim.showStudentInfo();
//		System.out.println("====================");
//		student3.showStudentInfo();
		
		School school = new School();
		school.addStudent(studentLee);
		school.addStudent(studentKim);
		school.addStudent(student3);
		
		// 전체 학생 랭킹 리스트
		school.showStudentLankList();
		System.out.println();
		// 특정 학생의 랭킹 확인
		school.showStudentLankList(1002); // 학생ID
		
	}
}
