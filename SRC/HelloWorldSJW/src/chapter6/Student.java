package chapter6;

public class Student {

	private String studentName;
	private int grade;
	private int money;
	
	//생성자
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	public int takeBus(Bus bus) {
		bus.take(100);
		money -= 100;
		return money;
	}
	
	public int takeSubway(Subway subway) {
		subway.take(1000);
		money -= 1000; //차감
		return money;
	}
	
	public void showInfo() {
		System.out.println(studentName + "님이 남은 돈은: " + this.money);
	}
	
	
	
}
