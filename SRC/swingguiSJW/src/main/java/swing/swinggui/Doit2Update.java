package swing.swinggui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Doit2Update {

	public static void main(String[] args) {
		Doit2Update doit2Update = new Doit2Update();
		
		DoitBean doitBean = new DoitBean();
		doitBean.setCol1("106");
		doitBean.setCol2("두번째열66666666");
		doitBean.setCol4("666666666");
		
		//doit2Update.update(doitBean);
	}
	
	public void update(Connection conn, DoitBean updBean) throws Exception {
		//insert, update, delete
		PreparedStatement pstmt = null;
		
		//3.쿼리준비
		String sql = "UPDATE doit2 SET col2 = ?, col4 = ? WHERE col1=?";
		pstmt = conn.prepareStatement(sql);
		
		//4.데이터 binding
		pstmt.setString(1, updBean.getCol2() );
		pstmt.setString(2, updBean.getCol4());
		pstmt.setString(3, updBean.getCol1());
		
		//5.쿼리실행 
		int cnt = pstmt.executeUpdate();
		//insert 된 row 수
		if(cnt == 0) {
			System.out.println("데이터 업데이트 실패");
			throw new Exception("데이터 Update 실패");
		} else {
			System.out.println("데이터 업데이트 성공");
		}
			
	}
	
}
