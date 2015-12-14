package com.mahan.present;

import com.mahan.present.com.mahan.present.view.professorview.ProfessorTableModel;
import com.mahan.present.com.mahan.present.view.professorview.ProfessorUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;

public class ProfessorTablePanel extends JPanel {
	private JTable professortable;
	private ProfessorTableModel professorTableModel;
	private JPopupMenu popupMenu;
	private PersonTableListener personListener;


	public ProfessorTablePanel() {
		professorTableModel = new ProfessorTableModel();
		professortable = new JTable(professorTableModel);
		setLayout(new BorderLayout());
		popupMenuOnStudentTable();
		add(new JScrollPane(professortable), BorderLayout.CENTER);
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
		professortable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = professortable.rowAtPoint(e.getPoint());
				professortable.getSelectionModel().setSelectionInterval(row, row);
				if (e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(professortable, e.getX(), e.getY());
				}
			}

		});
	}

	private void addActionListenerForEditItem(JMenuItem editItem) {
		editItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				int row = professortable.getSelectedRow();
				int cell = professortable.getSelectedColumn();
			}
		});
	}

	private void addActionListenerForRemoveItem(JMenuItem removeItem) {
		removeItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = professortable.getSelectedRow();
				if (personListener != null) {
					personListener.rowDeleted(row);
					refreshProfessorTable();
				}
			}
		});
	}

	public void setTableModelDataSource(List<ProfessorUI> professor) {
		professorTableModel.setprofessorList(professor);
	}

	public void refreshProfessorTable() {
		professorTableModel.fireTableDataChanged();
	}
	public void setPersonListener(PersonTableListener personListener) {
		this.personListener = personListener;
	}
}
