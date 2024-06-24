package board.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import board.db.BoardBean;
import board.db.BoardCRUD;
import board.db.MemberBean;

public class MainBoard2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblPage1;
	private JLabel lblPage2;
	private JLabel lblPage3;
	private JLabel lblPage4;
	private JLabel lblPage5;
	private JLabel lblPage6;
	private JLabel lblPage7;
	private JLabel lblPage8;
	private JLabel lblPage9;
	private JLabel lblPage10;
	private JButton brnWrite;

	private MemberBean mMemBean;
	
	private BoardWriteModal dialog;
	private JPanel pnlTable;
	private JTable boardTable;
	private BoardCRUD mBoardCRUD = new BoardCRUD();
	
	
	/**
	 * Create the frame.
	 */
	public MainBoard2(MemberBean memberBean) {
		mMemBean = memberBean;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtSearch = new JTextField();
		panel.add(txtSearch);
		txtSearch.setColumns(30);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnSearch);
		
		brnWrite = new JButton("글쓰기");
		panel.add(brnWrite);
		
		brnWrite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dialog == null) {
					dialog = new BoardWriteModal(mMemBean, MainBoard2.this);
				}
				if( !dialog.isVisible() ) {
					dialog.setModal(true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.clearInputs();
					dialog.setVisible(true);
				}  else {
					dialog.clearInputs();
					dialog.setVisible(true);
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton_1 = new JButton("이전");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_1);
		
		lblPage1 = new JLabel("1");
		panel_1.add(lblPage1);
		
		lblPage2 = new JLabel("2");
		panel_1.add(lblPage2);
		
		lblPage3 = new JLabel("3");
		panel_1.add(lblPage3);
		
		lblPage4 = new JLabel("4");
		panel_1.add(lblPage4);
		
		lblPage5 = new JLabel("5");
		panel_1.add(lblPage5);
		
		lblPage6 = new JLabel("[6]");
		panel_1.add(lblPage6);
		
		lblPage7 = new JLabel("7");
		panel_1.add(lblPage7);
		
		lblPage8 = new JLabel("8");
		panel_1.add(lblPage8);
		
		lblPage9 = new JLabel("9");
		panel_1.add(lblPage9);
		
		lblPage10 = new JLabel("10");
		panel_1.add(lblPage10);
		
		
		btnNewButton = new JButton("다음");
		panel_1.add(btnNewButton);
		
		pnlTable = new JPanel();
		contentPane.add(pnlTable, BorderLayout.CENTER);
		pnlTable.setLayout(new BorderLayout(0, 0));
		
		//리스트를 읽어온다.
		showTable( mBoardCRUD.getBoardList(0) );
	
	};//end 생성자

	//리스트 출력
	public void showTable(List<BoardBean> boardList) {
		
		//TODO 출력 
		String header[] = {"게시글 번호", "타이틀", "작성자", "조회수", "작성일" };
		String contents[][] = {};
		
		DefaultTableModel tableModel = new DefaultTableModel(contents, header);
		
		if(boardList != null) {
			for(int i=0; i<boardList.size(); i++) {
				BoardBean bean = boardList.get(i);
				
				Vector<String> vector = new Vector<String>();
				vector.add( bean.getBoardNo() );
				vector.add( bean.getTitle() );
				vector.add( bean.getMemberName() );
				vector.add( bean.getCount() );
				vector.add( bean.getRegDt() );
				
				tableModel.addRow(vector);
			}//end for
		}
		
		boardTable = new JTable(tableModel) {
			//셀 편집을 못하도록 막는다.
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//셀 값 가운데 정렬
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		boardTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		boardTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		boardTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		boardTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		boardTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		//컬럼크기
		TableColumnModel colModel = boardTable.getColumnModel();
		colModel.getColumn(0).setPreferredWidth(15);
		colModel.getColumn(1).setPreferredWidth(280);
		colModel.getColumn(2).setPreferredWidth(30);
		colModel.getColumn(3).setPreferredWidth(10);
		
		//스크롤 추가 
		JScrollPane scrollTable = new JScrollPane(boardTable);
		scrollTable.setLocation(0, 0);
		scrollTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//전체 가로, 세로 크기 
		scrollTable.setSize(pnlTable.getWidth(), pnlTable.getHeight());
		
		//add component
		pnlTable.add(scrollTable, BorderLayout.CENTER);
		
	}//end method
	
	public static void main(String[] args) {
		//TODO for test
		MemberBean mBean = new MemberBean();
		MainBoard2 board = new MainBoard2(mBean);
		board.setVisible(true);
		
		BoardCRUD boardCRUD = new BoardCRUD();
		board.showTable( boardCRUD.getBoardList(0) );
	}
	
	
	
}
