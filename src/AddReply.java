import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddReply extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField reply;
	private JTextField topic;
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
					AddReply frame = new AddReply();
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
	public AddReply() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(254, 6, 130, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		reply = new JTextField();
		reply.setBounds(254, 64, 130, 26);
		contentPane.add(reply);
		reply.setColumns(10);
		
		topic = new JTextField();
		topic.setBounds(254, 115, 130, 26);
		contentPane.add(topic);
		topic.setColumns(10);
		
		username = new JTextField();
		username.setBounds(254, 169, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("reply id");
		lblNewLabel.setBounds(74, 11, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("reply");
		lblNewLabel_1.setBounds(74, 69, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("topic id");
		lblNewLabel_2.setBounds(74, 120, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("username");
		lblNewLabel_3.setBounds(74, 174, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				try {
					conn=DriverManager.getConnection(server,user,pass);

					stmt = conn.createStatement();
					String sql = "insert into reply (rep_id, reply, t_id, username)" +
							"values ('" +id.getText() +"', '" + reply.getText()+"', '" +topic.getText()+"', '" + username.getText()
							+"')";
					System.out.println(stmt.executeUpdate(sql));

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(163, 217, 117, 29);
		contentPane.add(btnNewButton);
	}

}
