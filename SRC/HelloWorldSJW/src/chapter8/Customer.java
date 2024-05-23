package chapter8;

public class Customer {
	private int customerID; // 고객 아이디
	private String customerName; // 고객 이름
	private String customerGrade; // 고객 등급
	protected int bonusPoint; // 보너스 포인트
	protected double bonusRatio; // 적립 비율
	
	public Customer() {
		customerGrade = "SILVER"; // 기본 등급
		bonusRatio = 0.01; // 보너스 포인트 기본 적립 비율
		System.out.println("Customer() 생성자");
	}
	
	public Customer(int customerId) {
		//super();
		this.customerID = customerId;
		System.out.println("Customer(int customerId) 생성자");
	}
	
	public int calcPrice(int p) {
		bonusPoint += p * bonusRatio; // 보너스 포인트 계산
		return p;
	}
	
	public String showCustomerInfo() {
		return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}
	
	@Override
	public String toString() {
		return "안녕 나는 Customer 클래스야";
	}
	
} // end class
