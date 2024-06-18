package swing.swinggui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TotalQueryExe {

	public static void main(String[] args) {

		Doit2Insert dIns = new Doit2Insert();
		Doit2Select dSelect = new Doit2Select();
		Doit2Update dUpdate = new Doit2Update();
		Doit2Delete dDel = new Doit2Delete();
		
		DoitBean doitBean = new DoitBean();
		doitBean.setCol2("세번째");
		doitBean.setCol4("3333333");
		doitBean.setCol5("44444444");
		doitBean.setCol6("5555");
		doitBean.setCol7("66666666");
		
		Connection conn = null;
		
		try {
			//1.드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver"); //JDBC Mysql Driver (pom.xml)
			
			//2.연결하기
			String url = "jdbc:mysql://localhost/studydb1";
			conn = DriverManager.getConnection(url, "spacecl", "1234"); //id, pw로 디비연결
			System.out.println("디비 연결 성공!!!");
			
			conn.setAutoCommit(false);
			
			//insert 실행 
			String lastInsertId = dIns.insert(conn, doitBean);
			
			//select 실행 
			DoitBean selBean = dSelect.select(conn, lastInsertId);
			System.out.println("totalQueryExe - selectBean :: " + selBean.getCol1() + ", " + selBean.getCol2() );
			
			//update 실행
			doitBean.setCol1(lastInsertId);
			doitBean.setCol2("세번째-업데이트됨!!!" + lastInsertId);
			doitBean.setCol4("333333377773333");
			dUpdate.update(conn, doitBean);
			
			//select 실행 
			dSelect.select(conn, null);
		
			//delete 실행
			doitBean.setCol1(lastInsertId);
			dDel.delete(conn, doitBean);
			
			//select 실행 
			dSelect.select(conn, null);
			
			conn.commit();
			System.out.println("커밋 됨");
		} catch(Exception e) {
			e.printStackTrace();
			
			if(conn != null) {
				try {
					conn.rollback();
					System.out.println("롤백 됨");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	

}
