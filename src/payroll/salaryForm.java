package assignment3;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class salaryForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmp;
	private JTextField txtHours;

	ArrayList<data> emps = new ArrayList<data>(); 
	private JTextField txtFindFirstname;
	private JTextField txtFindSurname;
	private JTextField txtFindMobile;
	private JTextField txtFindTime;
	private JTextField txtFindDepartment;
	private JTextField txtFindDOB;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salaryForm frame = new salaryForm();
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
	public salaryForm() {
		addWindowListener(new WindowAdapter() {		
			@Override
			public void windowClosing(WindowEvent e) {
				int confirmBox = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the form? Once you closed the form you will have to put all details again",	"Exit", JOptionPane.YES_NO_OPTION);
				if (confirmBox == JOptionPane.YES_OPTION) {
					salaryForm.this.dispose();
					new loginForm().setVisible(true);
				}
			}

			@Override
			public void windowOpened(WindowEvent arg0) {

				txtEmp.requestFocus();

			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 728, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txaSummary = new JTextArea();
		txaSummary.setWrapStyleWord(true);
		txaSummary.setEditable(false);
		Border border11 = BorderFactory.createLineBorder(new Color(174, 177, 183));
		txaSummary.setBorder(
		BorderFactory.createCompoundBorder(border11, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txaSummary.setLineWrap(true);
		txaSummary.setBounds(20, 403, 679, 111);
		contentPane.add(txaSummary);

		JLabel label = new JLabel("Your ID:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 11, 68, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel(data.username);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(49, 36, 46, 14);
		contentPane.add(label_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 701, 2);
		contentPane.add(separator);

		JLabel label_2 = new JLabel("Employee ID:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(60, 80, 97, 14);
		contentPane.add(label_2);

		txtHours = new JTextField();
		txtHours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHours.setColumns(10);
		txtHours.setBounds(137, 354, 110, 20);
		contentPane.add(txtHours);

		JLabel lblHoursWorked = new JLabel("Hours worked:");
		lblHoursWorked.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoursWorked.setBounds(31, 357, 97, 14);
		contentPane.add(lblHoursWorked);
		Border border = BorderFactory.createLineBorder(new Color(174, 177, 183));
		
		JButton btnCalculate = new JButton("Calculate payment");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				double hours = 0.0;

				hours = Double.parseDouble(txtHours.getText());

				double ROP = 0.0;

				double gross = 0.0;

				double total = 0.0;

				double tax = 0.0;

				double NI = 0.0;

				double payRate = 0.0;

				
				if (txtFindDepartment.getText().equals("Managing Director")) {

					ROP = 50;

					payRate = 50;

				} else if (txtFindDepartment.getText().equals("Store Manager")) {

					ROP = 25;

					payRate = 25;
				} else if (txtFindDepartment.getText().equals("Store Supervisor")) {

					ROP = 20;

					payRate = 20;
				} else if (txtFindDepartment.getText().equals("Administration")) {

					ROP = 12.50;

					payRate = 12.50;
				} else if (txtFindDepartment.getText().equals("Sales")) {

					ROP = 7.80;

					payRate = 7.80;
				}

				if (hours > 156) {
					gross = (hours * ROP) * 1.5;

				} else if (hours < 156) {
					gross = hours * ROP;
				}

				NI = gross * 0.12;
				// or (gross * 100) / 12;

				if (gross > 800) {
					tax = gross * 0.2;
				} else if (gross < 800) {
					tax = 0.0;
				}

				total = gross - (tax + NI);

				int hours2 = (int) hours;

				int payRate2 = (int) payRate;

				txaSummary.setText("Employee ID: " + txtEmp.getText() + "\n" + "Gross pay: " + "$" + gross + "0" + "\n"
				+ "Gross pay with deductions: " + "$" + total + "0" + "\n" + "Pay rate: " + payRate2 + "\n"
				+ "Hours worked: " + hours2);

			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalculate.setBounds(270, 354, 170, 23);
		contentPane.add(btnCalculate);
		JButton btnOpen = new JButton("Open the menu");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int confirmBox = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to open the main screen? Unsaved data will be lost!", null,
				JOptionPane.YES_NO_OPTION);

				if (confirmBox == JOptionPane.YES_OPTION) {

					salaryForm.this.dispose();
					new menuForm().setVisible(true);

				}
			}
		});
		btnOpen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOpen.setBounds(557, 16, 142, 34);
		contentPane.add(btnOpen);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(20, 203, 97, 14);
		contentPane.add(lblAddress);

		JTextArea txaFindAddress = new JTextArea();
		txaFindAddress.setEditable(false);
		txaFindAddress.setTabSize(0);
		txaFindAddress.setWrapStyleWord(true);
		Border border1 = BorderFactory.createLineBorder(new Color(176, 205, 252));
		txaFindAddress.setBorder(
		BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txaFindAddress.setLineWrap(true);
		txaFindAddress.setBounds(113, 203, 110, 94);
		txaFindAddress.setOpaque(false);
		contentPane.add(txaFindAddress);

		txtFindMobile = new JTextField();
		txtFindMobile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFindMobile.setEditable(false);
		txtFindMobile.setColumns(10);
		txtFindMobile.setBounds(391, 176, 110, 20);
		contentPane.add(txtFindMobile);

		JLabel label_4 = new JLabel("Mobile number:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(288, 179, 97, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Employ time:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(288, 215, 97, 14);
		contentPane.add(label_5);

		txtFindTime = new JTextField();
		txtFindTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFindTime.setEditable(false);
		txtFindTime.setColumns(10);
		txtFindTime.setBounds(391, 212, 110, 20);
		contentPane.add(txtFindTime);

		JLabel label_6 = new JLabel("Department:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(288, 250, 97, 14);
		contentPane.add(label_6);

		txtFindDepartment = new JTextField();
		txtFindDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFindDepartment.setEditable(false);
		txtFindDepartment.setColumns(10);
		txtFindDepartment.setBounds(391, 247, 110, 20);
		contentPane.add(txtFindDepartment);

		JLabel lblDob = new JLabel("DOB:");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDob.setBounds(288, 140, 97, 14);
		contentPane.add(lblDob);

		txtFindDOB = new JTextField();
		txtFindDOB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFindDOB.setEditable(false);
		txtFindDOB.setColumns(10);
		txtFindDOB.setBounds(391, 137, 110, 20);
		contentPane.add(txtFindDOB);

		JButton btnFind = new JButton("Find employee's details");
		btnFind.setToolTipText("Please fill in employee ID textbox to enable this button");
		btnFind.setEnabled(false);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String userDir = System.getProperty("user.home");
				JFileChooser chooser = new JFileChooser(userDir +"/Desktop");
				Component salaryForm = null; 
				if (chooser.showOpenDialog(salaryForm) == JFileChooser.APPROVE_OPTION) { 
					try {
						BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile().getPath()));

						for (String line = br.readLine(); line != null; line = br.readLine()) {
							// or while((String line = br.readLine()) != null){

							data a = new data();
							a.ID = line;
							a.firstname = br.readLine();
							a.surname = br.readLine();
							a.DOB = br.readLine();
							a.address = br.readLine();
							a.mobile = br.readLine();
							a.time = br.readLine();
							a.position = br.readLine();
							emps.add(a);
						}

						String line;
						while ((line = br.readLine()) != null) {
							String[] vals = line.split("");
							data a = new data();
							a.ID = vals[0];
							a.firstname = vals[1];
							a.surname = vals[2];
							a.DOB = vals[3];
							a.address = vals[4];
							a.mobile = vals[5];
							a.time = vals[6];
							a.position = vals[7];
							emps.add(a);
						}

						for (data a : emps) {
							if (a.ID.equals(txtEmp.getText())) {
								txtFindFirstname.setText(a.firstname);
								txtFindSurname.setText(a.surname);
								txtFindDOB.setText(a.DOB);
								txaFindAddress.setText(a.address);
								txtFindMobile.setText(a.mobile);
								txtFindTime.setText(a.time);
								txtFindDepartment.setText(a.position);
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnFind.setBounds(275, 73, 186, 34);
		contentPane.add(btnFind);

		txtEmp = new JTextField();
		txtEmp.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				if (txtEmp.getText().length() == 0) {
					btnFind.setEnabled(false);
				} else {
					btnFind.setEnabled(true);
				}
			}
		});
		txtEmp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmp.setColumns(10);
		txtEmp.setBounds(140, 76, 110, 23);
		contentPane.add(txtEmp);

		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname.setBounds(20, 137, 97, 14);
		contentPane.add(lblFirstname);

		txtFindFirstname = new JTextField();
		txtFindFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFindFirstname.setEditable(false);
		txtFindFirstname.setColumns(10);
		txtFindFirstname.setBounds(113, 134, 110, 20);
		contentPane.add(txtFindFirstname);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurname.setBounds(20, 168, 97, 14);
		contentPane.add(lblSurname);

		txtFindSurname = new JTextField();
		txtFindSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFindSurname.setEditable(false);
		txtFindSurname.setColumns(10);
		txtFindSurname.setBounds(113, 165, 110, 20);
		contentPane.add(txtFindSurname);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 325, 701, 2);
		contentPane.add(separator_2);

		
		JButton btnClearAllBoxes = new JButton("Clear boxes below");
		btnClearAllBoxes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int confirmBox = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear boxes below?",	"Clear", JOptionPane.YES_NO_OPTION);
				if (confirmBox == JOptionPane.YES_OPTION) {
					txtEmp.setText("");
					txtFindFirstname.setText("");
					txtFindSurname.setText("");
					txtFindMobile.setText("");
					txtFindTime.setText("");
					txtFindDepartment.setText("");
					txtFindDOB.setText("");
					txaFindAddress.setText("");

					txtEmp.requestFocus();

					btnFind.setEnabled(false);

				}
			}

		});
		btnClearAllBoxes.setBounds(473, 74, 186, 34);
		contentPane.add(btnClearAllBoxes);		
		JButton btnCalculateNew = new JButton("Calculate a new record");
		btnCalculateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int confirmBox = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear current calulation?", "Clear", JOptionPane.YES_NO_OPTION);
				if (confirmBox == JOptionPane.YES_OPTION) {
					txaSummary.setText("");
					txtHours.setText("");

					txtHours.requestFocus();
				}
			}

		});
		btnCalculateNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCalculateNew.setBounds(452, 353, 170, 23);
		contentPane.add(btnCalculateNew);

	}
}
