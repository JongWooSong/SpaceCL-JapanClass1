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
			dIns.insert(conn, doitBean);
			
			//select 실행 
			dSelect.select(conn);
			
			//update 실행
			doitBean.setCol1("107");
			doitBean.setCol2("세번째-업데이트됨!!!");
			doitBean.setCol4("333333377773333");
			dUpdate.update(conn, doitBean);
			
			//select 실행 
			dSelect.select(conn);
		
			//delete 실행
			doitBean.setCol1("10000");
			dDel.delete(conn, doitBean);
			
			//select 실행 
			dSelect.select(conn);
			
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
