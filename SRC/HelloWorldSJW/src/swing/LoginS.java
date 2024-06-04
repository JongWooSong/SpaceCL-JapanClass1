package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginS extends JFrame {

	public LoginS() {
		setSize(200, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("채팅창");
		
		//레이아웃 셋팅
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JTextArea jta = new JTextArea();
		jta.setEditable(false);
		
		Panel p1 = new Panel();
		p1.setPreferredSize(new Dimension(800, 40));
		p1.setLayout(new BorderLayout());
		
		JTextField jt = new JTextField();
		JButton btnSend = new JButton("전송");
		
		//패널에 추가
		p1.add(jt, BorderLayout.CENTER);
		p1.add(btnSend, BorderLayout.EAST);
		
		//컨테이너 센터에 추가
		c.add(jta, BorderLayout.CENTER);
		c.add(p1, BorderLayout.SOUTH);
		
	}
	
	
}
