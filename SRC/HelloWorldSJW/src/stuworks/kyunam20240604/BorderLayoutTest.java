package stuworks.kyunam20240604;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Swing - 로그인 화면 구성
 * 
 * ID 텍스트박스
 * PW 텍스트박스
 * 	로그인 버튼
 * 
 * quiz 
 * id & pw value를 받아 
 * 조건 if id == abcd and pw ==  1234 
 * 결과 true : showMessage "로그인 되었습니다."
 *      false : show message "없는 아이디이거나 틀린 비밀번호를 입력하셨습니다."
 */
public class BorderLayoutTest extends JFrame {

	public static void main(String[] args) {

		// init instance
		BorderLayoutTest layout = new BorderLayoutTest();
		JButton loginBtn = new JButton("Login");
		Panel panel = new Panel();
		Label idLabel = new Label("ID");
		Label pwLabel = new Label("PW");
		TextField idTxt = new TextField();
		TextField pwTxt = new TextField();
		
		// basic setting
		layout.setSize(300, 150);
		layout.setDefaultCloseOperation(EXIT_ON_CLOSE);
		layout.setTitle("Border Layout");

		panel.setLayout(new GridLayout(2,2));
		
		// detail setting
		Container con = layout.getContentPane();
		con.setLayout(new BorderLayout(30, 20));

		// add button in container
		con.add(loginBtn, BorderLayout.SOUTH );
		
		// add panel in center layout
		con.add(panel, BorderLayout.CENTER );

		// label detail setting
		idLabel.setAlignment(Label.CENTER);
		pwLabel.setAlignment(Label.CENTER);
		
		// add label and txtField in panel 
		panel.add(idLabel);		panel.add(idTxt);
		panel.add(pwLabel);		panel.add(pwTxt);
		
		// show layout
		layout.setVisible(true);
		
		
		// Login event 
		ActionListener loginAct = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// check id and pw value
				System.out.println("id : " + idTxt.getText());
				System.out.println("pw : " + pwTxt.getText());
				
				if(idTxt.getText().equals("abcd")) {
					
					if(pwTxt.getText().equals("0987!")) {
						JOptionPane.showMessageDialog(null, "Login Successed!");
					} // end if
					
					else {
						JOptionPane.showMessageDialog(null, "Wrong ID or Password");
					} // end else
						
				} // end if
				
				else {
					JOptionPane.showMessageDialog(null, "Wrong ID or Password");
				}// end else
				
			}// end method
			
		};
		
		loginBtn.addActionListener(loginAct);
		
	}// end main

}// end class
