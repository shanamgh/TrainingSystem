package com.mahan.present.com.mahan.present.view.professorview;

import com.mahan.present.Validation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ProfessorFormPanel extends JPanel {
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel usernameLabel;
	private JLabel PasswordLabel;
	private JLabel Professor_NoLabel;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField usernameText;
	private JTextField passwordText;
	private JTextField professor_NoText;
	private ProfessorListener professorListener;
	private GridBagConstraints layout;
	private JButton submitButton;

	public JTextField getFirstNameText() {
		return firstNameText;
	}

	public JTextField getLastNameText() {
		return lastNameText;
	}

	public JTextField getUsernameText() {
		return usernameText;
	}

	public JTextField getPasswordText() {
		return passwordText;
	}

	public JTextField getProfessor_NoText() {
		return professor_NoText;
	}

	public ProfessorFormPanel() {

		setLayout(new GridBagLayout());
		layout = new GridBagConstraints();
		setDimension();
		createFields();
		createActionListenerForSubmitButton();
		setBorder();
	}
	
	
	
	
	public void setBorder(){
		EtchedBorder inerBorder=new EtchedBorder();
		TitledBorder outerBorder=new TitledBorder("Professor Info");
		setBorder(BorderFactory.createCompoundBorder(outerBorder,inerBorder));
	}

	public void setProfessor(ProfessorListener professor) {
		this.professorListener = professor;
	}

	private void createActionListenerForSubmitButton() {

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
				
				if (!Validation.checkTextFieldNumber(professor_NoText.getText())) 
					error += "Professor No is incorrect \n";
				
				
				if (error.equals("")) {

				ProfessorUI professor = new ProfessorUI(getFirstNameText().getText(), getLastNameText().getText(), getUsernameText().getText(), getPasswordText().getText(), getProfessor_NoText()
						.getText());
				DataUtil.professorList.add(professor);
				professorListener.addProfessorObject(professor);
				cleanTextFeilds();
				
			}
				else
				JOptionPane.showMessageDialog(null, error);
				
			}

			private void cleanTextFeilds() {
				getFirstNameText().setText(null);
				getLastNameText().setText(null);
				getUsernameText().setText(null);
				getPasswordText().setText(null);
				getProfessor_NoText().setText(null);

			}
		});
	}

	private void setDimension() {
		Dimension dim = getPreferredSize();
		dim.height = 200;
		setPreferredSize(dim);
		setMinimumSize(dim);
	}

	private void createSubmitButton(GridBagConstraints l) {
		submitButton = new JButton("Submit");
		submitButton.setSize(50, 50);
		submitButton.setVisible(true);
		l.gridwidth = 1;
		l.gridx = 2;
		l.gridy = 4;
		add(submitButton, l);
	}

	private void createFields() {

		firstNameLabel = new JLabel("First Name :");
		firstNameText = new JTextField(15);
		firstNameLabel.setVisible(true);
		firstNameText.setVisible(true);
		layOutComponent(firstNameLabel, firstNameText, GridBagConstraints.PAGE_START, 0, 0, 1, 0);

		lastNameLabel = new JLabel("Last Name :");
		lastNameText = new JTextField(15);
		lastNameLabel.setVisible(true);
		lastNameText.setVisible(true);
		layOutComponent(lastNameLabel, lastNameText, GridBagConstraints.PAGE_START, 0, 1, 1, 1);
		Professor_NoLabel = new JLabel("Professor_No :");
		professor_NoText = new JTextField(15);
		Professor_NoLabel.setVisible(true);
		professor_NoText.setVisible(true);
		layOutComponent(Professor_NoLabel, professor_NoText, GridBagConstraints.PAGE_START, 0, 2, 1, 2);

		usernameLabel = new JLabel("Username :");
		usernameText = new JTextField(15);
		usernameLabel.setVisible(true);
		usernameText.setVisible(true);
		layOutComponent(usernameLabel, usernameText, GridBagConstraints.FIRST_LINE_START, 2, 0, 3, 0);

		PasswordLabel = new JLabel("Password :");
		passwordText = new JTextField(15);
		PasswordLabel.setVisible(true);
		passwordText.setVisible(true);
		layOutComponent(PasswordLabel, passwordText, GridBagConstraints.FIRST_LINE_START, 2, 1, 3, 1);

		
		createSubmitButton(layout);

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
