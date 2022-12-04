import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private Operations op;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel windowTitle = new JLabel("Login");
		windowTitle.setBounds(202, 6, 61, 16);
		contentPane.add(windowTitle);
		
		username = new JTextField();
		username.setToolTipText("Username");
		username.setBounds(226, 74, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setToolTipText("Password");
		password.setBounds(226, 134, 130, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(66, 79, 84, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(66, 139, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				ResultSet rs;
				ResultSet rs2;
				Connection conn;
				PreparedStatement stmt;
				PreparedStatement stmt2;
				String un=username.getText();
				String pw=password.getText();
				//select usertype_id from usertable where username like 'AhmadUser';
				try {
					conn=DriverManager.getConnection(server,user,pass);
					stmt=conn.prepareStatement("select username,pass from usertable where username like ? and pass like ?");
					stmt2=conn.prepareStatement("select usertype_id from usertable where username like ?");
					stmt.setString(1, un);
					stmt.setString(2, pw);
					rs=stmt.executeQuery();
					
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Correct Validation");
						stmt2=conn.prepareStatement("select usertype_id from usertable where username like ?");
						stmt2.setString(1, un);
						rs2=stmt2.executeQuery();
						if(rs2.next()) {
							int choice = rs2.getInt(1);
							switch(choice) {
							case 1:{
								JOptionPane.showMessageDialog(null, "Getting Admin interface");
								Admin.main(null);
								break;
							} case 2:{
								JOptionPane.showMessageDialog(null, "Getting Doctor interface");
								Doctor.main(null);
								break;
							} case 3:{
								JOptionPane.showMessageDialog(null, "Getting Patient interface");
								Patient.main(null);
								break;
							}
							}
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect Validation");
						
					}
					stmt.close();
					conn.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		}) ;
		btnNewButton.setBounds(239, 183, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"Closing the Screen");
				dispose();
			}
		});
		btnNewButton_1.setBounds(66, 183, 117, 29);
		contentPane.add(btnNewButton_1);
	}
	
//	private void close() {
//		try {
//			op = new Operations();
//			JOptionPane.showMessageDialog(null, "Closing the screen");
//			op.CloseMethod();
//			dispose();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
//	private void connect() {
//		String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
//		String user="ma1912476";
//		String pass="ma1912476";
//		
//		try {
//			conn=DriverManager.getConnection(server, user, pass);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//	}
}
