package stuworks.ahn20240520;

public class Student {
	
	public static int serialNum = 10; // 고정된 = 전역!
	
	private String studentName; // 학생 이름
	private int grade; // 학년
	private int money; // 학생이 가지고 있는 돈
	private int busCnt, subCnt;
	
	// 학생 이름과 가진 돈을 매개변수로 받는 생성자
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}

	public int takeBus(Bus bus) {
		int discount = 0;
		if(busCnt > 0 || subCnt > 0) { // 50% 할인
			System.out.println("50% 할인");
			discount = bus.take(true); // 버스 돈+
			money -= discount;
		}else {
			bus.take(false);
			money -= bus.charge; // 학생 돈-
		}
		return money;
	}
	
	public int takeSubway(Subway subway) {
		int discount = 0;
		if(subCnt > 0) { // 지하철 무료
			System.out.println("지하철 무료");
			discount = subway.take("free");
		}else if(busCnt > 0) {
			System.out.println("50% 할인");
			discount = subway.take("half");
			this.money -= discount;
		}else {
			this.money -= subway.charge;
		}
		
		return money;
	}
	
	public void takeBusOff(Bus bus) {
		busCnt++;
		bus.takeOff(); // 해당 버스에서 내릴게요
	}
	
	public void takeSubwayOff(Subway subway) {
		subCnt++;
		subway.takeOff(); // 지하철 하차
	}
	
	// 학생의 현재 정보를 출력하는 메서드
	public void showInfo() {
		System.out.println(studentName + "님의 남은 돈은 " + money + "입니다.");
	}
} // end class
