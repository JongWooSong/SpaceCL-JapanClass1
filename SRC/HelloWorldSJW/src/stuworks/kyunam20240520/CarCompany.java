package stuworks.kyunam20240520;

public class CarCompany {
	private static int cardNum = 1000;
	private static CarCompany instance = new CarCompany();

	private CarCompany() {	}

	public static CarCompany getInstance() {
		if (instance == null) {
			instance = new CarCompany();
		}
		return instance;
	}

	public Card createCard() {
		return new Card(cardNum += 1);
	}

}
