package stuworks.smj20240603;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Swing2 extends JFrame {

	public static void main(String[] args) {
		Swing2 s1 = new Swing2();

		s1.setBounds(500, 50, 400, 400);
		s1.setTitle("GridLayout");
		s1.setResizable(false);
		s1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container contentPane = s1.getContentPane();
		contentPane.setBackground(Color.LIGHT_GRAY);

		GridLayout gl = new GridLayout(5, 2);
		contentPane.setLayout(gl);

		JLabel lb1 = new JLabel("이름");
		JTextField tf1 = new JTextField(100);
		contentPane.add(lb1);
		contentPane.add(tf1);

		JLabel lb2 = new JLabel("학번");
		JTextField tf2 = new JTextField(100);
		contentPane.add(lb2);
		contentPane.add(tf2);

		JLabel lb3 = new JLabel("학과");
		JTextField tf3 = new JTextField(100);
		contentPane.add(lb3);
		contentPane.add(tf3);

		JLabel lb4 = new JLabel("과목");
		JTextField tf4 = new JTextField(100);
		contentPane.add(lb4);
		contentPane.add(tf4);

		JLabel lb5 = new JLabel("");
		JButton btn1 = new JButton("확인");
		contentPane.add(lb5);
		contentPane.add(btn1);

		ActionListener btnAct = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("이름 : " + tf1.getText());
				System.out.println("학번 : " + tf2.getText());
				System.out.println("학과 : " + tf3.getText());
				System.out.println("과목 : " + tf4.getText());

			}
		};

		btn1.addActionListener(btnAct);

		
		s1.setVisible(true);
	}

}
