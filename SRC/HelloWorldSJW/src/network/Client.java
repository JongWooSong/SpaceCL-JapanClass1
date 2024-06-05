package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		String msg = "안녕하세요? 저는 클라이언트에요.";
		
		//포트번호 2012 번으로 서버에 연결 시도
		try {
			Socket sock = new Socket("127.0.0.1", 2012);
			System.out.println("2012 포트로 서버 접속에 성공 하였습니다.");
			
			System.out.println("클라이언트가 서버로 메시지를 송신 합니다.");
			PrintWriter pw = new PrintWriter( sock.getOutputStream() );
			pw.println( msg );
			
			//클라이언트가 서버의 메시지를 받는다.
			BufferedReader br = new BufferedReader( new InputStreamReader( sock.getInputStream() ) );
			String serverMsg = br.readLine();
			System.out.println("서버로부터 수신내용: " + serverMsg);
			
			br.close();
			pw.close();
			sock.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}//end main

}
