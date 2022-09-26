package com.course.util;

public class Queries {
	public static String createQuery="create table course(courseName varchar(20),courseId integer primary key auto_increment,facultyName varchar(30),"
			+ "mode varchar(7),category varchar(15),durationInDays integer,courseFee Double)";
	public static String QueryaddCourse="insert into course (courseName,facultyName,mode,category,durationInDays,courseFee) values(?,?,?,?,?,?)";
	public static String QueryCourseById="select * from course where courseId=?";
	public static String QueryUpdate="update course set courseFee=? where courseId=?";
	public static String QueryDelete="delete from course where courseId=?";
	public static String QueryCourseByCategory="select * from course where category=?";
	public static String QueryCourseByCourseName="select * from course where courseName=?";
	public static String QueryCourseByCategoryAndFee="select * from course where category=? and courseFee<=?";
	public static String QueryCourseByCategoryAndFaculty="select * from course where category=? and facultyName =?";
	public static String QueryCourseByCourseNameAndFaculty="select * from course where courseName=? and facultyName=?";

}
