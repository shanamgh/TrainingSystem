package com.mahan.present.com.mahan.present.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
//import java.beans.Statement;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import javax.swing.*;

import com.mahan.connector.ConnectorLayer;
import com.mahan.present.PersonTableListener;
import com.mahan.present.ProfessorTablePanel;
import com.mahan.present.ToolBar;
import com.mahan.present.com.mahan.present.view.courseview.CourseFormPanel;
import com.mahan.present.com.mahan.present.view.courseview.CourseListener;
import com.mahan.present.com.mahan.present.view.courseview.CourseTablePanel;
import com.mahan.present.com.mahan.present.view.courseview.CourseUI;
import com.mahan.present.com.mahan.present.view.professorview.DataUtil;
import com.mahan.present.com.mahan.present.view.professorview.ProfessorFormPanel;
import com.mahan.present.com.mahan.present.view.professorview.ProfessorListener;
import com.mahan.present.com.mahan.present.view.professorview.ProfessorUI;
import com.mahan.present.com.mahan.present.view.studentview.StudentFormPanel;
import com.mahan.present.com.mahan.present.view.studentview.StudentTablePanel;
import com.mahan.present.com.mahan.present.view.studentview.StudentUI;
import com.mahan.present.com.mahan.present.view.studentview.IStudentListener;
import com.mahan.present.toolbarListener;

public class MainFrame extends JFrame {

	private JTabbedPane tab;
	private JSplitPane split;
	private List<StudentUI> studentArray;
	private List<CourseUI> courseArray;
	private List<ProfessorUI> professorArray;
	private StudentTablePanel StudenttablePanel;
	private StudentFormPanel studentForm;
	private CourseFormPanel courseForm;
	private CourseTablePanel courseTablePanel;
	private ProfessorFormPanel professorForm;
	private ProfessorTablePanel professorTablePanel;
	private ToolBar toolbar;
	private ConnectorLayer controler;

	public MainFrame() {
		tab = new JTabbedPane();
		toolbar = new ToolBar();
		controler = new ConnectorLayer();
		setTitle("Admin Environment");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		setJMenuBar(createMenu());
		createStudentTab();
		createCourseTab();
		createProfessorTab();
		setPersonTableListenerForDeleteItem();
		setToolbarListener();
	}

	private void setPersonTableListenerForDeleteItem() {
		StudenttablePanel.setPersonTableListener(new PersonTableListener() {

			@Override
			public void rowDeleted(int row) {
				studentArray.remove(row);
			}
		});

		courseTablePanel.setPersonListener(new PersonTableListener() {

			@Override
			public void rowDeleted(int row) {
				courseArray.remove(row);

			}
		});

		professorTablePanel.setPersonListener(new PersonTableListener() {

			@Override
			public void rowDeleted(int row) {
				professorArray.remove(row);
				courseForm.setDataUtilArray(professorArray);
			}
		});

	}

	private void setToolbarListener() {
		toolbar.setToolbarListener(new toolbarListener() {

			@Override
			public void saveEventOccured() {
				

				 try {
					controler.save(studentArray);
				} catch (SQLException e) {
					//JOptionPane.showConfirmDialog(arg0, arg1)
				}
				
			
				
			}

			@Override
			public void refreshEventOccured() {
				// TODO Auto-generated method stub

			}
		});
		add(toolbar, BorderLayout.PAGE_START);
	}

	private JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu colorMenu = new JMenu("color");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(colorMenu);
		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_E);
		colorMenu.setMnemonic(KeyEvent.VK_C);

		JMenuItem saveToDb = new JMenuItem("Save To DB");
		JMenuItem loadFromDB = new JMenuItem("load From DB");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(saveToDb);
		fileMenu.add(loadFromDB);
		fileMenu.add(exit);
		saveToDb.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		loadFromDB.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		saveToDb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Save To DB");
			}
		});
		loadFromDB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("load From DB");
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);

			}
		});

		JMenu preference = new JMenu("Preference");
		JMenuItem changePassword = new JMenuItem("Change Password");
		JMenuItem setDBData = new JMenuItem("Set DB Data");
		JMenuItem changeTheme = new JMenuItem("Change Theme");
		editMenu.add(preference);
		editMenu.add(changePassword);
		preference.add(setDBData);
		preference.add(changeTheme);

		JRadioButton defultButton = new JRadioButton("defult");
		JRadioButton redButton = new JRadioButton("Red");
		JRadioButton blueButton = new JRadioButton("Blue");
		JRadioButton greenButton = new JRadioButton("Green");
		ButtonGroup groupColor = new ButtonGroup();
		// groupColor.setSelected((ButtonModel) defultButton, true);;
		groupColor.add(defultButton);
		groupColor.add(redButton);
		groupColor.add(blueButton);
		groupColor.add(greenButton);
		colorMenu.add(defultButton);
		colorMenu.add(redButton);
		colorMenu.add(blueButton);
		colorMenu.add(greenButton);
		redButton.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				studentForm.setBackground(Color.red);
				professorForm.setBackground(Color.red);
				courseForm.setBackground(Color.red);
			}
		});

		blueButton.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				studentForm.setBackground(Color.blue);
				professorForm.setBackground(Color.blue);
				courseForm.setBackground(Color.blue);
			}
		});

		greenButton.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				studentForm.setBackground(Color.green);
				professorForm.setBackground(Color.green);
				courseForm.setBackground(Color.green);
			}
		});

		defultButton.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				studentForm.setBackground(Color.lightGray);
				professorForm.setBackground(Color.lightGray);
				courseForm.setBackground(Color.lightGray);
			}
		});

		return menuBar;
	}

	private void createProfessorTab() {
		professorForm = new ProfessorFormPanel();
		professorTablePanel = new ProfessorTablePanel();
		professorArray = new ArrayList<ProfessorUI>();
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, professorForm, professorTablePanel);
		split.setOneTouchExpandable(true);
		tab.add("Professor", split);
		add(tab, BorderLayout.CENTER);
		professorForm.setProfessor(new ProfessorListener() {

			@Override
			public void addProfessorObject(ProfessorUI professorObject) {
				professorArray.add(professorObject);
				professorTablePanel.setTableModelDataSource(professorArray);
				courseForm.setDataUtilArray(DataUtil.professorList);
				professorTablePanel.refreshProfessorTable();
			}
		});
		;
	}

	private void createCourseTab() {
		courseForm = new CourseFormPanel();
		courseTablePanel = new CourseTablePanel();
		courseArray = new ArrayList<CourseUI>();
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, courseForm, courseTablePanel);
		split.setOneTouchExpandable(true);
		tab.add("Course", split);
		add(tab, BorderLayout.CENTER);
		courseForm.setCourse(new CourseListener() {

			@Override
			public void addCourseObject(CourseUI courseObject) {
				courseArray.add(courseObject);
				courseTablePanel.setTableModelDataSource(courseArray);
				courseTablePanel.refreshCourseTable();

			}
		});
	}

	private void createStudentTab() {
		studentForm = new StudentFormPanel();
		StudenttablePanel = new StudentTablePanel();
		studentArray = new ArrayList<>();
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, studentForm, StudenttablePanel);
		split.setOneTouchExpandable(true);
		tab.add("student", split);
		add(tab, BorderLayout.CENTER);
		studentForm.setIStudentListener(new IStudentListener() {

			@Override
			public void addStudentObject(StudentUI studentObject) {
				studentArray.add(studentObject);
				StudenttablePanel.setTableModelDataSource(studentArray);
				StudenttablePanel.refreshStudentTable();

			}
		});
	}

}
