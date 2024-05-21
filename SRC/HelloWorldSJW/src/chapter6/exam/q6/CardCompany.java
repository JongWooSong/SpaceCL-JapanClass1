package chapter6.exam.q6;

/**
 * 카드회사
 */
public class CardCompany {

	private static CardCompany cardCampany = new CardCompany();
	
	private int cardSerial = 1000;
	
	private CardCompany() {
		//다른객체에서 나를 new 하지 못하게 하는 방법
	}
	
	public static CardCompany getInstance() {
		return cardCampany;
	}
	
	public Card[] toIssue(int issueNumber) {
		
		Card cards[] = new Card[issueNumber];
		
		for(int i=0; i<issueNumber; i++) {
			int serial = getCardSerial();
			Card card = new Card(serial);	
			cards[i] = card;
		}
		
		return cards;
	}
	
	/** 
	 * 카드 고유번호를 발급한다.
	 * @return
	 */
	private int getCardSerial() {
		return ++cardSerial;
	}
	
}
