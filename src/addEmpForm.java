package payroll; 

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class addEmpForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtFirstname;
	private JTextField txtSurname;
	private JTextField txtMobile;
	private final ButtonGroup buttonGroup = new ButtonGroup(); 
	private JTextField txtDOB;

	data details = new data(); 

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addEmpForm frame = new addEmpForm();
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

	public addEmpForm() {		
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { 
				int confirmBox = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to close the form? Once you closed the form you will have to put all details again", "Exit", JOptionPane.YES_NO_OPTION); 
				if (confirmBox == JOptionPane.YES_OPTION) { 
					addEmpForm.this.dispose(); 
					new loginForm().setVisible(true); 
				}
			}
			
			@Override
			public void windowOpened(WindowEvent arg0) {

				txtID.requestFocus();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 790, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 77, 97, 14);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("Your ID:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 11, 68, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel(data.username);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(49, 36, 46, 14);
		contentPane.add(label_1);

		txtID = new JTextField();
		txtID.setToolTipText("Please put employee's unique ID number");
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtID.setBounds(117, 75, 110, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 754, 2);
		contentPane.add(separator);

		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname.setBounds(10, 108, 97, 14);
		contentPane.add(lblFirstname);

		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFirstname.setColumns(10);
		txtFirstname.setBounds(117, 106, 110, 20);
		contentPane.add(txtFirstname);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurname.setBounds(10, 139, 97, 14);
		contentPane.add(lblSurname);

		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSurname.setColumns(10);
		txtSurname.setBounds(117, 137, 110, 20);
		contentPane.add(txtSurname);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(10, 176, 97, 14);
		contentPane.add(lblAddress);

		JTextArea txaAddress = new JTextArea();
		txaAddress.setWrapStyleWord(true);
		Border border = BorderFactory.createLineBorder(new Color(156, 168, 188));
		txaAddress
		.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txaAddress.setLineWrap(true);
		txaAddress.setBounds(117, 172, 110, 94);
		contentPane.add(txaAddress);

		txtDOB = new JTextField();
		txtDOB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDOB.setColumns(10);
		txtDOB.setBounds(117, 277, 110, 20);
		contentPane.add(txtDOB);

		JLabel lblDob = new JLabel("DOB:");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDob.setBounds(10, 279, 97, 14);
		contentPane.add(lblDob);

		JLabel lblMobileNumber = new JLabel("Mobile number:");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMobileNumber.setBounds(10, 322, 97, 14);
		contentPane.add(lblMobileNumber);

		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMobile.setColumns(10);
		txtMobile.setBounds(117, 320, 110, 20);
		contentPane.add(txtMobile);

		JLabel lblEmployTime = new JLabel("Employ time:");
		lblEmployTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmployTime.setBounds(354, 111, 97, 14);
		contentPane.add(lblEmployTime);

		JRadioButton rdbFull = new JRadioButton("Full time");
		buttonGroup.add(rdbFull);
		rdbFull.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbFull.setBounds(434, 132, 109, 23);
		contentPane.add(rdbFull);

		JRadioButton rdbPart = new JRadioButton("Part time");
		buttonGroup.add(rdbPart);
		rdbPart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbPart.setBounds(434, 158, 109, 23);
		contentPane.add(rdbPart);

		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDepartment.setBounds(354, 211, 97, 14);
		contentPane.add(lblDepartment);

		JComboBox cmbDepartment = new JComboBox();
		cmbDepartment.setModel(new DefaultComboBoxModel(new String[] { "", "Managing Director", "Store Manager",
			"Store Supervisor", "Administration", "Sales " }));
		cmbDepartment.setBounds(434, 208, 142, 20);
		contentPane.add(cmbDepartment);

		JButton btnGenerate = new JButton("<html>Generate textfile<br>with employee's details</html>");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

				String userDir = System.getProperty("user.home");
				JFileChooser chooser = new JFileChooser(userDir +"/Desktop");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				int returnVal = chooser.showDialog(chooser, "Save text file in this location");
				if (returnVal == JFileChooser.APPROVE_OPTION) { 
					System.out.println(chooser.getSelectedFile());
				}
				
				details.ID = txtID.getText();
				details.firstname = txtFirstname.getText();
				details.surname = txtSurname.getText();
				details.DOB = txtDOB.getText();
				details.address = txaAddress.getText();
				details.mobile = txtMobile.getText();
				details.part = rdbPart.getText();
				details.full = rdbFull.getText();

				Object combox = cmbDepartment.getSelectedItem();
				details.position = combox.toString();

				
				try {
					if (rdbFull.isSelected()) { 
						BufferedWriter bw = new BufferedWriter(
						new FileWriter(chooser.getSelectedFile() + "//Details.txt", true)); 
						bw.write(details.ID);
						bw.newLine();
						bw.write(details.firstname);
						bw.newLine();
						bw.write(details.surname);
						bw.newLine();
						bw.write(details.DOB);
						bw.newLine();
						bw.write(details.address);
						bw.newLine();
						bw.write(details.mobile);
						bw.newLine();
						bw.write(details.full);
						bw.newLine();
						bw.write(details.position);
						bw.newLine();
						bw.close();

						JOptionPane.showMessageDialog(null, "Employee's detials have been generated"); 
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				try {

					if (rdbPart.isSelected()) { 
						BufferedWriter bw = new BufferedWriter(
						new FileWriter(chooser.getSelectedFile() + "//Details.txt", true));
						bw.write(details.ID);
						bw.newLine();
						bw.write(details.firstname);
						bw.newLine();
						bw.write(details.surname);
						bw.newLine();
						bw.write(details.DOB);
						bw.newLine();
						bw.write(details.address);
						bw.newLine();
						bw.write(details.mobile);
						bw.newLine();
						bw.write(details.part);
						bw.newLine();
						bw.write(details.position);
						bw.newLine();
						bw.close();

						JOptionPane.showMessageDialog(null, "Detials have been generated");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGenerate.setBounds(555, 311, 160, 45);
		contentPane.add(btnGenerate);
		
		JButton btnOpen = new JButton("Open the menu");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int confirmBox = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to open the main screen? Unsaved data will be lost!", null,
				JOptionPane.YES_NO_OPTION);

				if (confirmBox == JOptionPane.YES_OPTION) {

					addEmpForm.this.dispose();
					new menuForm().setVisible(true);

				}
			}
		});
		btnOpen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOpen.setBounds(612, 16, 142, 34);
		contentPane.add(btnOpen);

		
		JButton btnClear = new JButton("Clear all boxes");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int confirmBox = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the form?", "Clear", JOptionPane.YES_NO_OPTION); 
				if (confirmBox == JOptionPane.YES_OPTION) { 
					txtID.setText("");
					txtFirstname.setText("");
					txtSurname.setText("");
					txtMobile.setText("");
					txtDOB.setText("");
					txaAddress.setText("");

					txtID.requestFocus(); 

					buttonGroup.clearSelection(); 

					cmbDepartment.setSelectedIndex(0); 
				}
			}

		});
		btnClear.setBounds(357, 311, 186, 45);
		contentPane.add(btnClear);
	}
}
