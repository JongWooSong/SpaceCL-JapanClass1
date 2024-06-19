package board.db;

public class TestQuery {

	public static void main(String[] args) {

		MemberCRUD memCRUD = new MemberCRUD();
		
		MemberBean mBean = new MemberBean();
		mBean.setId("asd3333");
		mBean.setPw("abcd1234");
		mBean.setName("홍길동3");
		mBean.setEmail("asd3333@naver.com");
		
		int cnt = memCRUD.insertMember( mBean );
		if(cnt == 0) {
			System.out.println("회원가입 실패");
		} else {
			System.out.println("회원가입 성공");
		}
		
	}

}
