package chapter7.quiz.song;

import java.util.ArrayList;

/**
 * 학생 정보
 * @author SJW
 * @since 2024.05.22
 */
public class Student {

	private int studentId;
	private String stuName;
	private ArrayList<Subject> subjectList;
	
	/**
	 * 생성자
	 * @param stuId 학생고유ID 
	 * @param stuName 학생이름
	 */
	public Student(int stuId, String stuName) {
		this.studentId = stuId;
		this.stuName = stuName;
		subjectList = new ArrayList<Subject>();
	}
	
	/**
	 * 과목 추가 
	 * @param subject 과목객체
	 */
	public void addSubejct(Subject subject) {
		
		boolean isSameSubjectFind = false;
		
		//먼저 리스트를 돌면서 같은 과목코드가 있는지를 찾아낸다.
		for(int i=0; i<subjectList.size(); i++) {
			Subject sub = subjectList.get(i);
			if( subject.getSubjectCode() == sub.getSubjectCode() ) {
				//같은 과목이 있으면 기존 과목에 점수를 더하겠다.
				sub.setScorePoint( subject.getScorePoint() );
				isSameSubjectFind = true;
			}
		}
		
		if(!isSameSubjectFind) {
			//같은 과목이 없을때 과목 리스트에 신규추가 하겠다.
			subjectList.add(subject);	
		}
	}//end method
	
	/**
	 * 평균점수를 반환하는 메서드
	 * @return 평균점수값
	 */
	public int getAverage() {
		int tot = 0;
		for(int i=0; i<subjectList.size(); i++) {
			tot += subjectList.get(i).getScorePoint();
		}
		
		int avg = tot / subjectList.size();
		return avg;
	}//end method

	
	
	//get
	public int getStudentId() {
		return studentId;
	}

	public String getStuName() {
		return stuName;
	}
}
