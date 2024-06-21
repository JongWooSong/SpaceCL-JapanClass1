package board.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import board.db.MemberBean;

public class BoardWriteModal extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane = new JPanel();
	private JTextField txtTitle;
	private MemberBean mMemberBean;

	/**
	 * Create the dialog.
	 */
	public BoardWriteModal(MemberBean memBean) {
		mMemberBean = memBean;
		
		setBounds(100, 100, 649, 636);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		Label lblTitle = new Label("Title:");
		lblTitle.setPreferredSize(new Dimension(50, 50));
		panel.add(lblTitle, BorderLayout.WEST);
		
		txtTitle = new JTextField();
		panel.add(txtTitle, BorderLayout.CENTER);
		txtTitle.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("본문내용:");
		panel_2.add(lblNewLabel);
		
		JTextArea txtContent = new JTextArea();
		panel_2.add(txtContent);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

}
