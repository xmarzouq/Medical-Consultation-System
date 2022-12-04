import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteReply extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	Connection conn;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteReply frame = new DeleteReply();
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
	public DeleteReply() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(276, 47, 130, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Topic id");
		lblNewLabel.setBounds(81, 52, 61, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String server="jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa";
				String user="ma1912476";
				String pass="ma1912476";
				try {
					conn=DriverManager.getConnection(server,user,pass);
					stmt = conn.createStatement();
					String sql = "delete from reply where rep_id like '" + id.getText() + "'";
					System.out.println(stmt.executeUpdate(sql));
					if(stmt.executeUpdate(sql) == 1) {
						JOptionPane.showMessageDialog(null,"deleted");
					} else {
						JOptionPane.showMessageDialog(null,"there is no record to delete");

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(168, 132, 117, 29);
		contentPane.add(btnNewButton);
	}

}
