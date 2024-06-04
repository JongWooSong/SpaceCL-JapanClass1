package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class BorderLayoutTest extends JFrame {

	/**
	 * 로그인 성공여부를 체크한다.
	 * @param tfId
	 * @param tfPw
	 * @return true:로그인 성공, false:로그인 실패
	 */
	public boolean isLoginCheck(JTextField tfId, JPasswordField tfPw) {
		if( "".equals(tfId.getText())  ) {
			JOptionPane.showMessageDialog(null, "ID를 입력하세요");
			tfId.requestFocus();
			return false;
		}
		else if( "".equals(new String(tfPw.getPassword()))  ) {
			JOptionPane.showMessageDialog(null, "PW를 입력하세요");
			tfPw.requestFocus();
			return false;
		}
		else if( "abcd".equals(tfId.getText()) && "0987!".equals(tfPw.getText()) ) {
			JOptionPane.showMessageDialog(null, "로그인 성공!!");
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "로그인 실패!!");
			tfPw.requestFocus();
			return false;
		}
	}
	
	
	
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
		
		JTextField tfId = new JTextField();
		JPasswordField tfPw = new JPasswordField(3);

		p1.add(lb1);
		p1.add(tfId);
		
		p1.add(lb2);
		p1.add(tfPw);
		
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				bl.isLoginCheck(tfId, tfPw);
				
			}
		});
		
		//키보드 엔터시
		tfPw.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if( e.getKeyChar() == KeyEvent.VK_ENTER ) {
					System.out.println("엔터");
					bl.isLoginCheck(tfId, tfPw);
				}
				
			}
		});
		
		
		
		bl.setVisible(true);
	}//end main()
	
	
	
	
	
	
	
	
	
	
	

}
