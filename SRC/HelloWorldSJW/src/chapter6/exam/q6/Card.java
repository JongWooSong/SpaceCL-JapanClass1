package chapter6.exam.q6;

public class Card {

	private int serialNo;
	
	public Card(int serial) {
		serialNo = serial;
	}
	
	public void showCardInfo() {
		System.out.println("현재 카드 번호는: " + serialNo);
	}
	
}
