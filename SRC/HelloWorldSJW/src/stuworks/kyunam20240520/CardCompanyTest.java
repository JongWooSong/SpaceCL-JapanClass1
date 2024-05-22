package stuworks.kyunam20240520;

public class CardCompanyTest {

	public static void main(String[] args) {
		
		CarCompany company = CarCompany.getInstance();
		
		Card myCard = company.createCard();
		Card yourCard = company.createCard();
		
		System.out.println(myCard.getCardNum());
		System.out.println(yourCard.getCardNum());
	}
	
}
