package chapter12;

public class Powder extends Meterial {

	@Override
	public void doPrinting() {
		System.out.println("Powder 재료를 출력 합니다.");
	}
	
	public String toString() {
		return "재료는 Powder 입니다.";
	}

}
