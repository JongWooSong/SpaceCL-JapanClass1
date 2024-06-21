package board.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

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
	private JTable boardTable;
	private JButton brnWrite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainBoard2 frame = new MainBoard2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainBoard2() {
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
		
		boardTable = new JTable();
		contentPane.add(boardTable, BorderLayout.CENTER);
		
	
	}

}
