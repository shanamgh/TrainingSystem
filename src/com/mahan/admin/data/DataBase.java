package com.mahan.admin.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mahan.admin.present.com.mahan.present.model.CourseUI;
import com.mahan.admin.present.com.mahan.present.model.ProfessorUI;
import com.mahan.admin.present.com.mahan.present.model.StudentUI;

public class DataBase {
    public Connection con;
    PreparedStatement stm = null;

    public List<StudentUI> loadStudentDataFromDB() throws SQLException {
        connect();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from [JavaTraining].[dbo].[M1.Student]");
        ArrayList<StudentUI> std = new ArrayList<>() ;
        while (rs.next()){
            StudentUI students = new StudentUI();
            students.setStudentNo(rs.getInt("StudentNo"));
            students.setAddress(rs.getString("Address"));
            students.setEmailAddress(rs.getString("Email"));
            students.setUsername(rs.getString("Username"));
            students.setPassword(rs.getString("Password"));
            students.setFirstName(rs.getString("Name"));
            students.setLastName(rs.getString("Family"));
            students.setPhoneNumber(rs.getString("Phone"));
            std.add(students);
        }
        return std;
    }
    public void saveStudent(List<StudentUI> studentArray) throws SQLException {
        System.out.println(studentArray.size());
        connect();
        String insertQuery = "INSERT INTO [JavaTraining].[dbo].[M1.Student] VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement insertStm = con.prepareStatement(insertQuery);

//        String selectQuery = "select count(*) as count from [JavaTraining].[dbo].[M1.Student] where StudentNo=?";
//        PreparedStatement selectStm = con.prepareStatement(selectQuery);

        String UpdateQuery = "update [JavaTraining].[dbo].[M3.Student] set Name=?,Family=?,StudentNo=?,Address=?,Email=?,Phone=?,Username=?,Password=?";
        PreparedStatement updateStm = con.prepareStatement(UpdateQuery);

        for (StudentUI student : studentArray) {
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            int studentNo = student.getStudentNo();
            String address = student.getAddress();
            String emailAddress = student.getEmailAddress();
            String phoneNumber = student.getPhoneNumber();
            String username = student.getUsername();
            String password = student.getPassword();

//            selectStm.setInt(1, studentNo);
//            ResultSet result = selectStm.executeQuery();
//            result.next();
//            int count = result.getInt("count");
//            result.close();
        //   if (count == 0) {
                insertStm.setInt(1, studentNo);
                insertStm.setString(2, address);
                insertStm.setString(3, emailAddress);
                insertStm.setString(4, username);
                insertStm.setString(5, password);
                insertStm.setString(6, firstName);
                insertStm.setString(7, lastName);
                insertStm.setString(8, phoneNumber);
                insertStm.executeUpdate();
        //    }
//            else{
//                updateStm.setInt(1, studentNo);
//                updateStm.setString(2, address);
//                updateStm.setString(3, emailAddress);
//                updateStm.setString(4, username);
//                updateStm.setString(5, password);
//                updateStm.setString(6, firstName);
//                updateStm.setString(7, lastName);
//                updateStm.setString(8, phoneNumber);
//                updateStm.executeUpdate();
//            }
        }
        //	disconnect();
    }

    public void saveProfessor(List<ProfessorUI> professorArray) throws SQLException {
        connect();
        // TODO Save
        for (int i = 0; i < professorArray.size(); i++) {

            String firstName = professorArray.get(i).getFirstName();
            String lastName = professorArray.get(i).getLastName();
            int professorNo = professorArray.get(i).getProfessorNo();
            String username = professorArray.get(i).getUsername();
            String password = professorArray.get(i).getPassword();
            String query = "INSERT INTO [JavaTraining].[dbo].[M1.Professor] VALUES (?,?,?,?,?)";
            stm = con.prepareStatement(query);
            stm.setString(1, firstName);
            stm.setString(2, lastName);
            stm.setInt(3, professorNo);
            stm.setString(4, username);
            stm.setString(5, password);
            stm.executeUpdate();
        }
        //	disconnect();
    }

    public void saveCourse(List<CourseUI> courseArray) throws SQLException {
        connect();
        // TODO Save
        for (int i = 0; i < courseArray.size(); i++) {
            String courseName = courseArray.get(i).getCourseName();
            int courseNo = courseArray.get(i).getCourse_No();
            String professor = courseArray.get(i).getCoursesProfessor();
            boolean isSaved = courseArray.get(i).getisSaved();

            String query = "INSERT INTO [JavaTraining].[dbo].[M1.Course] VALUES (?,?,?,?)";
            stm = con.prepareStatement(query);
            stm.setString(1, courseName);
            stm.setInt(2, courseNo);
            stm.setString(3, professor);
            stm.setBoolean(4, isSaved);
            stm.executeUpdate();
            courseArray.get(i).setIsSaved(true);
        }
        //	disconnect();
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


}
