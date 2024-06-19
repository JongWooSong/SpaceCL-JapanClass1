package board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberCRUD extends CommonCRUD {

	
	/**
	 * 회원을 추가한다.
	 * @param conn
	 * @param mBean
	 * @return
	 */
	public int insertMember(MemberBean mBean) {
		
		Connection conn = getConnection();
		int cnt = 0;
		
		try {
			//3.쿼리준비
			String sql = "INSERT INTO member(id, pw, name, email) VALUES(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4.데이터 binding
			pstmt.setString(1, mBean.getId() );
			pstmt.setString(2, mBean.getPw());
			pstmt.setString(3, mBean.getName());
			pstmt.setString(4, mBean.getEmail());
			
			//5.쿼리실행 
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
}
