package com.course.service;

import java.util.List;
import java.util.stream.Collectors;

import com.course.dao.CourseDaoImpl;
import com.course.dao.ICourseDao;
import com.course.exception.CategoryNotFoundException;
import com.course.exception.CourseNotFoundException;
import com.course.model.Course;

public class CourseServiceImpl implements ICourseService {

	ICourseDao dao = new CourseDaoImpl();

	@Override
	public void addCourse(Course course) {
		dao.addCourse(course);
	}

	@Override
	public Course getById(int courseId) throws CourseNotFoundException {
		Course course = dao.findById(courseId);
		if (course != null)
			return course;
		else
			throw new CourseNotFoundException("Course not found");
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
	public List<Course> getByCategory(String Category) throws CategoryNotFoundException {
		List<Course> courseList = dao.findByCategory(Category).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList != null)
			return courseList;
		else
			throw new CategoryNotFoundException("Category not found");

	}

	@Override
	public List<Course> getByCategoryAndLessFee(String category, double courseFees) throws CourseNotFoundException {

		List<Course> courseList = dao.findByCategoryAndLessFee(category, courseFees).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList != null)
			return courseList;
		else
			throw new CourseNotFoundException("Course not found");
	}

	@Override
	public List<Course> getByCategoryAndFaculty(String category, String facultyName) throws CourseNotFoundException {

		List<Course> courseList = dao.findByCategoryAndFaculty(category, facultyName).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList != null)
			return courseList;
		else
			throw new CourseNotFoundException("Course not found");
	}

	@Override
	public List<Course> getByNameContaining(String name) throws CourseNotFoundException {

		List<Course> courseList = dao.findByNameContaining(name).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList != null)
			return courseList;
		else
			throw new CourseNotFoundException("Course not found");
	}

	@Override
	public List<Course> getByNameAndFaculty(String name, String faculty) throws CourseNotFoundException {
		List<Course> courseList = dao.findByNameAndFaculty(name, faculty).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList != null)
			return courseList;
		else
			throw new CourseNotFoundException("Course not found");
	}

}
