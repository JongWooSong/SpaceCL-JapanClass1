package chapter7.quize.kyunam;

import java.util.ArrayList;

/**
 * 학교 클래스는 학생들(ArrayList<Student>)의 평균(avg)과 등수(rank)를 매기는 등 성적을 관리함 따라서, 학교
 * 클래스가 생성(Constructor)되면 입학한 학생들의 정보를 지녀야 함
 */
public class School {
	private ArrayList<Student> studentList; // 학생목록 배열을 선언

	// 생성자
	public School() {
		studentList = new ArrayList<Student>(); // 학생목록을 생성
	} // end school Constructor

	// 학생들을 학교에 입학
	public void addStudent(Student student) {
		studentList.add(student);
	}// end addStudent

	// 학생들의 총점을 구하는 함수
	public void setTotalOfStudents() {
		
		for (int i = 0; i < studentList.size(); i++) {
			
			int totalScore = 0;
			ArrayList<Subject> subjects = new ArrayList<Subject>();
			subjects = studentList.get(i).subjectList;

			for (Subject s : subjects) {
				totalScore += s.getScorePoint();
			} // end for

			studentList.get(i).total = totalScore;
		} // end for
	} // end setTotalOfStudents

	// 학생들의 평균을 구하는 함수
	public void setAvgOfStudents() {
		
		for (int i = 0; i < studentList.size(); i++) {
			
			int avgScore = 0;
			ArrayList<Subject> subjects = new ArrayList<Subject>();

			subjects = studentList.get(i).subjectList;
			avgScore += studentList.get(i).total / subjects.size();

			studentList.get(i).avg = avgScore;
		} // end for
		
	}// end setAvgOfStudents

	// 학생들의 순위를 구하는 함수
	public void setRankOfStudents() {
		
		for (int i = 0; i < studentList.size(); i++) {
			int cnt = 1;

			for (int j = 0; j < studentList.size(); j++) {
				
				if (studentList.get(j).avg > studentList.get(i).avg) {
					cnt += 1;
				} // end if
				
			} // end for
			
			studentList.get(i).rank = cnt;
		} // end for

	}

	// 학생들의 순위를 전부 보여주는 함수
	public void showRanking() {
		
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println("학생 " + studentList.get(i).studentName + "의 평균은 " + studentList.get(i).avg + "이므로 등수는 "
					+ studentList.get(i).rank + "입니다");
		}
	}

}
