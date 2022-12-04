import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DeleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	Connection conn;
	Statement stmt;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser();
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
	public DeleteUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setToolTipText("username");
		username.setBounds(241, 100, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				try {
					conn=DriverManager.getConnection(server,user,pass);
					stmt = conn.createStatement();
					String sql = "delete from usertable where username like '" + username.getText() + "'";
					//System.out.println(stmt.executeUpdate(sql));
					if(stmt.executeUpdate(sql)>0) {
						JOptionPane.showMessageDialog(null,"deleted");
					} else {
						JOptionPane.showMessageDialog(null,"there is no record to delete");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(86, 100, 117, 29);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("delete a user");
		lblNewLabel.setBounds(183, 24, 140, 16);
		contentPane.add(lblNewLabel);
	}

}
