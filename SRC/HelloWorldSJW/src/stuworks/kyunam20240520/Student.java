package stuworks.kyunam20240520;

public class Student {
	public String studentName; // 학생이름
	public int garde; // 학년
	public int money; // 학생이 지닌 돈
	public boolean isBusTransfar = false;
	public boolean isSubwayTransfar = false;	
	
	// 생성자 생성 및 멤버변수(학생이름, 돈) 초기화
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}// end Constructor Student

	public int takeBus(Bus bus) {
		bus.take(this); // 해당 버스의 금액 입력

		return money; // 차감하고 남은돈 반환
	}// end method takeBus

	public int takeSubway(Subway subway) {
		subway.take(this);

		return money; // 차감하고 남은돈 반환
	}// end method takeSubway

	public void takeBusOff(Bus bus) {
		bus.takeOff();
		isBusTransfar = true;
	}
	
	public void takeSubwayOff(Subway subway) {
		subway.takeOff();
		isSubwayTransfar = true;
	}
	
	public void showInfo() {
		System.out.println(studentName + "님의 남은 돈은 " + money + "입니다.");
	}// end method showInfo

}
