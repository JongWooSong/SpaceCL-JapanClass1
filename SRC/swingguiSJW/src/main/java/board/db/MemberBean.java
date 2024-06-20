package board.db;

import lombok.Data;

@Data
public class MemberBean {

	private String memberNo;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String addr;
	private String birthdate;
	private String hp;
	private String regDt;
	private String lastLoginDt;
	
	public void printAll() {
		System.out.println( 
			memberNo + ", " + id + ", " + pw + ", " + name + ", " + email + ", " 
			+ addr + ", " + birthdate + ", " + hp + ", " + regDt + ", " + lastLoginDt 
		);
	}

}
