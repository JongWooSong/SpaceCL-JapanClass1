package chapter7.quiz.song;

public class StudentTest {

	public static void main(String[] args) {
		
		School school = new School("자바 일본 취업반 1기");
		
		Student st1 = new Student(100, "네코짱");
		Subject st1_sb1 = new Subject(Subject.CODE_KOREAN, Subject.CODE_KOREAN_NAME, 10);
		Subject st1_sb2 = new Subject(Subject.CODE_MATH, Subject.CODE_MATH_NAME, 90);
		Subject st1_sb3 = new Subject(Subject.CODE_ENG, Subject.CODE_ENG_NAME, 50);
		st1.addSubejct(st1_sb1);
		st1.addSubejct(st1_sb2);
		st1.addSubejct(st1_sb3);
		
		Student st2 = new Student(200, "송짱");
		Subject st2_sb1 = new Subject(Subject.CODE_KOREAN, Subject.CODE_KOREAN_NAME, 5);
		Subject st2_sb2 = new Subject(Subject.CODE_MATH, Subject.CODE_MATH_NAME, 40);
		Subject st2_sb3 = new Subject(Subject.CODE_ENG, Subject.CODE_ENG_NAME, 30);
		st2.addSubejct(st2_sb1);
		st2.addSubejct(st2_sb2);
		st2.addSubejct(st2_sb3);

		Student st3 = new Student(300, "임짱");
		Subject st3_sb1 = new Subject(Subject.CODE_KOREAN, Subject.CODE_KOREAN_NAME, 100);
		Subject st3_sb2 = new Subject(Subject.CODE_MATH, Subject.CODE_MATH_NAME, 100);
		Subject st3_sb3 = new Subject(Subject.CODE_ENG, Subject.CODE_ENG_NAME, 99);
		st3.addSubejct(st3_sb1);
		st3.addSubejct(st3_sb2);
		st3.addSubejct(st3_sb3);

		//학교에 등록
		school.addStudent(st1);
		school.addStudent(st2);
		school.addStudent(st3);
		
		school.showRank(null);
		
	}

}
