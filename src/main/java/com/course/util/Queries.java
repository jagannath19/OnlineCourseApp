package com.course.util;

public class Queries {
	public static final String createCourseQuery = "create table course(courseName varchar(20),"
			+ "courseId integer primary key auto_increment,facultyName varchar(30),"
			+ "mode varchar(7),category varchar(15),durationInDays integer,courseFee Double)";
	public static final String QueryaddCourse = "insert into course (courseName,facultyName,mode,"
			+ "category,durationInDays,courseFee) values(?,?,?,?,?,?)";
	public static final String QueryCourseById = "select * from course where courseId=?";
	public static final String QueryUpdate = "update course set courseFee=? where courseId=?";
	public static final String QueryDelete = "delete from course where courseId=?";
	public static final String QueryCourseByCategory = "select * from course where category=?";
	public static final String QueryCourseByCourseName = "select * from course where courseName=?";
	public static final String QueryCourseByCategoryAndFee = "select * from course where category=? and courseFee<=?";
	public static final String QueryCourseByCategoryAndFaculty = "select * from course where category=? and facultyName =?";
	public static final String QueryCourseByCourseNameAndFaculty = "select * from course where courseName=? and facultyName=?";
	public static final String QueryUserVerify = "select count(userid) from login where userename=? and userpassword=?";
	public static final String QueryAllCourses="select * from course";
	public static final String QueryAddUser="insert into user values(?,?,?,?,?,?)";
	public static final String QueryLogin="select * from user where username=? and password=?";
	public static final String QueryChangePassword="update user set password=? where username=?";
	public static final String QueryBuyCourse="update user set courseId=? where username=?";
	public static final String QueryOrderDetais="select u.name,u.mobile,u.email,c.courseName,c.facultyName,c.mode,c.category,"
			+ "c.durationInDays,c.courseFee from user u inner join course c on u.courseId=c.courseId where u.username=?";
}
