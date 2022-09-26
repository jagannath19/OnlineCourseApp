package com.course.service;

import java.util.List;
import java.util.stream.Collectors;

import com.course.dao.CourseDaoImpl;
import com.course.dao.ICourseDao;
import com.course.model.Course;

public class CourseServiceImpl implements ICourseService {
	
	ICourseDao dao=new CourseDaoImpl();
	@Override
	public void addCourse(Course course) {
		dao.addCourse(course);
	}

	@Override
	public Course getById(int courseId) {
		
		return dao.findById(courseId);
	}

	@Override
	public void updateCourse(int courseId, double courseFee) {
		dao.updateCourse(courseId, courseFee);
		
	}

	@Override
	public void deleteCourse(int courseId) {
		dao.deleteCourse(courseId);
	}

	@Override
	public List<Course> getByCategory(String Category) {
			
		return dao.findByCategory(Category).stream()
				.sorted((name1,name2)->name1.getCourseName().compareTo(name2.getCourseName()))
						.collect(Collectors.toList());
						
	}

	@Override
	public List<Course> getByCategoryAndLessFee(String category, double courseFees) {
		
		return dao.findByCategoryAndLessFee(category, courseFees).stream().sorted((name1,name2)->name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Course> getByCategoryAndFaculty(String category, String facultyName) {
		
		return dao.findByCategoryAndFaculty(category, facultyName).stream().sorted((name1,name2)->name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Course> getByNameContaining(String name) {
		
		return dao.findByNameContaining(name).stream().sorted((name1,name2)->name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Course> getByNameAndFaculty(String name, String faculty) {
		return dao.findByNameAndFaculty(name, faculty).stream().sorted((name1,name2)->name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
	}
	
	

}
