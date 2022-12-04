import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UpdateTopic extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	Connection conn;
	Statement stmt;
	private JTextField title;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateTopic frame = new UpdateTopic();
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
	public UpdateTopic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				try {
					conn=DriverManager.getConnection(server,user,pass);

					stmt = conn.createStatement();
					String sql = "update topic set title = '" +title.getText()+ "'"
							+ "where t_id = '" + id.getText() +"'";
					System.out.println(stmt.executeUpdate(sql));

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(163, 213, 117, 29);
		contentPane.add(btnNewButton);
		
		id = new JTextField();
		id.setBounds(285, 25, 130, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		title = new JTextField();
		title.setBounds(285, 105, 130, 26);
		contentPane.add(title);
		title.setColumns(10);
		
		lblNewLabel = new JLabel("Topic Id");
		lblNewLabel.setBounds(122, 30, 61, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New Topic title");
		lblNewLabel_1.setBounds(122, 110, 95, 16);
		contentPane.add(lblNewLabel_1);
	}

}
