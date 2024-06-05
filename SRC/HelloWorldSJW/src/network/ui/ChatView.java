package network.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatView extends JFrame {

	private String mIp;
	private String mNickName;
	private JTextArea mJta;
	
	public ChatView(String ip, String nickName) {
		mIp = ip;
		mNickName = nickName;
		
		setSize(200, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("채팅창");
		
		//레이아웃 셋팅
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		mJta = new JTextArea();
		mJta.setEditable(false);
		
		Panel p1 = new Panel();
		p1.setPreferredSize(new Dimension(800, 40));
		p1.setLayout(new BorderLayout());
		
		JTextField jt = new JTextField();
		JButton btnSend = new JButton("전송");
		
		//패널에 추가
		p1.add(jt, BorderLayout.CENTER);
		p1.add(btnSend, BorderLayout.EAST);
		
		//컨테이너 센터에 추가
		c.add(mJta, BorderLayout.CENTER);
		c.add(p1, BorderLayout.SOUTH);
		
		//전송버튼 클릭 이벤트
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendKey(mJta, jt);
			}
		});
		
		//입력필드 키 이벤트
		jt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					sendKey(mJta, jt);
				}
			}
		});
		
	}//end Constructor
	
	public void sendKey(JTextArea jta, JTextField jt) {
		jta.setText(  jta.getText() + jt.getText() + "\n" );
		jt.setText("");
		jt.requestFocus();
	}
	
	
}//end class
