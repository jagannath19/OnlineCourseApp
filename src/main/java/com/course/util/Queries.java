package com.course.util;

public class Queries {
	public static final String createQuery = "create table course(courseName varchar(20),courseId integer primary key auto_increment,facultyName varchar(30),"
			+ "mode varchar(7),category varchar(15),durationInDays integer,courseFee Double)";
	public static final String QueryaddCourse = "insert into course (courseName,facultyName,mode,category,durationInDays,courseFee) values(?,?,?,?,?,?)";
	public static final String QueryCourseById = "select * from course where courseId=?";
	public static final String QueryUpdate = "update course set courseFee=? where courseId=?";
	public static final String QueryDelete = "delete from course where courseId=?";
	public static final String QueryCourseByCategory = "select * from course where category=?";
	public static final String QueryCourseByCourseName = "select * from course where courseName=?";
	public static final String QueryCourseByCategoryAndFee = "select * from course where category=? and courseFee<=?";
	public static final String QueryCourseByCategoryAndFaculty = "select * from course where category=? and facultyName =?";
	public static final String QueryCourseByCourseNameAndFaculty = "select * from course where courseName=? and facultyName=?";
	public static final String QueryUserVerify = "select count(userid) from login where userename=? and userpassword=?";
}
