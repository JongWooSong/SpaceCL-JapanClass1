package chapter8_2;

import chapter8.Customer;

public class VIPCustomer extends Customer {
	private int agentID; // VIP 고객 상담원 아이디
	double saleRatio; // 할인율
	
	public VIPCustomer() {
//		customerGrade = "VIP"; // 상위 클래스에서 private 변수. 오류발생
		//super();
		bonusPoint = 10;
		bonusRatio = 0.05;
		saleRatio = 0.1;
		System.out.println("VIPCustomer() 생성자");
	}
	
	public VIPCustomer(int agentId) {
		super(agentId);
		this.agentID = agentId;
		System.out.println("VIPCustomer(int agentId) 생성자");
	}
	
	public int getAgentID() {
		return agentID;
	}
	
//	@Override //어노테이션 : 표식이면서 코드 
//	public int calcPrice(int price) {
//		return 0;
//	}
	
	@Override
	public String toString() {
		super.toString();
		return "안녕 나는 VIPCustomer 클래스야";
	}
	
}
