package com.course.dao;

import java.util.List;

import com.course.model.Course;

public interface ICourseDao {
	
//	boolean adminLogin(String adminId,String adminPassword);
//	boolean userlogin(String userId,String userPassword);
	
	
	void addCourse(Course course);
	Course findById(int courseId);
	void updateCourse(int courseId,double courseFee);
	void deleteCourse(int courseId);
	
	
	List<Course> findByCategory(String Category);
	
	List<Course> findByCategoryAndLessFee(String category,double courseFees);
	List<Course> findByCategoryAndFaculty(String category,String facultyName);
	List<Course> findByNameContaining(String name);
	List<Course> findByNameAndFaculty(String name,String faculty);
	

}
