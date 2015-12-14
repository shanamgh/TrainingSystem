package com.mahan.present.com.mahan.present.view.professorview;

import java.util.*;

import javax.swing.table.AbstractTableModel;

public class ProfessorTableModel extends AbstractTableModel {
	private String[] colProfessorName = { "First Name", "Last Name", "Username", "Password", "Professor_No"};
	private List<ProfessorUI> professorList;

	public ProfessorTableModel() {
		professorList = new ArrayList<>();
	}

	public void setprofessorList(List<ProfessorUI> professorList) {
		this.professorList = professorList;
	}

	@Override
	public int getColumnCount() {

		return colProfessorName.length;
	}

	@Override
	public String getColumnName(int i) {
		return colProfessorName[i];
	}

	@Override
	public int getRowCount() {
		return professorList.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column){
		case 0:
			return professorList.get(row).getFirstName();
		case 1:
			return professorList.get(row).getLastName();
		case 2:
			return professorList.get(row).getUsername();
		case 3 :
			return professorList.get(row).getPassword();
		case 4:
			return professorList.get(row).getProfessorNo();
		case 5:
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		switch (col){
		case 0:
			return true;
		case 1:
			return true;
		case 3:
			return true;
		case 4:
			return true;
			default:
				return false;
		}
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		if(professorList==null){
			return;
		}
		ProfessorUI p = (ProfessorUI)professorList.get(row);
		switch(col){
		case 0:
			p.setFirstName((String)value);
			break;
		case 1:
			p.setLastName((String)value);
			break;
		case 3:
			p.setUsername((String)value);
			break;
		case 4:
			p.setPassword((String)value);
			break;
		default:
			return ;
		}
	}

}
