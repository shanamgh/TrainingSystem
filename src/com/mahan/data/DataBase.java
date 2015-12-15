package com.mahan.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mahan.present.com.mahan.present.view.studentview.StudentUI;

public class DataBase {
	public Connection con;
	Statement stmt = null;

	public void save(List<StudentUI> studentArray) throws SQLException {
		connect();

		// TODO Save
		for (int i=0; i<studentArray.size();i++){
		stmt = con.createStatement();

		String firstName = studentArray.get(i).getFirstName();
		String lastName = studentArray.get(i).getLastName();
		String studentNo = studentArray.get(i).getStudentNo();
		String address = studentArray.get(i).getAddress();
		String emailAddress = studentArray.get(i).getEmailAddress();
		String phoneNumber = studentArray.get(i).getPhoneNumber();
		String sql = "INSERT INTO [JavaTraining].[dbo].[M1.Student]  "
				+ "VALUES ('"+ (i+1) +"' ,'" + firstName + "','" + lastName + "', '"
				+ studentNo + "', '" + address + "','" + 
				emailAddress + "','" + phoneNumber + "')";
		stmt.executeUpdate(sql);
		}

		disconnect();
	}

	public boolean connect() throws SQLException {
		if (con != null) {
			return true;
		}

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		}
		String connectionURL = "jdbc:sqlserver://swsql.mahanair.aero;user=sa;password=123;database=javaTraining";
		con = DriverManager.getConnection(connectionURL);
		System.out.println("Connected");

		if (con == null) {
			return false;
		}
		return true;
	}

	public void disconnect() {
		if (con != null) {
			try {
				con.close();
				System.out.println("Disconnected");
			} catch (SQLException e) {
				System.out.println("Could not disconect");
			}
		}
	}

	public static void main(String[] args) {
		DataBase db = new DataBase();
		try {
			db.save(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.disconnect();
		//This is Comment
	}

}
