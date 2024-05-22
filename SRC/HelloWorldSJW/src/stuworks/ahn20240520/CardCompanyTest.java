package stuworks.ahn20240520;

public class CardCompanyTest {
	public static void main(String[] args) {
		CardCompany company = CardCompany.getInstance();
		
		Card card1 = company.createCard();
		Card card2 = company.createCard();
		
		System.out.println(card1.getCardNumber());
		System.out.println(card2.getCardNumber());
	}
}
