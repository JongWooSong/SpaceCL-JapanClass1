package board.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import board.db.BoardBean;
import board.db.BoardCRUD;
import board.db.MemberBean;

public class BoardDetail extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane = new JPanel();
	private JTextField txtTitle;
	private JTextArea txtContent;
	private MemberBean mMemberBean;
	private BoardBean mBoardBean;
	private BoardCRUD mBoardCURD = new BoardCRUD();
	private MainBoard2 mMainBoard2;
	
	/**
	 * Create the dialog.
	 */
	public BoardDetail(MemberBean memBean, BoardBean boardBean, MainBoard2 mainBoard2) {
		mMemberBean = memBean;
		mBoardBean = boardBean;
		mMainBoard2 = mainBoard2;
		
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
		
		txtContent = new JTextArea();
		panel_2.add(txtContent);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnUpdate = new JButton("수정");
			buttonPane.add(btnUpdate);
			{
				JButton btnDel = new JButton("삭제");
				btnDel.setActionCommand("OK");
				buttonPane.add(btnDel);
				getRootPane().setDefaultButton(btnDel);
				
				//수정버튼 클릭
				btnUpdate.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BoardBean boardBean = new BoardBean();
						boardBean.setTitle( txtTitle.getText() );
						boardBean.setContents( txtContent.getText()  );
						boardBean.setMemberNo( mMemberBean.getMemberNo() );
						boardBean.setBoardNo( mBoardBean.getBoardNo() );
						
						int cnt = mBoardCURD.updateBoard(boardBean);
						if( cnt > 0 ) {
							//수정성공
							JOptionPane.showMessageDialog(null, "수정에 성공 하였습니다.");
							BoardDetail.this.dispose();
							//리스트 새롭게 조회
							mainBoard2.showTable( mainBoard2.mCurPageNo );
						}
					}
				});
				
				//삭제버튼 클릭
				btnDel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						int res = JOptionPane.showConfirmDialog(null, 
								"삭제 하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
						if( res == JOptionPane.YES_OPTION ) 
						{
							//실행로직
							int cnt = mBoardCURD.delBoard( mBoardBean.getBoardNo() );
							if( cnt > 0 ) {
								//삭제완료
								JOptionPane.showMessageDialog(null, "삭제에 성공 하였습니다.");
								BoardDetail.this.dispose();
								//리스트 새롭게 조회
								mainBoard2.showTable( mainBoard2.mCurPageNo );
							} else {
								JOptionPane.showMessageDialog(null, "삭제에 실패 하였습니다.");
							}
						}//end if
					}
				});
				
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		
		//표시
		txtTitle.setText( mBoardBean.getTitle() );
		txtContent.setText( mBoardBean.getContents() );
		
	}; //end 생성자
	
}
