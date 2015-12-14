package com.mahan.present.com.mahan.present.view.studentview;

import com.mahan.present.PersonTableListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;

public class StudentTablePanel extends JPanel {
	private JTable studentTable;
	private StudentTableModel studentTableModel;
	private JPopupMenu popupMenu;
	private PersonTableListener personListener;

	public StudentTablePanel() {
		studentTableModel = new StudentTableModel();
		studentTable = new JTable(studentTableModel);
		setLayout(new BorderLayout());
		popupMenuOnStudentTable();
		add(new JScrollPane(studentTable), BorderLayout.CENTER);
	}

	private void popupMenuOnStudentTable() {
		popupMenu = new JPopupMenu();
		JMenuItem removeItem = new JMenuItem("Delete Row");
		JMenuItem editItem = new JMenuItem("Edit Item");
		popupMenu.add(removeItem);
		popupMenu.add(editItem);
		addMouseListener();
		addActionListenerForRemoveItem(removeItem);
		addActionListenerForEditItem(editItem);
	}

	private void addMouseListener() {
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = studentTable.rowAtPoint(e.getPoint());
				studentTable.getSelectionModel().setSelectionInterval(row, row);
				if (e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(studentTable, e.getX(), e.getY());
				}
			}

		});
	}

	private void addActionListenerForEditItem(JMenuItem editItem) {
		editItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				int row = studentTable.getSelectedRow();
				int cell = studentTable.getSelectedColumn();
			}
		});
	}

	private void addActionListenerForRemoveItem(JMenuItem removeItem) {
		removeItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = studentTable.getSelectedRow();
				if (personListener != null) {
					personListener.rowDeleted(row);
					refreshStudentTable();
				}
			}
		});
	}

	public void setTableModelDataSource(List<StudentUI> std) {
		studentTableModel.setStudentList(std);
	}

	public void refreshStudentTable() {
		studentTableModel.fireTableDataChanged();
	}

	public void setPersonTableListener(PersonTableListener personListener) {
		this.personListener = personListener;
	}
}
