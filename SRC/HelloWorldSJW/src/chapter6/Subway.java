package chapter6;

public class Subway {

	private String lineNumber;
	private int passengerCount;
	private int money;
	public final int PRICE;
	
	public Subway(String lineNum, int price) {
		lineNumber = lineNum;
		PRICE = price;
	}
	
	/**
	 * 지하철 탑승 + 수익 계산
	 * @param money
	 */
	public void take() {
		this.money += PRICE;
		passengerCount += 1;
	}
	
	public int takeOff() {
		//TODO 여러분이 코딩 해보세요
		if(passengerCount > 0) {
			passengerCount -= 1;
		}
		return passengerCount;
	}
	
	public void showInfo() {
		System.out.println(lineNumber + " 호선의 승객은 " + passengerCount 
				+ "명, 수입: " + money);
	}
}
