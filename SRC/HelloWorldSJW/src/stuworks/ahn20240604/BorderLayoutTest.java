package stuworks.ahn20240604;

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
 * @since 2024-06-04
 * @author ahn
 * 
 * BorderLayout
 */
public class BorderLayoutTest extends JFrame{
	public static void main(String[] args) {
		BorderLayoutTest bl = new BorderLayoutTest();
		
		// 기본세팅
		bl.setSize(200, 130); // 화면 크기
		bl.setDefaultCloseOperation(EXIT_ON_CLOSE); // 엑스
		bl.setTitle("BorderLayout"); // 제목
		
		// 레이아웃 셋팅
		Container c = bl.getContentPane();
		c.setLayout(new BorderLayout(30, 20)); //int hgap, int vgap
		
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 2));
		
		JButton btn5 = new JButton("확인");

		c.add(p1, BorderLayout.CENTER);
		c.add(btn5, BorderLayout.SOUTH);
		
		Label lb1 = new Label("ID: ");
		lb1.setAlignment(Label.CENTER);
		Label lb2 = new Label("PW: ");
		lb2.setAlignment(Label.CENTER);
		TextField tfId = new TextField();
		TextField tfPw = new TextField();
		
		p1.add(lb1, 0);
		p1.add(tfId);
		
		p1.add(lb2);
		p1.add(tfPw);
		
		ActionListener btnAct = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tfId.getText().equals("abcd") && tfPw.getText().equals("0987!")) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					bl.setVisible(false);
				}else if(tfId.getText().equals("abcd")){
					JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다.");
				}else {
					JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
				}
				
			}
		};
		
		btn5.addActionListener(btnAct);
		
		bl.setVisible(true);
	}
	
}
