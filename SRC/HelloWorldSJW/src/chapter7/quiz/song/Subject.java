package chapter7.quiz.song;

public class Subject {
	
	/** 수학 */
	public static final int CODE_MATH = 1000;
	/** 국어 */
	public static final int CODE_KOREAN = 2000;
	/** 영어 */
	public static final int CODE_ENG = 3000;
	
	
	private int subjectCode; //과목 고유코드
	private String name; // 과목 이름
	private int scorePoint; // 과목 점수
	
	public Subject(int subjectCode, String name, int score) {
		this.subjectCode = subjectCode;
		this.name = name;
		this.scorePoint = score;
	}
	
	
	// getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScorePoint() {
		return scorePoint;
	}
	public void setScorePoint(int scorePoint) {
		this.scorePoint += scorePoint;
	}
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	
}//end class
