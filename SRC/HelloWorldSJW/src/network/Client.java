package network;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class Client {

	public static void main(String[] args) {

		String msg = "안녕하세요? 저는 클라이언트에요.";
		
		//포트번호 2012 번으로 서버에 연결 시도
		try {
			Socket sock = new Socket("127.0.0.1", 3285);
			System.out.println( new Date() + " ==> " + "2012 포트로 서버 접속에 성공 하였습니다.");
			
			Thread.sleep(1000);
			System.out.println( new Date() + " ==> " + "클라이언트가 서버로 메시지를 송신 합니다.");
			BufferedOutputStream bw = new BufferedOutputStream( sock.getOutputStream() );
			bw.write( msg.getBytes() );
			bw.flush();//즉시전송 
			
			//클라이언트가 서버의 메시지를 받는다.
//			BufferedReader br = new BufferedReader( new InputStreamReader( sock.getInputStream() ) );
//			String serverMsg = br.readLine();
//			System.out.println("서버로부터 수신내용: " + serverMsg);
			
//			br.close();
			bw.close();
			sock.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}//end main

}
