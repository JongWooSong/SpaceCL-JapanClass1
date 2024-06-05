package network;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;

public class MultiChatServer {

	private HashMap<String, DataOutputStream> clients;
	private ServerSocket serverSocket;
	
	//생성자
	public MultiChatServer() {
		clients = new HashMap<String, DataOutputStream>();
		
		//여러 쓰레드에서 접근할 것이므로 동기화 시킨다.
		Collections.synchronizedMap(clients);
	}
	
	public void start() {
		
		try {
			//서버 소켓 생성
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작 되었습니다.");
			
			//무한 루프 돌면서 클라이언트와 연결되면 소켓을 생성하여 스레드로 돌린다.
			while(true) {
				Socket socket = serverSocket.accept();
				//쓰레드 시작
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}//end start()
	
	public static void main(String[] args) {
		new MultiChatServer().start(); //서버 시작
	}
	
	
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream input;
		DataOutputStream output;
		
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
		
			String name = "";
			
			try {
				name = input.readUTF();
				System.out.println(name + "님이 접속 하셨습니다.");
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}//end run()
	};
	
	
};//end class 






