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
	
	public void sortBubble() {
		int stuSize = stuList.size();
		scores = new int[stuSize][2]; // ID, 점수
		
		// arr 초기화
		for(int i = 0; i < stuSize; i++) {
			scores[i][0] = stuList.get(i).studentID;
			scores[i][1] = stuList.get(i).totalScore;
		}
		
		int tempID;
		int tempScore;
		// 내림차순
		for(int i = 1; i < stuSize - 1; i++) {
			for(int j = 0; j < (stuSize - i); j++) {
				if(scores[j][1] < scores[j + 1][1]) {
					tempID = scores[j][0];
					tempScore = scores[j][1];
					scores[j][0] = scores[j+1][0];
					scores[j][1] = scores[j+1][1];
					scores[j+1][0] = tempID;
					scores[j+1][1] = tempScore;
				}
			}
		} // end for
	}
	
	// 전체 학생 랭킹 출력
	public void showStudentLankList() {
		sortBubble();
		// 등수 출력
		// TODO : 같은 점수일때 등수 체크 못함
		for(int i = 0; i < scores.length; i++) {
			System.out.println("학생ID: " + scores[i][0] + " 등수: " + (i+1));
		}
	}

	// 특정 학생 랭킹 출력
	public void showStudentLankList(int studentID) {
		sortBubble();
		
		for(Student s : stuList) {
			if(s.studentID == studentID) {
				System.out.print(s.studentName + "의 등수: " );
			}
		}
		
		for(int i = 0; i < scores.length; i++) {
			if(scores[i][0] == studentID) {
				System.out.println(i+1 + "등");
			}
		}
	}	
} // end class
