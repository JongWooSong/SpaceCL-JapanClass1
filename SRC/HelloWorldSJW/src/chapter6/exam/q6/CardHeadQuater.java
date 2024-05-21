package chapter6.exam.q6;

public class CardHeadQuater {

	public static void main(String[] args) {
		
		//카드공장으로부터 카드를 3장 하라
		CardCompany cardCompany = CardCompany.getInstance();
		Card[] cardList = cardCompany.toIssue(100);
		
		for(int i=0; i<cardList.length; i++) {
			cardList[i].showCardInfo();
		}//end for
		
		
	}//end method
	
}
