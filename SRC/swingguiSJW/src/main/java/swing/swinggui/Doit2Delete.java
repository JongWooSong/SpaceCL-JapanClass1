package swing.swinggui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Doit2Delete {

	public static void main(String[] args) {
		Doit2Delete doit2Update = new Doit2Delete();
		
		DoitBean doitBean = new DoitBean();
		doitBean.setCol1("102");
		
		//doit2Update.delete(doitBean);
	}
	
	public void delete(Connection conn, DoitBean updBean) throws Exception {
		
		//insert, update, delete
		PreparedStatement pstmt = null;

		//3.쿼리준비
		String sql = "DELETE FROM doit2 WHERE col1=?";
		pstmt = conn.prepareStatement(sql);
		
		//4.데이터 binding
		pstmt.setString(1, updBean.getCol1() );
		
		//5.쿼리실행 
		int cnt = pstmt.executeUpdate();
		//insert 된 row 수
		if(cnt == 0) {
			System.out.println("데이터 삭제 실패");
			throw new Exception("데이터 delete 실패");
		} else {
			System.out.println("데이터 삭제 성공");
		}
			
	}
	
}
