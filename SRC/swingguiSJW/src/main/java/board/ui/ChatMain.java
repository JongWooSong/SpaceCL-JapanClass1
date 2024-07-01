package board.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import board.db.MemberBean;

public class ChatMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMsg;
	private JTextArea jtaChatMsgs;
	private JScrollPane scrollPane;
	private MemberBean mMemBean;
	//채팅관련 상수 추가 
	private final String SERVER_IP = "192.168.0.49";
	private final int SERVER_PORT = 7777;
	//채팅 클라이언트 소켓
	private Socket mSocket;
	
	/**
	 * Create the frame.
	 */
	public ChatMain(MemberBean memberBean) {
		mMemBean = memberBean;
		
		setBounds(100, 100, 597, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//채팅메시지 출력창
		jtaChatMsgs = new JTextArea();
		jtaChatMsgs.setEditable(false);
		
		scrollPane = new JScrollPane(jtaChatMsgs);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtMsg = new JTextField();
		panel.add(txtMsg, BorderLayout.CENTER);
		txtMsg.setColumns(10);
		
		JButton btnSend = new JButton("전송");
		panel.add(btnSend, BorderLayout.EAST);
		
		btnSend.addActionListener(mSendClick);
		
		//채팅 초기화 작업 
		initChatSetup();
		
	};//end 생성자
	
	//버튼 이벤트
	private ActionListener mSendClick = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new SenderChat(mSocket, txtMsg.getText()).start();
			txtMsg.setText(""); //메시지 전송후 메시지란 초기화
			txtMsg.requestFocus();
			
		}
	};

	private void initChatSetup() {
		try {
			//서버와 연결한다.
			mSocket = new Socket(SERVER_IP, SERVER_PORT);
			jtaChatMsgs.append("서버와의 연결이 되었습니다.\n");
			jtaChatMsgs.append("대화명은 " + mMemBean.getName() + " 입니다.\n");
			
			//수신 채팅 쓰레드 생성 및 시작
			ClientReceiver clientReceiver = new ClientReceiver(mSocket);
			clientReceiver.start();
			
			//추가: 닉네임을 처음에 서버로 날려준다.
			DataOutputStream output = new DataOutputStream(mSocket.getOutputStream());
			output.writeUTF( mMemBean.getName() );
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	/**
	 * 서버로 부터 메시지를 수신받을때마다 스레드로 생성되어 화면에 표시해주는 클래스
	 */
	class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream input;
		
		//생성자
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
			//쓰레드 구현부 
			while( input != null ) {
				try {
					//메시지를 출력한다.
					jtaChatMsgs.append( input.readUTF() + "\n" );
					//JScrollPane의 바를 최 하단으로 맞춤
					scrollPane.getVerticalScrollBar().setValue(
							scrollPane.getVerticalScrollBar().getMaximum()
						);
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}//end run()
		
	};//end class
	
	
	/**
	 * 채팅시의 채팅 내용을 서버로 전송하는 쓰레드 클래스
	 */
	class SenderChat extends Thread {
		Socket socket;
		String msg;
		
		public SenderChat(Socket socket, String msg) {
			this.socket = socket;
			this.msg = msg;
		}
		
		@Override
		public void run() {
			//서버로 메시지를 전송하는 부분
			try {
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				output.writeUTF( "[" + mMemBean.getName() + "]=> " + this.msg );
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	};
	
	
}
