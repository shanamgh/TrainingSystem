package com.mahan.present.com.mahan.present.view.studentview;

import com.mahan.present.StudentType;

public class StudentUI {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String studentNo;
	private String phoneNumber;
	private String emailAddress;
	private String address;
	private StudentType stdType;
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public StudentUI(String firstName, String lastName, String username, String password, String studentNo, String phoneNumber, String emailAddress, String address , StudentType std) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.studentNo = studentNo;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.stdType = std;
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

	public String getStudentNo() {
		return studentNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getAddress() {
		return address;
	}
}
