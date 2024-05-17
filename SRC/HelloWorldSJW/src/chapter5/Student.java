/**
 * 
 */
package chapter5;


/**
 * 
 */
public class Student {

	/** 클래스의 멤버변수 **/
	int studentID; //학번
	String studentName; //학생 이름
	int grade; //학년
	String address; //사는곳
	final boolean isGlasses = false; //안경사용유무 
	String schoolName;
	
	
	/** 멤버 함수 --> 메서드(method) = function **/
	public void showStudentInfo(/** 매개변수, 인수, 파라미터(parameter) */) { //학생의 정보를 표시하는 일을 한다.
		System.out.println(studentName + ", " + grade + ", " + address );
	}
	
	//학번을 받아서 학년을 반환하는 함수
	public int getGrade(int studentID) {
		System.out.println("내가 받은 학번:" + studentID);
		//학번 앞자리가 1로 시작하면 1학년 
		//9로 시작하면 9학년
		int grade = studentID / 10;
		this.grade = 11;
		
		System.out.println("당신의 학년은:" + grade);
		
		return grade;
	}
	
	public static void main(String[] args) {
		
		//Student 클래스를 사용
		Student stu1 = new Student();
		Student stu2 = new Student();
		
		stu1.studentName = "홍길동";
		stu1.address ="금천구";
		stu1.showStudentInfo();
		int grade = stu1.getGrade(25);
		System.out.println("다시한번더 출력 - 당신의 학년: " + grade);
		stu1.showStudentInfo();
		
		
		//stu2
//		stu2.studentName = "성춘향";
//		stu2.address = "강남구";
//		stu2.showStudentInfo();
//		int grade2 = stu2.getGrade(55);
//		System.out.println("다시한번더 출력 - 당신의 학년: " + grade2);
	}
	
	
	
}//end class