package chapter6;

public class Student {

	public static int serialNum = 10; //고정된 = 전역!
	
	private String studentName;
	private int grade;
	private int money;
	
	//생성자
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	public int takeBus(Bus bus) {
		bus.take();
		money -= bus.PRICE;
		
		
		Bus.main(null);
		TakeTrans.main(null);
		
		return money;
	}
	
	public int takeSubway(Subway subway) {
		subway.take();
		money -= subway.PRICE; //차감
		int a;
		return money;
	}
	
	public void takeBusOff(Bus bus) {
		bus.takeOff(); //해당 버스에서 내릴께요
	}
	
	public void takeSubwayOff(Subway subway) {
		subway.takeOff(); //해당 버스에서 내릴께요
	}
	
	public void showInfo() {
		System.out.println(studentName + "님이 남은 돈은: " + this.money);
	}
	
	
	
}
