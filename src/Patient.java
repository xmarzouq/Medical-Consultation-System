import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Patient extends JFrame {

	private JPanel contentPane;
	Connection conn;
	Statement stmt;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor frame = new Doctor();
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
	public Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 0, 438, 266);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setToolTipText("Topics");
		tabbedPane.addTab("Topics forms", null, layeredPane_2, null);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTopic.main(null);
			}
		});
		btnNewButton_4.setBounds(132, 25, 117, 29);
		layeredPane_2.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Update");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTopic.main(null);
			}
		});
		btnNewButton_4_1.setBounds(132, 80, 117, 29);
		layeredPane_2.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("Delete");
		btnNewButton_4_1_1.setBounds(132, 145, 117, 29);
		layeredPane_2.add(btnNewButton_4_1_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Replies forms", null, layeredPane, null);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddReply.main(null);
			}
		});
		btnNewButton_2.setBounds(143, 6, 117, 29);
		layeredPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("UPDATE");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateReply.main(null);
			}
		});
		btnNewButton_2_1.setBounds(143, 62, 117, 29);
		layeredPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteReply.main(null);
			}
		});
		btnNewButton_3.setBounds(143, 126, 117, 29);
		layeredPane.add(btnNewButton_3);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("View topics", null, layeredPane_1, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 30, 405, 184);
		layeredPane_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("view");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				ResultSet rs;
				Connection conn;
				try {
					conn = DriverManager.getConnection(server, user, pass);
					Statement stmt=conn.createStatement();
					String sql="select * from topic";
					rs=stmt.executeQuery(sql);
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(147, 0, 117, 29);
		layeredPane_1.add(btnNewButton_1);
		
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		tabbedPane.addTab("View replies", null, layeredPane_4, null);
		
		JScrollPane repliesTable = new JScrollPane();
		repliesTable.setBounds(6, 40, 405, 174);
		layeredPane_4.add(repliesTable);
		
		table = new JTable();
		repliesTable.setViewportView(table);
		
		JButton btnNewButton = new JButton("view");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				ResultSet rs;
				Connection conn;
				try {
					conn = DriverManager.getConnection(server, user, pass);
					Statement stmt=conn.createStatement();
					String sql="select * from reply";
					rs=stmt.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(143, -1, 117, 29);
		layeredPane_4.add(btnNewButton);
	}

}
