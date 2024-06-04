package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class BorderLayoutTest extends JFrame {

	
	public static void main(String[] args) {
			
		BorderLayoutTest bl = new BorderLayoutTest();
		
		//기본셋팅
		bl.setSize(200, 130);
		bl.setDefaultCloseOperation(EXIT_ON_CLOSE);
		bl.setTitle("보더 레이아웃");
		
		//레이아웃 셋팅
		Container c = bl.getContentPane();
		c.setLayout( new BorderLayout(30, 20) );
		
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 2));
		
		JButton btn5 = new JButton("로그인");
		
		c.add( p1, BorderLayout.CENTER );
		c.add( btn5, BorderLayout.SOUTH );
		
		Label lb1 = new Label("ID: ");
		lb1.setAlignment(Label.CENTER);
		Label lb2 = new Label("PW: ");
		lb2.setAlignment(Label.CENTER);
		
		TextField tfId = new TextField();
		JPasswordField tfPw = new JPasswordField(3);

		p1.add(lb1);
		p1.add(tfId);
		
		p1.add(lb2);
		p1.add(tfPw);
		
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if( "".equals(tfId.getText())  ) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요");
					tfId.requestFocus();
				}
				else if( "".equals(new String(tfPw.getPassword()))  ) {
					JOptionPane.showMessageDialog(null, "PW를 입력하세요");
					tfPw.requestFocus();
				}
				else if( "abcd".equals(tfId.getText()) && "0987!".equals(tfPw.getText()) ) {
					JOptionPane.showMessageDialog(null, "로그인 성공!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "로그인 실패!!");
					tfPw.requestFocus();
				}
				
			}
		});
		
		
		
		bl.setVisible(true);
	}

}
