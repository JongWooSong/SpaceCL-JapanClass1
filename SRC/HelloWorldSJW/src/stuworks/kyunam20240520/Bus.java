package stuworks.kyunam20240520;

public class Bus {
	private int busNumber;
	private int passengerCount;
	private int money;
	public final int COAST;

	public Bus(int busNumber, int coast) {
		this.busNumber = busNumber;
		COAST = coast;
	} // end Bus Constructor

	/**
	 * 버스 탑승 + 수익 계산
	 * @param money
	 */
	public void take(Student student) {
		
		student.money -= student.isSubwayTransfar ? (COAST/2) : student.isBusTransfar ? 0 : COAST;
		money += student.isSubwayTransfar ? (COAST/2) : student.isBusTransfar ? 0 : COAST;
		passengerCount++;
		
	} // end method take

	/**
	 * 몇명이 내렸는지 카운트 세는 메서드 단 0 이하일때는 마이터스르 표기하지 않는다.
	 * @param passengerCount
	 */
	public void takeOff() {
		if(passengerCount > 0)  
			passengerCount--;
	}

	public void showInfo() {
		System.out.println("버스 " + busNumber + "번의 승객은 " + passengerCount + "명이고, 수입은 " + money + "입니다.");
	} // end method showInfo

}
