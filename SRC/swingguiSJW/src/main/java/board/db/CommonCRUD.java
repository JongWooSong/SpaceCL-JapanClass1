package board.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class CommonCRUD {
	
	//상수
	public static final String DB_NAME = "board";
	//변수
	private Connection mConnection;
	
	
	public Connection getConnection() {
		try {
			if(mConnection == null) {
				//1.드라이버 로딩
				Class.forName("com.mysql.cj.jdbc.Driver"); //JDBC Mysql Driver (pom.xml)
				
				//2.연결하기
				String url = "jdbc:mysql://localhost/" + DB_NAME;
				mConnection = DriverManager.getConnection(url, "spacecl", "1234"); //id, pw로 디비연결
			}
			System.out.println("디비 연결 성공!!!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return mConnection;
	}
	
}
