package chapter6;

public class Bus {

	private int busNumber;
	private int passengerCount;
	private int money;
	public final int PRICE;
	
	public Bus(int busNum, int price) {
		this.busNumber = busNum;
		this.PRICE = price; //상수 초기화
	}
	
	/**
	 * 버스요금을 받아서 money(수익) 을 증가 시키겠다.
	 * @param money
	 */
	public void take() {
		this.money += PRICE;
		passengerCount++; //몇명 탔는지 
	}
	
	/**
	 * 몇명이 내렸는지 카운트 세는 메서드
	 * 단 0 이하일때는 마이너스로 표기하지 않는다.
	 * @param passegerCount
	 */
	public void takeOff(int passegerCount) {
		//TODO 여러분들이 짜보세요
	}
	
	public void showInfo() {
		System.out.println("버스 번호:" + busNumber 
				+ ", 승객수: " + passengerCount 
				+ ", 현재수익: " + money
				);
	} 
	
	
	
}
