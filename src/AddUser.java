import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField un;
	private JTextField pw;
	private JTextField type;
	Connection conn;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		un = new JTextField();
		un.setBounds(263, 30, 130, 26);
		contentPane.add(un);
		un.setColumns(10);
		
		pw = new JTextField();
		pw.setBounds(263, 92, 130, 26);
		contentPane.add(pw);
		pw.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(76, 35, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(76, 97, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("UserType");
		lblNewLabel_2.setBounds(76, 157, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		type = new JTextField();
		type.setBounds(263, 152, 130, 26);
		contentPane.add(type);
		type.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				try {
					conn=DriverManager.getConnection(server,user,pass);
					stmt = conn.createStatement();
					String sql = "insert into USERTABLE (username, pass, usertype_id)" +
					"values ('" + un.getText() + "', '"+ pw.getText() + "', '" + Integer.parseInt(type.getText()) + "')";
					System.out.println(stmt.executeUpdate(sql));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(155, 190, 117, 29);
		contentPane.add(btnNewButton);
	}
}
