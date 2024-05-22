package chapter7.quiz.ahn;

import java.util.ArrayList;

public class Student {
	int studentID;
	String studentName;
	int totalScore;
	int average;
	
	ArrayList<Subject> subjectList; // ArrayList 선언하기
	
	// 생성자
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		subjectList = new ArrayList<Subject>(); // ArrayList 생성
	}
	
	/**
	 * 학생이 수강하는 과목 추가 메서드
	 * @param name 학생이름
	 * @param score 학생의 점수
	 */
	public void addSubject(String name, int score) {
		Subject subject = new Subject(); // Subject 생성
		subject.setName(name); // 과목 이름 추가
		subject.setScorePoint(score); // 점수 추가
		subjectList.add(subject); // 배열에 저장
		
		totalScore += score; // 총점
		average = (totalScore / subjectList.size()); // 평균
	}
	
	// 배열 요소 값 출력
	public void showStudentInfo() {
		for(Subject s: subjectList) { // 각 과목 성적
			System.out.println("학생 " + studentName + "의 " + 
			s.getName() + " 과목 성적은 " + s.getScorePoint() + "입니다.");
		} // end for
		System.out.println("학생 " + studentName + "의 총점은 " + totalScore + 
				" 평균은 " + average + "입니다.");
	} // end method
	
} // end class
