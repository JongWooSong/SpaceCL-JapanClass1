package chapter6;

public class Subway {

	private String lineNumber;
	private int passengerCount;
	private int money;
	
	public Subway(String lineNum) {
		lineNumber = lineNum;
	}
	
	/**
	 * 지하철 탑승 + 수익 계산
	 * @param money
	 */
	public void take(int money) {
		this.money += money;
		passengerCount += 1;
	}
	
	public int takeOff(int passengerCount) {
		//TODO 여러분이 코딩 해보세요
		return 0;
	}
	
	public void showInfo() {
		System.out.println(lineNumber + " 호선의 승객은 " + passengerCount 
				+ "명, 수입: " + money);
	}
}
