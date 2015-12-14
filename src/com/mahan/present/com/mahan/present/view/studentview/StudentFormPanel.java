package com.mahan.present.com.mahan.present.view.studentview;
import com.mahan.present.StudentType;
import com.mahan.present.Validation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class StudentFormPanel extends JPanel {
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel usernameLabel;
	private JLabel PasswordLabel;
	private JLabel studentNoLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailAddressLabel;
	private JLabel addressLabel;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField usernameText;
	private JTextField passwordText;
	private JTextField studentNoText;
	private JTextField phoneNumberText;
	private JTextField emailAddressText;
	private JTextField addressText;
	private IStudentListener iStudentListener;
	private GridBagConstraints layout;
	private JButton submitButton;
	private JComboBox stdTypeCombo;
	private JLabel typeLabel;

	public StudentFormPanel() {
		setLayout(new GridBagLayout());
		layout = new GridBagConstraints();
		setDimension();
		createFields();
		setBorder();
	}


	public void setIStudentListener(IStudentListener student) {
		this.iStudentListener = student;
	}

	public void setBorder(){
		EtchedBorder inerBorder=new EtchedBorder();
		TitledBorder outerBorder=new TitledBorder("Student Info");
		setBorder(BorderFactory.createCompoundBorder(outerBorder,inerBorder));
	}

	private void setDimension() {
		Dimension dim = getPreferredSize();
		dim.height = 200;
		setPreferredSize(dim);
		setMinimumSize(dim);
	}

	private void createFields() {

		JLabel firstNameLabel = new JLabel("First Name:");
		JTextField firstNameText = new JTextField(15);
		layOutComponent(firstNameLabel, firstNameText, GridBagConstraints.PAGE_START, 0, 0, 1, 0);

		JLabel lastNameLabel = new JLabel("Last Name:");
		JTextField lastNameText = new JTextField(15);
		layOutComponent(lastNameLabel, lastNameText, GridBagConstraints.PAGE_START, 0, 1, 1, 1);

		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameText = new JTextField(15);
		layOutComponent(usernameLabel, usernameText, GridBagConstraints.PAGE_START, 0, 2, 1, 2);

		JLabel PasswordLabel = new JLabel("Password:");
		JTextField passwordText = new JTextField(15);
		layOutComponent(PasswordLabel, passwordText, GridBagConstraints.PAGE_START, 0, 3, 1, 3);

		JLabel studentNoLabel = new JLabel("Student_No:");
		JTextField studentNoText = new JTextField(15);
		layOutComponent(studentNoLabel, studentNoText, GridBagConstraints.FIRST_LINE_START, 2, 0, 3, 0);

		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		JTextField phoneNumberText = new JTextField(15);
		layOutComponent(phoneNumberLabel, phoneNumberText, GridBagConstraints.FIRST_LINE_START, 2, 1, 3, 1);

		JLabel emailAddressLabel = new JLabel("Email Address:");
		JTextField emailAddressText = new JTextField(15);
		layOutComponent(emailAddressLabel, emailAddressText, GridBagConstraints.FIRST_LINE_START, 2, 2, 3, 2);

		JLabel addressLabel = new JLabel("Address:");
		JTextField addressText = new JTextField(15);
		layOutComponent(addressLabel, addressText, GridBagConstraints.FIRST_LINE_START, 2, 3, 3, 3);

		typeLabel = new JLabel("stdType :");
		stdTypeCombo = new JComboBox();
		DefaultComboBoxModel stdmodel = new DefaultComboBoxModel();
		stdmodel.addElement(StudentType.MS.toString());
		stdmodel.addElement(StudentType.BS.toString());
		stdmodel.addElement(StudentType.Pdf.toString());
		stdTypeCombo.setModel(stdmodel);
		add(typeLabel);
		add(stdTypeCombo);

		createSubmitButton(layout);

	}

	private void createSubmitButton(GridBagConstraints l) {
		submitButton = new JButton("Submit");
		submitButton.setSize(50, 50);
		submitButton.setVisible(true);
		l.gridwidth = 1;
		l.gridx = 2;
		l.gridy = 4;
		add(submitButton, l);
		
			submitButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					String error = "";
					if (!Validation.checkTextFieldString(firstNameText.getText()))
						error += "First Name is incorrect \n";

					if (!Validation.checkTextFieldString(lastNameText.getText()))
						error += "last Name is incorrect \n";

					if (!Validation.checkTextFieldString(usernameText.getText()))
						error += "Username is incorrect \n";

					if (!Validation.checkTextField(passwordText.getText()))
						error += "Password is incorrect \n";

					if (!Validation.checkTextFieldNumber(studentNoText.getText()))
						error += "Student No is incorrect \n";

					if (!Validation.checkTextFieldNumber(phoneNumberText.getText()))
						error += "Phone Number No is incorrect \n";


					if (!Validation.checkTextField(emailAddressText.getText()))
						error += "Email Address is incorrect \n";

					if (!Validation.checkTextFieldString(addressText.getText()))
						error += "address is incorrect \n";


					if (error.equals("")) {

						StudentUI std = new StudentUI(firstNameText.getText(), lastNameText.getText(), usernameText.getText(), passwordText.getText(), studentNoText.getText(),
								phoneNumberText.getText(), emailAddressText.getText(), addressText.getText() , StudentType.MS);
						iStudentListener.addStudentObject(std);
						cleanTextFeilds();

					}else{
						JOptionPane.showMessageDialog(null, error);
					}
				}

				private void cleanTextFeilds() {
					firstNameText.setText(null);
					lastNameText.setText(null);
					usernameText.setText(null);
					passwordText.setText(null);
					studentNoText.setText(null);
					phoneNumberText.setText(null);
					emailAddressText.setText(null);
					addressText.setText(null);
				}
			});
		}
	




	public void layOutComponent(JLabel label, JTextField textField, int anchor, int LableGridX, int LableGridY, int TextFieldGridX, int TextFieldGridY) {

		layout.anchor = anchor;
		layout.weighty = 0.05;
		layout.weightx = 0.05;
		layout.gridx = LableGridX;
		layout.gridy = LableGridY;
		add(label, layout);
		layout.gridx = TextFieldGridX;
		layout.gridy = TextFieldGridY;
		add(textField, layout);
		
	}

}
