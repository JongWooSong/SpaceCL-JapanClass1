package board.db;

import java.util.List;

public class TestQuery {

	public static void main(String[] args) {

		MemberCRUD memCRUD = new MemberCRUD();
		
		//회원가입
//		MemberBean mBean = new MemberBean();
//		mBean.setId("asd3333");
//		mBean.setPw("abcd1234");
//		mBean.setName("홍길동3");
//		mBean.setEmail("asd3333@naver.com");
//		
//		int cnt = memCRUD.insertMember( mBean );
//		if(cnt == 0) {
//			System.out.println("회원가입 실패");
//		} else {
//			System.out.println("회원가입 성공");
//		}
		
		//회원 리스트 취득
		List<MemberBean> list = memCRUD.getMemberList();
		if(list != null && list.size() > 0) {
			for(int i=0; i<list.size(); i++) {
				MemberBean mb = list.get(i);
			}
		}
		
	}//end method;

}
