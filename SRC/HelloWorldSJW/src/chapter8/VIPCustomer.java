package chapter8;

public class VIPCustomer extends Customer {
	private int agentID; // VIP 고객 상담원 아이디
	double saleRatio; // 할인율
	
	public VIPCustomer() {
//		customerGrade = "VIP"; // 상위 클래스에서 private 변수. 오류발생
		bonusRatio = 0.05;
		saleRatio = 0.1;
	}
	
	public int getAgentID() {
		return agentID;
	}
}
