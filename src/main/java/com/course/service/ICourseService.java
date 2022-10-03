package com.course.service;

import java.util.List;

import com.course.model.Course;

public interface ICourseService {
	
	void addCourse(Course course);
	Course getById(int courseId);
	int updateCourse(int courseId,double courseFee);
	int deleteCourse(int courseId);
	List<Course> getAllCourse();
	
	
	List<Course> getByCategory(String Category);
	
	List<Course> getByCategoryAndLessFee(String category,double courseFees);
	List<Course> getByCategoryAndFaculty(String category,String facultyName);
	List<Course> getByNameContaining(String name);
	List<Course> getByNameAndFaculty(String name,String faculty);
}
