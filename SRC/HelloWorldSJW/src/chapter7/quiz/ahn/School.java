package chapter7.quiz.ahn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class School {
	String stuName;
	ArrayList<Student> stuList;
	private int[][] scores;

	// 생성자
	public School() {
		stuList = new ArrayList<Student>();
	}

	// 학교에 학생 추가
	public void addStudent(Student student) {
		stuList.add(student);
	}
	
 	// ArrayList 정렬
	public void sortStudentRank() {
		Collections.sort(stuList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.totalScore - o1.totalScore;
			}
			
		});
	}
	
	// 전체 학생 랭킹 출력
	public void showStudentRankList() {
		sortStudentRank();
		
		// 등수 출력
		// TODO : 같은 점수일때 등수 체크 못함
		for(int i = 0; i < stuList.size(); i++) {
			System.out.println(stuList.get(i).studentName + "의 점수: " + stuList.get(i).totalScore + " 등수: " + (i + 1));
		}
		
	}

	// 특정 학생 랭킹 출력
	public void showStudentRankList(int studentID) {
		sortStudentRank();
		
		for(int i = 0; i < stuList.size(); i++) {
			if(stuList.get(i).studentID == studentID) {
				System.out.println(stuList.get(i).studentID + " " + stuList.get(i).studentName + "의 등수: " + (i + 1));
			}
		}
	}
} // end class
