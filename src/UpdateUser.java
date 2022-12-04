import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateUser extends JFrame {

	private JPanel contentPane;
	private JTextField oun;
	private JTextField pw;
	private JTextField un;
	Connection conn;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUser frame = new UpdateUser();
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
	public UpdateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		oun = new JTextField();
		oun.setBounds(288, 6, 130, 26);
		contentPane.add(oun);
		oun.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Need update");
		lblNewLabel.setBounds(104, 11, 105, 16);
		contentPane.add(lblNewLabel);
		
		pw = new JTextField();
		pw.setBounds(288, 110, 130, 26);
		contentPane.add(pw);
		pw.setColumns(10);
		
		un = new JTextField();
		un.setBounds(79, 110, 130, 26);
		contentPane.add(un);
		un.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBounds(122, 170, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(325, 170, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				try {
					conn=DriverManager.getConnection(server,user,pass);
					stmt = conn.createStatement();
					String sql = "update usertable set username = '" + un.getText() + "', pass = '" + pw.getText() +"' "
							+ "where username = '" + oun.getText() +"'";
					System.out.println(stmt.executeUpdate(sql));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(162, 217, 117, 29);
		contentPane.add(btnNewButton);
	}

}
