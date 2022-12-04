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

public class UpdateReply extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField newReply;
	Connection conn;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateReply frame = new UpdateReply();
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
	public UpdateReply() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(275, 6, 130, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Reply id");
		lblNewLabel.setBounds(86, 11, 61, 16);
		contentPane.add(lblNewLabel);
		
		newReply = new JTextField();
		newReply.setBounds(275, 62, 130, 26);
		contentPane.add(newReply);
		newReply.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New reply");
		lblNewLabel_1.setBounds(86, 67, 99, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				try {
					conn=DriverManager.getConnection(server,user,pass);

					stmt = conn.createStatement();
					String sql = "update reply set reply = '" + newReply.getText() + "'"
							+ "where rep_id = '" + id.getText() +"'";
					System.out.println(stmt.executeUpdate(sql));

				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(152, 171, 117, 29);
		contentPane.add(btnNewButton);
	}

}
