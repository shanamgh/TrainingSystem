package com.mahan.present.com.mahan.present.view.courseview;

import com.mahan.present.PersonTableListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;

public class CourseTablePanel extends JPanel {
	private JTable courseTable;
	private CourseTableModel courseTableModel;
	private JPopupMenu popupMenu;
	private PersonTableListener personListener;

	public CourseTablePanel() {
		courseTableModel = new CourseTableModel();
		courseTable = new JTable(courseTableModel);
		setLayout(new BorderLayout());
		popupMenuOnCourseTable();
		add(new JScrollPane(courseTable), BorderLayout.CENTER);
	}

	private void popupMenuOnCourseTable() {
		popupMenu = new JPopupMenu();
		JMenuItem editItem = new JMenuItem("Edit Item");
		JMenuItem removeItem = new JMenuItem("Delete Item");
		popupMenu.add(removeItem);
		popupMenu.add(editItem);
		addMouseListener();
		addActionListenerForRemoveItem(removeItem);
		addActionListenerForEditItem(editItem);
	}

	private void addMouseListener() {
		courseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = courseTable.rowAtPoint(e.getPoint());
				courseTable.getSelectionModel().setSelectionInterval(row, row);
				if (e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(courseTable, e.getX(), e.getY());
				}
			}
		});
	}

	private void addActionListenerForEditItem(JMenuItem editItem) {
		editItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = courseTable.getSelectedRow();
				int col = courseTable.getSelectedColumn();
			}
		});
	}

	private void addActionListenerForRemoveItem(JMenuItem removeItem) {
		int row = courseTable.getSelectedRow();
		if (personListener != null) {
			personListener.rowDeleted(row);
			refreshCourseTable();
		}
	}

	public void setTableModelDataSource(List<CourseUI> course) {
		courseTableModel.setCourseList(course);
	}

	public void refreshCourseTable() {
		courseTableModel.fireTableDataChanged();
	}

	public void setPersonListener(PersonTableListener personListener) {
		this.personListener = personListener;
	}
}
