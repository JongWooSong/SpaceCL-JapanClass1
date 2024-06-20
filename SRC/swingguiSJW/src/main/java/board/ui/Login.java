package board.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import board.db.MemberCRUD;

public class Login extends JFrame {

	public static void main(String[] args) {
		
		new Login();
	}
	
	//Input(ID)
	private TextField mTxtId;
	//Input(PW)
	private	JPasswordField mTxtPw;
	//DB 조회 객체
	private MemberCRUD mMemCRUD = new MemberCRUD();
	
	
	//생성자
	public Login() {
		
		setSize(180, 100);
		
		//종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		//center
		Panel centerP = new Panel();
		centerP.setLayout(new GridLayout(2,2));
		
		//Label(ID)
		Label lblId = new Label("ID: ");
		//Label(PW)
		Label lblPw = new Label("PW: ");
		//Input(ID)
		mTxtId = new TextField();
		//Input(PW)
		mTxtPw = new JPasswordField();
		
		//패널에 추가
		centerP.add(lblId);
		centerP.add(mTxtId);
		centerP.add(lblPw);
		centerP.add(mTxtPw);
		
		//south
		Button btnLogin = new Button("OK");
		btnLogin.addActionListener(mBtnLogin);
		
		//레이아웃 배치
		container.add(centerP, BorderLayout.CENTER);
		container.add(btnLogin, BorderLayout.SOUTH);
		
		setVisible(true);
		
	};//end 생성자
	
	
	private ActionListener mBtnLogin = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			//JOptionPane.showMessageDialog(null, "로그인 버튼 클릭");
			
			String id = mTxtId.getText();
			String pw = new String(mTxtPw.getPassword());
			
			//DB에서 확인작업
			boolean isFind = mMemCRUD.getFindMember(id, pw);
			if(isFind) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
			
		}
	};
	
	
	
	
	
}
