package chapter7.quize.jeon;

import java.util.ArrayList;

public class Student {

	int studentID;
	String studentName;
	ArrayList<Subject> subjectList;
	ArrayList<School> stuRank;
	
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		subjectList = new ArrayList<Subject>();
		stuRank = new ArrayList<School>();
	}
	
	
	public void addSubject(String name, int score) {
		Subject subject = new Subject();
		subject.setName(name);
		subject.setScorePoint(score);
		subjectList.add(subject);
	}
	
	public void showStudentInfo() {
		int total = 0;
		for(Subject s : subjectList) {
			total += s.getScorePoint();
			System.out.println("학생 "+studentName+"의"+s.getName()+" 과목성적은 "+s.getScorePoint()+"입니다.");
		}
		System.out.println("학생 "+studentName+"의 총점은 "+total+"입니다.");
	}

	
	public void showRankList() {
		int total = 0;
		int average = 0;
		for(Subject s : subjectList) {
			total += s.getScorePoint();
		}
		average = total/subjectList.size();
		System.out.println("학생 "+studentName+"의 평균은 "+average+"입니다.");
		
	}
	
}
