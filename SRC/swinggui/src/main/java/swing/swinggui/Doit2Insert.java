package swing.swinggui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Doit2Insert {

	
	public void insert(DoitBean insBean) {
		
		Connection conn = null;
		//insert, update, delete
		PreparedStatement pstmt = null;
		
		try { 
			//1.드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); //JDBC Mysql Driver (pom.xml)
			
			//2.연결하기
			String url = "jdbc:mysql://localhost/studydb1";
			conn = DriverManager.getConnection(url, "spacecl", "1234"); //id, pw로 디비연결
			System.out.println("디비 연결 성공!!!");
			
			//3.쿼리준비
			String sql = "INSERT INTO (col2, col4, col5, col6, col7) doit2 VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//4.데이터 binding
			pstmt.setString(1, "두번째열");
			pstmt.setString(2, "444");
			pstmt.setString(3, "555");
			pstmt.setString(4, "666");
			pstmt.setString(5, "777");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
