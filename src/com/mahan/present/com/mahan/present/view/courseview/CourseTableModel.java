package com.mahan.present.com.mahan.present.view.courseview;

import java.util.*;

import javax.swing.table.AbstractTableModel;

public class CourseTableModel extends AbstractTableModel {
	private String[] colCourseName={"Course Name","Course_No","Professor"};
	private List<CourseUI> courseList;
	
	CourseTableModel(){
		courseList = new ArrayList<>();
	}
	
	public void setCourseList(List<CourseUI> courseList) {
		this.courseList = courseList;
	}

	@Override
	public int getColumnCount() {
		return colCourseName.length;
	}

	@Override
	public int getRowCount() {
		return courseList.size();
	}

	@Override
	public String getColumnName(int i) {
		return colCourseName[i];
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		switch (column){
		case 0:
			return courseList.get(row).getCourseName();
		case 1:
			return courseList.get(row).getCourse_No();
		case 2:
			return courseList.get(row).getCoursesProfessor();
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		switch (col){
		case 0:
			return true;
			default:
				return false;
		}
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		if(courseList==null){
			return;
		}
		CourseUI c = (CourseUI)courseList.get(row);
		switch(col){
		case 0:
			c.setCourseName((String)value);
			break;
		default:
			return ;
		}
	}


}
