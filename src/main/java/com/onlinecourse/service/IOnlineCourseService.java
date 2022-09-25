package com.onlinecourse.service;

import java.util.List;

import com.onlinecourse.model.OnlineCourse;

public interface IOnlineCourseService {
	boolean adminLogin(String adminId,String adminPassword);
	boolean userlogin(String userId,String userPassword);
	
	
	void addCourse(OnlineCourse course);
	OnlineCourse findCourseByCourseId(int courseId);
	void updateCourse(int courseId,double courseFee);
	void deleteCourse(int courseId);
	
	
	List<OnlineCourse> getCourseByCategory(String Category);
	List<OnlineCourse> getCourseByCategoryAndCourseFee(String category,double courseFees);
	List<OnlineCourse> getCourseByCategoryAndFaculty(String category,String facultyName);
}
