package swing.swinggui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doit2Select {

	public DoitBean select(Connection conn) {

		//select
		Statement stmt = null;
		DoitBean doitBean = new DoitBean();
		
		try {
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
			
			//TODO 마지막 last_inserted_id() 를 통해 조회된 값을 
			//TODO doitBean 으로 반환하는 코드를 작성하시오.
			//TODO 돌발퀴즈!
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return doitBean;
	}

}
