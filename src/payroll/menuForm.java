package payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JSeparator;

public class menuForm extends JFrame {

	private JPanel contentPane;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuForm frame = new menuForm();
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
	public menuForm() {	
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { 
				int confirmBox = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to close the form? Once you closed the form you will have to log in again", "Exit", JOptionPane.YES_NO_OPTION); 
				if (confirmBox == JOptionPane.YES_OPTION) { 
					menuForm.this.dispose(); 						
					new loginForm().setVisible(true); 	
				}
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 671, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("Your ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(10, 11, 68, 14);
		contentPane.add(lblId);

		JLabel lblCurrentUser = new JLabel(data.username);
		lblCurrentUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurrentUser.setBounds(49, 36, 46, 14);
		contentPane.add(lblCurrentUser);

		JButton btnEmp = new JButton("Add employee");
		btnEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				menuForm.this.dispose(); 											
				new addEmpForm().setVisible(true); t

			}
		});
		btnEmp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEmp.setBounds(239, 87, 138, 44);
		contentPane.add(btnEmp);

		JButton btnCalculate = new JButton("Calculate salary");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				menuForm.this.dispose();
				new salaryForm().setVisible(true);

			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalculate.setBounds(239, 153, 138, 44);
		contentPane.add(btnCalculate);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int confirmBox = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
				if (confirmBox == JOptionPane.YES_OPTION) {
					menuForm.this.dispose();
					JOptionPane.showMessageDialog(null, "You have been logged out!");
					new loginForm().setVisible(true);
				}
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogout.setBounds(239, 218, 138, 44);
		contentPane.add(btnLogout);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 635, 2);
		contentPane.add(separator);
	}
}
