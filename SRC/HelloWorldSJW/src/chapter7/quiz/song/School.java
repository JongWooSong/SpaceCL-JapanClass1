package chapter7.quiz.song;

import java.util.ArrayList;
import java.util.Collections;

public class School {

	private String schoolName;
	private ArrayList<Student> stuList;
	
	public School(String schoolName) {
		this.schoolName = schoolName;
		stuList = new ArrayList<Student>();
	}
	
	public void addStudent(Student student) {
		//TODO 중북학생은 리스트에 추가하지 않는다.
		stuList.add(student);
	}
	
	public void showRank(Student student) {
		if(student == null) {
			//TODO 전체 학생의 랭크를 출력한다.
			showRankCalc();
		}
		else {
			//TODO 해당 학생의 랭크를 출력한다.
			
		}
	}
	
	private void showRankCalc() {
		
		Collections.sort(stuList, new StudentComparator());
		
		for(int i=0; i<stuList.size(); i++) {
			Student st = stuList.get(i);
			System.out.println(st.getStudentId() + " , " + st.getStuName() + ", " + st.getAverage());
		}
		
		//최종적으로 찍을때는 
		int rankCount = 1;
		for(int i=stuList.size()-1; i>=0; i--) {
			Student st = stuList.get(i);
			System.out.println( rankCount +"등 ==> " + 
					st.getStudentId() + " , " + st.getStuName() 
					+ ", " + st.getAverage()
					);
			rankCount += 1;
		}
	}
	
}


