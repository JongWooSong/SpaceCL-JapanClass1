package swing.swinggui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doit2Jdbc {

	public static void main(String[] args) {

		Connection conn = null;
		//select
		Statement stmt = null;
		
		try {
			//1.드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); //JDBC Mysql Driver (pom.xml)
			
			//2.연결하기
			String url = "jdbc:mysql://localhost/studydb1";
			conn = DriverManager.getConnection(url, "spacecl", "1234"); //id, pw로 디비연결
			System.out.println("디비 연결 성공!!!");
			
			//3.쿼리 수행을 위한 Statment 객체 생성
			stmt = conn.createStatement();
			
			//4.쿼리 작성
			String sql = "select col1, col2, col3 from doit2";
			
			//5.쿼리수행
			ResultSet rs = stmt.executeQuery(sql);
			
			//6.쿼리 실행결과 출력하기
			while(rs.next()) { //가져온 row 갯수만큼 돈다.
				//레코드의 컬럼은 배열과 달리 1부터 시작한다.
				String col1 = rs.getString("col1");
				String col2 = rs.getString("col2");
				String col3 = rs.getString("col3");
				
				System.out.println(
					col1 + ", " + col2 + ", " + col3
				);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
