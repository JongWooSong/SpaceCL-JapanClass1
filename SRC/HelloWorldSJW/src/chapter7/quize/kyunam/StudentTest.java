package chapter7.quize.kyunam;

/**
 * 교제 229p.
 * 학생이 수강하는 과목들의 성정을 출력하는 프로그램
 * 
 * 문제
 * 1. showStudentInfo() 메소드 호출시 학생의 순위 출력
 * 2. School 객체가 필요하므로 클래스 생성하기
 * 3. addStudent() 메소드로 학생을 추가하기
 * 4. showStudentRankingList() 메소드로 전체 학생들의 순위 출력
 */
public class StudentTest {
	
	public static void main(String[] args) {
		
		Student studentLee = new Student(1001, "Lee");
		studentLee.addSubject("국어", 100);
		studentLee.addSubject("수학", 50);
		
		Student studentKim = new Student(1002, "Kim");
		studentKim.addSubject("국어", 70);
		studentKim.addSubject("수학", 85);
		studentKim.addSubject("영어", 85);
		
		Student studentPark = new Student(1003, "Park");
		studentPark.addSubject("국어", 30);
		studentPark.addSubject("수학", 20);
		studentPark.addSubject("영어", 75);
		
		School school = new School();
		school.addStudent(studentLee);
		school.addStudent(studentKim);
		school.addStudent(studentPark);
		
		school.setTotalOfStudents();
		school.setAvgOfStudents();
		school.setRankOfStudents();
		
		studentLee.showStudentInfo();
		System.out.println("========================================");
		studentKim.showStudentInfo();
		System.out.println("========================================");
		studentPark.showStudentInfo();
		System.out.println("========================================");

		school.showRanking();
	}
	
}
