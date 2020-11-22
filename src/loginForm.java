package payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class loginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPass;

	data info = new data(); 

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginForm frame = new loginForm();
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
	public loginForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblID = new JLabel("Username:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(248, 116, 86, 14);
		contentPane.add(lblID);

		JLabel lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPass.setBounds(248, 147, 86, 14);
		contentPane.add(lblPass);

		JButton btnSubmit = new JButton("Log in");
		btnSubmit.setToolTipText("Please fill in textboxes above");
		btnSubmit.setEnabled(false);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				

				if ((txtID.getText().equals(info.username) && (txtPass.getText().equals(info.pass)))) {
					{
						loginForm.this.setVisible(false); 
						new menuForm().setVisible(true); 
					}
				} else {
					
					JOptionPane.showMessageDialog(null, "Invalid ID or password. Please re-enter login details", null, JOptionPane.WARNING_MESSAGE); 
					txtID.setText("");
					txtPass.setText(""); 
					txtID.requestFocus(); 
				}

			}
		});
		btnSubmit.setBounds(344, 193, 113, 33);
		contentPane.add(btnSubmit);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (txtID.getText().length() == 0 || txtPass.getText().length() == 0) {
					btnSubmit.setEnabled(false);
				} else {
					btnSubmit.setEnabled(true);
				}
			}
		});
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtID.setBounds(344, 114, 113, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtPass = new JTextField();
		txtPass.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (txtID.getText().length() == 0 || txtPass.getText().length() == 0) {
					btnSubmit.setEnabled(false);
				} else {
					btnSubmit.setEnabled(true);
				}
			}
		});
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPass.setBounds(344, 145, 113, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);

		
		JButton btnClose = new JButton("Close app");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int confirmBox = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the program?",	null, JOptionPane.YES_NO_OPTION);
				if (confirmBox == JOptionPane.YES_OPTION) {

					System.exit(0);

				}
			}
		});
		btnClose.setBounds(344, 245, 113, 33);
		contentPane.add(btnClose);		
		getRootPane().setDefaultButton(btnSubmit);
	}
}
