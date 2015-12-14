package com.mahan.present.com.mahan.present.view.courseview;

import com.mahan.present.com.mahan.present.view.professorview.ProfessorUI;
import com.mahan.present.Validation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CourseFormPanel extends JPanel {
	private JLabel courseNameLabel;
	private JLabel course_NoLabel;
	private JLabel professorLabel;
	private JTextField courseNameText;
	private JTextField course_NoText;
	private JComboBox professorComboBox;
	private JButton submitButton;
	private GridBagConstraints layout;
	private CourseListener courseListener;
	
	
	public JTextField getCourseNameText() {
		return courseNameText;
	}
	public JTextField getCourse_NoText() {
		return course_NoText;
	}
	public JComboBox getProfessorComboBox() {
		return professorComboBox;
	}


	public void setCourse(CourseListener course) {
		this.courseListener
		= course;
	}
	public CourseFormPanel(){
		setLayout(new GridBagLayout());
		layout = new GridBagConstraints();
		setDimension();
		createFields();
		setBorder();
	}
	
	
	
	
	public void setBorder(){
		EtchedBorder inerBorder=new EtchedBorder();
		TitledBorder outerBorder=new TitledBorder("Course Info");
		setBorder(BorderFactory.createCompoundBorder(outerBorder,inerBorder));
	}
	private void setDimension() {
		Dimension dim = getPreferredSize();
		dim.height = 150;
		setPreferredSize(dim);
		setMinimumSize(dim);
	}
	
	private void createFields() {

		courseNameLabel = new JLabel("Course Name :");
		courseNameText = new JTextField(15);
		courseNameLabel.setVisible(true);
		courseNameText.setVisible(true);
		layOutComponent(courseNameLabel, courseNameText, GridBagConstraints.PAGE_START, 0, 0, 1, 0);

		course_NoLabel = new JLabel("Course No :");
		course_NoText = new JTextField(15);
		course_NoLabel.setVisible(true);
		course_NoText.setVisible(true);
		layOutComponent(course_NoLabel, course_NoText, GridBagConstraints.PAGE_START, 0, 1, 1, 1);
		
		createProfessorComboBox(layout);
		createSubmitButton(layout);
		


	}
	
	private void cleanTextFeilds() {
		getCourseNameText().setText(null);
		getCourse_NoText().setText(null);
		getProfessorComboBox().setSelectedItem(" ");

	}
	private void createProfessorComboBox(GridBagConstraints l) {
		
		professorLabel = new JLabel("Professor :");
		professorComboBox = new JComboBox();
		professorComboBox.setMaximumRowCount(4);
		l.anchor=GridBagConstraints.FIRST_LINE_START;
		layout.weighty = 0.05;
		layout.weightx = 0.05;
		l.fill=GridBagConstraints.HORIZONTAL;
		l.ipadx=1;
		l.gridx = 2;
		l.gridy = 0;
		add(professorLabel, l);
		l.gridx = 3;
		l.gridy = 0;
		add(professorComboBox, l);
		
	}
	
	private void createSubmitButton(GridBagConstraints l) {
		submitButton = new JButton("Submit");
		submitButton.setSize(50, 50);
		submitButton.setVisible(true);
		l.fill = GridBagConstraints.NONE;
		l.gridwidth = 1;
		l.gridx = 2;
		l.gridy = 4;
		add(submitButton, l);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String error = "";
				if (!Validation.checkTextFieldString(courseNameText.getText()))
					error += "Course Name is incorrect \n";
				
				if (!Validation.checkTextFieldNumber(course_NoText.getText()))
					error += "Course No is incorrect \n";
				
				
				if (error.equals("")) {
					if (professorComboBox.getSelectedItem() !=null){
				CourseUI course = new CourseUI(getCourseNameText().getText(),getCourse_NoText().getText(),getProfessorComboBox().getSelectedItem().toString());
				
				courseListener.addCourseObject(course);
				cleanTextFeilds();
			}else
				JOptionPane.showMessageDialog(null, "Please Select Professor");
				}
				else
					JOptionPane.showMessageDialog(null, error);
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
	
	public void setDataUtilArray(List<ProfessorUI> professorList){
		professorComboBox.setModel(new DefaultComboBoxModel<>(professorList.toArray()));;
		
	}
}
