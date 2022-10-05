package com.course.service;

import java.util.List;
import java.util.stream.Collectors;

import com.course.dao.CourseDaoImpl;
import com.course.dao.ICourseDao;
import com.course.exception.CategoryNotFoundException;
import com.course.exception.CourseNotFoundException;
import com.course.exception.InvalidInputException;
import com.course.model.Course;

/**
 * @author JagannathSutar
 * This class methods calls the CourseDao class methods and handle exception if there
 */
public class CourseServiceImpl implements ICourseService {

	ICourseDao dao = new CourseDaoImpl();

	
	@Override
	public void addCourse(Course course) {
		dao.addCourse(course);
	}

	@Override
	public Course getById(int courseId) throws CourseNotFoundException {
		if (courseId <= 0)
			throw new InvalidInputException("Negative input can not accept");
		else {
			Course course = dao.findById(courseId);
			if (course == null)
				throw new CourseNotFoundException("Course not found");
			else
				return course;
		}
	}


	/**
	 * @param courseId
	 * @param courseFee
	 * @return integer
	 * @throws InvalidInputException
	 * this method use to call the dao package update couse
	 */
	@Override
	public int updateCourse(int courseId, double courseFee) throws InvalidInputException{
		if (courseId <= 0 || courseFee <= 0)
			throw new InvalidInputException("Negative input can not accept");
		else {
			int info = dao.updateCourse(courseId, courseFee);
			return info;
		}
	}

	/**
	 * @param courseId
	 * @return integer
	 * this method use to call the dao package delete course method and handle the exception
	 */
	@Override
	public int deleteCourse(int courseId) {
		if (courseId <= 0)
			throw new InvalidInputException("Negative input can not accept");
		else {
			int info = dao.deleteCourse(courseId);
			return info;
		}
	}

	/**
	 * @param Category
	 * @return List of course
	 * @throws CategoryNotFoundException
	 */
	@Override
	public List<Course> getByCategory(String Category) throws CategoryNotFoundException {
		List<Course> courseList = dao.findByCategory(Category).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList == null || courseList.isEmpty())
			throw new CourseNotFoundException("Course not found");
		else
			return courseList;

	}

	/**
	 * @param category
	 * @param courseFees
	 * @return list of course
	 * @throws CourseNotFoundException
	 */
	@Override
	public List<Course> getByCategoryAndLessFee(String category, double courseFees) throws CourseNotFoundException {

		List<Course> courseList = dao.findByCategoryAndLessFee(category, courseFees).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList == null || courseList.isEmpty())
			throw new CourseNotFoundException("Course not found");
		else
			return courseList;
	}

	/**
	 * @param category
	 * @param facultyName
	 * @return List of course
	 * @throws CourseNotFoundException
	 */
	@Override
	public List<Course> getByCategoryAndFaculty(String category, String facultyName) throws CourseNotFoundException {

		List<Course> courseList = dao.findByCategoryAndFaculty(category, facultyName).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList == null || courseList.isEmpty())
			throw new CourseNotFoundException("Course not found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByNameContaining(String name) throws CourseNotFoundException {

		List<Course> courseList = dao.findByNameContaining(name).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList == null || courseList.isEmpty())
			throw new CourseNotFoundException("Course not found");
		else
			return courseList;
	}

	@Override
	public List<Course> getByNameAndFaculty(String name, String faculty) throws CourseNotFoundException {
		List<Course> courseList = dao.findByNameAndFaculty(name, faculty).stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
		if (courseList == null || courseList.isEmpty())
			throw new CourseNotFoundException("Course not found");
		else
			return courseList;
	}

	/**
	 * @return sorted list of course
	 */
	@Override
	public List<Course> getAllCourse() {
		return dao.findAllCourse().stream()
				.sorted((name1, name2) -> name1.getCourseName().compareTo(name2.getCourseName()))
				.collect(Collectors.toList());
	}
	/**
	 * @param courseId
	 * @param username
	 * @return integer
	 * this  method use to buy a course
	 */
	@Override
	public int buyCourse(int courseId, String username) {
		
		return dao.buyCourse(courseId, username);
	}

}
