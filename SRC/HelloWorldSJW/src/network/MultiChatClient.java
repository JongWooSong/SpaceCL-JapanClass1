package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import network.ui.ChatView;

public class MultiChatClient {

	private String name;
	private Socket socket;
	private String serverIP = "192.168.0.49";
	private int serverPort = 7777;
	private ChatView mChatView;
	
	public MultiChatClient(ChatView chatView, String name) {
		mChatView = chatView;
		this.name = name;
	}
	
	
	public void start() {
		try {
			socket = new Socket(serverIP, serverPort);
			mChatView.addViewMsg( "서버와의 연결이 되었습니다. 대화명은 " + name + " 입니다." );
			
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			clientReceiver.start();
			//ClientSender clientSender = new ClientSender(socket);
			//clientSender.start();
			
			//추가: 닉네임을 처음에 서버로 날려준다.
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(name);
			//System.out.println("대화방에 입장 하였습니다.");
			mChatView.addViewMsg("대화방에 입장 하였습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public void sendMsg(String msg) {
		new ClientSenderUI(socket, msg).start();
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
					//System.out.println( input.readUTF() );
					mChatView.addViewMsg( input.readUTF() );
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
				//System.out.println("대화방에 입장 하였습니다.");
				mChatView.addViewMsg("대화방에 입장 하였습니다.");
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
	
	
	class ClientSenderUI extends Thread {
		Socket socket;
		String msg;
		
		public ClientSenderUI(Socket socket, String msg) {
			this.socket = socket;
			this.msg = msg;
		}
		
		@Override
		public void run() {
			//서버로 메시지를 전송한다.
			try {
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				output.writeUTF("[" + name + "]=> " + this.msg);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	
};
