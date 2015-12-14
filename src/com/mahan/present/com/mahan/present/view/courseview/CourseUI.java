package com.mahan.present.com.mahan.present.view.courseview;

public class CourseUI {
private String courseName;
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
private String course_No;
private String coursesProfessor;
CourseUI(String courseName,String coures_No, String courseProfessor){
	this.courseName = courseName;
	this.course_No = coures_No;
	this.coursesProfessor = courseProfessor;
}
public String getCourseName() {
	return courseName;
}
public String getCourse_No() {
	return course_No;
}
public String getCoursesProfessor() {
	return coursesProfessor;
}
}
