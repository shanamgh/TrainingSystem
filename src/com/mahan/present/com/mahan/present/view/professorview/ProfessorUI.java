package com.mahan.present.com.mahan.present.view.professorview;

public class ProfessorUI {
	private String firstName;
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	private String lastName;
	private String username;
	@Override
	public String toString() {
		return firstName;
	}

	private String password;
	private String professorNo;


	public ProfessorUI(String firstName, String lastName, String username, String password, String professorNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.professorNo = professorNo;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getProfessorNo() {
		return professorNo;
	}

}
