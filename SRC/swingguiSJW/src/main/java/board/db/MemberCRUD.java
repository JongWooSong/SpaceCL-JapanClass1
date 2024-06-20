package board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	};
	
	/**
	 * 회원 리스트를 취득한다.
	 * @return
	 */
	public List<MemberBean> getMemberList() {
		
		Connection conn = getConnection();
		List<MemberBean> list = new ArrayList<MemberBean>();
		
		try {
			//3.쿼리 수행을 위한 Statment 객체 생성
			Statement stmt = conn.createStatement();
			
			//4.쿼리 작성
			String sql = "select member_no, id, pw, name, email, addr, birthdate, hp, reg_dt, last_login_dt";
			sql += " from member";
			
			//5.쿼리수행
			ResultSet rs = stmt.executeQuery(sql);
			
			//6.쿼리 실행결과 출력하기
			while(rs.next()) { //1개의 row 씩 진행 
				MemberBean bean = new MemberBean();
				bean.setMemberNo( rs.getString("member_no") );
				bean.setId( rs.getString("id") );
				bean.setPw( rs.getString("pw") );
				bean.setName( rs.getString("name") );
				bean.setEmail( rs.getString("email") );
				bean.setAddr( rs.getString("addr") );
				bean.setBirthdate( rs.getString("birthdate") );
				bean.setHp( rs.getString("hp") );
				bean.setRegDt( rs.getString("reg_dt") );
				bean.setLastLoginDt( rs.getString("last_login_dt") );
				
				//add list
				list.add(bean);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//TODO 회원 ID 를 받아서 회원정보를 취득하는 메서드를 작성하시오! 
	//(안하면 2시간 화장실 안보내줌)
	public MemberBean getMember(String id) {
		Connection conn = getConnection();
		MemberBean mBean = new MemberBean();
		
		try {
			//3.쿼리 수행을 위한 Statment 객체 생성
			Statement stmt = conn.createStatement();
			
			//4.쿼리 작성
			String sql = "select member_no, id, pw, name, email, addr, birthdate, hp, reg_dt, last_login_dt";
			sql += " from member where id = '" + id +"'";
			
			//5.쿼리수행
			ResultSet rs = stmt.executeQuery(sql);
			
			//6.쿼리 실행결과 출력하기
			while(rs.next()) { //1개의 row 씩 진행 
				mBean.setMemberNo( rs.getString("member_no") );
				mBean.setId( rs.getString("id") );
				mBean.setPw( rs.getString("pw") );
				mBean.setName( rs.getString("name") );
				mBean.setEmail( rs.getString("email") );
				mBean.setAddr( rs.getString("addr") );
				mBean.setBirthdate( rs.getString("birthdate") );
				mBean.setHp( rs.getString("hp") );
				mBean.setRegDt( rs.getString("reg_dt") );
				mBean.setLastLoginDt( rs.getString("last_login_dt") );
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return mBean;
	}//end method
	
	
	/**
	 * ID, PW 로 해당멤버를 찾는 로직을 구현하시오. (안하면 화장실 3시간 못감)
	 * @param id
	 * @param pw
	 * @return true:해당멤버존재, false:멤버존재하지 않음
	 */
	public boolean getFindMember(String id, String pw) {
		boolean isRtn = false;
		
		Connection conn = getConnection();
		
		try {
			//3.쿼리 수행을 위한 Statment 객체 생성
			Statement stmt = conn.createStatement();
			
			//4.쿼리 작성
			String sql = "select count(*)";
			sql += " from member where id = '" + id +"' and pw='" + pw + "'";
			
			//5.쿼리수행
			ResultSet rs = stmt.executeQuery(sql);
			
			//6.쿼리 실행결과 출력하기
			rs.next();
			int cnt = rs.getInt(1);
			if(cnt > 0) {
				isRtn = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isRtn;
	}
	
	
	
	
	
	
}
