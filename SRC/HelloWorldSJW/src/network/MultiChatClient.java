package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiChatClient {

	private String name;
	private Socket socket;
	private String serverIP = "192.168.0.49";
	private int serverPort = 7777;
	
	public void start() {
		try {
			socket = new Socket(serverIP, serverPort);
			System.out.println("서버와의 연결이 되었습니다. 대화명을 입력하세요:");
			name = new Scanner(System.in).nextLine();
			
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			ClientSender clientSender = new ClientSender(socket);
			
			clientReceiver.start();
			clientSender.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MultiChatClient().start();
	}
	
	
	class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream input;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				input = new DataInputStream(socket.getInputStream());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while( input != null ) {
				try {
					System.out.println( input.readUTF() );
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	};//end class
	
	
	class ClientSender extends Thread {
		Socket socket;
		DataOutputStream output;
		
		public ClientSender(Socket socket) {
			this.socket = socket;
			try {
				output = new DataOutputStream(socket.getOutputStream());
				output.writeUTF(name);
				System.out.println("대화방에 입장 하였습니다.");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			String msg = "";
			while( output != null ) {
				try {
					msg = sc.nextLine();
					if("exit".equals(msg)) {
						System.exit(0); //프로그램 종료
					}
					output.writeUTF("[" + name + "] " + msg);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}//end run()
		
	};//end class
	
	
	
	
};
