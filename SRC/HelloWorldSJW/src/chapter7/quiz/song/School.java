package chapter7.quiz.song;

import java.util.ArrayList;
import java.util.Comparator;

public class School {

	private String schoolName;
	private ArrayList<Student> stuList;
	private ArrayList<Integer> stuRankIdList;
	private ArrayList<Integer> stuRankList;
	
	public School(String schoolName) {
		this.schoolName = schoolName;
		stuList = new ArrayList<Student>();
		stuRankIdList = new ArrayList<Integer>();
		stuRankList = new ArrayList<Integer>();
	}
	
	public void addStudent(Student student) {
		//TODO 중북학생은 리스트에 추가하지 않는다.
		stuList.add(student);
	}
	
	public void showRank(Student student) {
		if(student == null) {
			//TODO 전체 학생의 랭크를 출력한다.
			
		}
		else {
			//TODO 해당 학생의 랭크를 출력한다.
			
		}
	}
	
	private void showRankCalc() {
		
		stuRankIdList.clear();
		stuRankList.clear();
		
		for(int i=0; i<stuList.size(); i++) {
			
			stuList.get(i).getAverage()
			
		}
		
		
	}
	
}
