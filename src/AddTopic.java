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

public class AddTopic extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField title;
	private JTextField username;
	Connection conn;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTopic frame = new AddTopic();
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
	public AddTopic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				try {
					conn=DriverManager.getConnection(server,user,pass);

					stmt = conn.createStatement();
					String sql = "insert into topic (t_id, title, username)" +
							"values ('" +id.getText() +"', '" + title.getText()+"', '" + username.getText()
							+"')";
					System.out.println(stmt.executeUpdate(sql));

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton.setBounds(157, 193, 117, 29);
		contentPane.add(btnNewButton);
		
		id = new JTextField();
		id.setBounds(287, 27, 130, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		title = new JTextField();
		title.setBounds(287, 89, 130, 26);
		contentPane.add(title);
		title.setColumns(10);
		
		username = new JTextField();
		username.setBounds(287, 153, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Topic ID");
		lblNewLabel.setBounds(97, 32, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(97, 94, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(97, 158, 104, 16);
		contentPane.add(lblNewLabel_2);
	}

}
