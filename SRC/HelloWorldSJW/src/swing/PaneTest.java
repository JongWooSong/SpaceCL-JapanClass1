package swing;

import javax.swing.JOptionPane;

public class PaneTest {

	public static void main(String[] args) {

		//JOptionPane.showConfirmDialog(null, "패스워드가 틀렸습니다.");
		String age = JOptionPane.showInputDialog("당신의 나이는 몇살 입니까?");
		
		JOptionPane.showMessageDialog(null, "당신의 나이는" + age);
	}

}
