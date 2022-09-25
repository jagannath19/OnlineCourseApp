package com.onlinecourse.util;

public class Quary {
	public static String addUserDetailsQuary="insert into login values (?,?)";
	public static String verifyUserDetailsQuary="select * from login where userId=? and userpassword=?";
	public static String createQuary="create table OnlineCourse (course_name varchar(20),course_id integer primary key auto_increment,"
			+ "faculty_name varchar(20), category varchar(20), timeduration integer, course_fee Double)";
	public static String addCourseQuary="insert into OnlineCourse (course_name,faculty_name,category,timeduration,course_fee) values(?,?,?,?,?)";
	public static String findCourseByIdQuary="";
	public static String updateCourseQuary="";
	public static String deleteCourseQuary="";
	public static String getCourseByCategory="";
	public static String getCourseByCategoryAndCourseFee="";
	public static String getCourseByCategoryAndFaculty="";

}
