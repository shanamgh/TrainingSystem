package com.mahan.present.com.mahan.present.view.studentview;

import java.util.*;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {
	private String[] colStudentName = { "First Name", "Last Name", "Username", "Password", "Student_No", "Phone Number", "Email Address", "Address"};
	private List<StudentUI> studentList;

	StudentTableModel() {
		studentList = new ArrayList<>();
	}

	public void setStudentList(List<StudentUI> studentList) {
		this.studentList = studentList;
	}

	@Override
	public int getColumnCount() {

		return colStudentName.length;
	}

	@Override
	public String getColumnName(int i) {
		return colStudentName[i];
	}

	@Override
	public int getRowCount() {
		return studentList.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column){
		case 0:
			return studentList.get(row).getFirstName();
		case 1:
			return studentList.get(row).getLastName();
		case 2:
			return studentList.get(row).getUsername();
		case 3 :
			return studentList.get(row).getPassword();
		case 4:
			return studentList.get(row).getStudentNo();
		case 5:
			return studentList.get(row).getPhoneNumber();
		case 6:
			return studentList.get(row).getEmailAddress();
		case 7:
			return studentList.get(row).getAddress();
		}
		return null;
	}
	
	public boolean isCellEditable(int row,int cell){
		switch (cell){
		case 0:
			return true;
		case 1:
			return true;
		case 5:
			return true;
		case 6:
			return true;
		case 7:
			return true;
			default:
				return false;
					
	}
	}
	@Override
	public void setValueAt(Object value, int row, int col) {
		if (studentList==null){
			return ;
		}
		StudentUI s = (StudentUI)studentList.get(row);
		switch (col){
		case 0:
			s.setFirstName((String)value);
			break;
		case 1:
			s.setLastName((String)value);
			break;
		case 5:
			s.setPhoneNumber((String)value);
			break;
		case 6:
			s.setEmailAddress((String)value);
			break;
		case 7:
			s.setAddress((String)value);
			break;
			default:
				return ;
		}
	}

}
