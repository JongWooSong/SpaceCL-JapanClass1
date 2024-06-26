package board.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JButton btnPageNext;
	private JButton btnPagePrev;
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
	private JPanel pnlDispPage;
	
	//현재 페이지 번호를 저장하고 변수
	public int mCurPageNo = 1; 
	//전체페이지 수
	public int mTotPageCnt;
	
	
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
		
		JPanel pnlPaging = new JPanel();
		contentPane.add(pnlPaging, BorderLayout.SOUTH);
		
		btnPagePrev = new JButton("이전");
		btnPagePrev.setHorizontalAlignment(SwingConstants.LEFT);
		pnlPaging.setLayout(new BorderLayout(0, 0));
		pnlPaging.add(btnPagePrev, BorderLayout.WEST);
		
		btnPageNext = new JButton("다음");
		pnlPaging.add(btnPageNext, BorderLayout.EAST);
		
		//페이지 번호가 표시되는 영역(Panel)
		pnlDispPage = new JPanel();
		pnlPaging.add(pnlDispPage, BorderLayout.CENTER);
		pnlDispPage.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		pnlTable = new JPanel();
		contentPane.add(pnlTable, BorderLayout.CENTER);
		pnlTable.setLayout(new BorderLayout(0, 0));
		
		//리스트를 읽어온다.
		showTable(mCurPageNo);
		
		//검색 버튼 클릭 이벤트 등록
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//리스트를 읽어온다.
				showTable(mCurPageNo);
			}
		});
		
		//이전 페이징 버튼
		btnPagePrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mCurPageNo > 1) {
					showTable(mCurPageNo - 1);
				}
			}
		});
		
		//다음 페이징 버튼
		btnPageNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mCurPageNo < mTotPageCnt) {
					showTable(mCurPageNo + 1);
				}
			}
		});
		
	};//end 생성자

	//리스트 출력
	public void showTable(int pageNo) {
		
		//멤버변수의 페이지값을 업데이트 해놓는다.
		mCurPageNo = pageNo;
				
		//리스트 데이터 조회
		List<BoardBean> boardList = mBoardCRUD.getBoardList(pageNo, txtSearch.getText()); 
		
		//페이징 표시 
		pnlDispPage.removeAll(); //기존 페이지 번호는 전체 삭제
		//추가
		int listTotCnt = mBoardCRUD.getTotalListCnt( txtSearch.getText() );
		//전체 페이지 갯수
		mTotPageCnt = (int)( Math.ceil( listTotCnt / 10.0 ) );
		//전체 페이지 갯수만큼 돌면서 라벨을 추가한다.
		for(int i=1; i<=mTotPageCnt; i++) {
			SpaceCLButton lblPage;
			if(pageNo == i) {
				//현재 페이지 표시방법
				lblPage = new SpaceCLButton( "[" + i + "]");
				lblPage.curPage = i;
			} else {
				lblPage = new SpaceCLButton(i + "");	
			}
			
			//TODO 페이지 클릭 이벤트
			//TODO 여기다 코딩
			lblPage.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if( e.getSource() instanceof SpaceCLButton ) {
						SpaceCLButton btn = (SpaceCLButton)e.getSource();
						String title = btn.getLabel();
						System.out.println("클릭한 페이지 번호: " + title);
						
						if( title.startsWith("[") ) {
							return;
						}
						int page = Integer.parseInt(title);
						showTable( page );	
					}
				}
			});
			
			pnlDispPage.add(lblPage);
		}//end for
		
		//TODO 왕중요!!!! 다시 패널에 페이지 버튼을 그려야함.
		pnlDispPage.revalidate();
		
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
		
		//TODO 테이블 더블클릭
		boardTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JTable table = (JTable)e.getSource();
				Point point = e.getPoint();
				int row = table.rowAtPoint(point);
				if( e.getClickCount() == 2 && table.getSelectedRow() != -1 ) {
					//TODO 더블클릭 이벤트 여기로 온다.
					System.out.println("클릭한 row값: " + row);
					
					//TableColumnModel model = table.getColumnModel();
					//row 행의 0 번째열의 값을 가져온다.
					String boardNo = (String)table.getValueAt(row, 0); 
					
					System.out.println("클릭한 테이블 고유번호: ???" + boardNo );
				}
			}
		});
		
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
		pnlTable.removeAll();
		pnlTable.add(scrollTable, BorderLayout.CENTER);
		
	}//end method
	
}
