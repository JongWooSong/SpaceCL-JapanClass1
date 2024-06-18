package swing.swinggui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Doit2Insert {

	public static void main(String[] args) {
		
		Doit2Insert doit2Insert = new Doit2Insert();
		
		DoitBean doitBean = new DoitBean();
		doitBean.setCol2("두번째열");
		doitBean.setCol4("444");
		doitBean.setCol5("555");
		doitBean.setCol6("666");
		doitBean.setCol7("777");
		
		//doit2Insert.insert(doitBean);
	}
	
	
	public String insert(Connection conn, DoitBean insBean) throws Exception {
		
		String lastInsertId = null;
		
		//3.쿼리준비
		String sql = "INSERT INTO doit2(col2, col4, col5, col6, col7) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//4.데이터 binding
		pstmt.setString(1, insBean.getCol2() );
		pstmt.setString(2, insBean.getCol4());
		pstmt.setString(3, insBean.getCol5());
		pstmt.setString(4, insBean.getCol6());
		pstmt.setString(5, insBean.getCol7());
		
		//5.쿼리실행 
		int cnt = pstmt.executeUpdate();
		
		//insert 된 row 수
		if(cnt == 0) {
			System.out.println("데이터 입력 실패");
			throw new Exception("데이터 Insert 실패");
		} else {
			System.out.println("데이터 입력 성공");
			
			//TODO select select last_insert_id();
			String sql2 = "select last_insert_id()";
			ResultSet rs = pstmt.executeQuery(sql2);
			if(rs.next()) {
				lastInsertId = rs.getString(1);
			}
			
		}
			
		return lastInsertId;
		
	}//end method
	
}
