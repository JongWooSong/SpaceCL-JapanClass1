package board.ui;

import java.awt.BorderLayout;
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

public class BoardWriteModal extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane = new JPanel();
	private JTextField txtTitle;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BoardWriteModal dialog = new BoardWriteModal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BoardWriteModal() {
		setBounds(100, 100, 649, 636);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		Label lblTitle = new Label("제목:  ");
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
