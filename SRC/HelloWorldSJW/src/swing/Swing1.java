package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Swing1 extends JFrame {

	public static void main(String[] args) {
		Swing1 s1 = new Swing1();
		s1.setVisible(true);
		
		s1.setSize(400, 400);
		s1.setTitle("안녕? SWing 프로그래밍");
		s1.setDefaultCloseOperation(EXIT_ON_CLOSE); //X 버튼 클릭시 완전종료
		s1.setResizable(false);
		
		Container contentPane = s1.getContentPane();
		contentPane.setBackground(Color.ORANGE);
		GridLayout fl1 = new GridLayout(4,3);
		contentPane.setLayout(fl1);
		
		JButton btn1 = new JButton("OK1");
		JButton btn2 = new JButton("Cancel");
		JButton btn3 = new JButton("이그노어");
		
		contentPane.add(btn1);
		contentPane.add(btn2);
		contentPane.add(btn3);
		
		//익명클래스의 인스턴스 변수화
		ActionListener btnAct = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( e.getActionCommand() + ", " + e.getID() );
			}
		};
		
		btn1.addActionListener(btnAct);
		btn2.addActionListener(btnAct);
		btn3.addActionListener(btnAct);
		
		
		
	}
	
}
