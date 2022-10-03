package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.course.model.Course;
import com.course.util.DbConnection;
import com.course.util.Queries;

public class CourseDaoImpl implements ICourseDao {
	
	/**
	 *@author JagannathSutar
	 *@param coure
	 *This method allows the admin to add a new course
	 */

	@Override
	public void addCourse(Course course) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Queries.QueryaddCourse);
			statement.setString(1, course.getCourseName());
			statement.setString(2, course.getFacultyName());
			statement.setString(3, course.getMode());
			statement.setString(4, course.getCategory());
			statement.setInt(5, course.getDurationInDays());
			statement.setDouble(6, course.getCourseFee());
			boolean val = statement.execute();
			if (!val)
				System.out.println("course added successful");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			DbConnection.closeConnection();
		}
	}
	
	/**
	 * @author JagannathSutar
	 * @param courseId
	 * This method allows admin to find course  by courseId
	 */

	@Override
	public Course findById(int courseId) {
		Connection connection = DbConnection.openConnection();
		PreparedStatement statement = null;
		Course course = null;
		try {
			statement = connection.prepareStatement(Queries.QueryCourseById);
			statement.setInt(1, courseId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				course = new Course();
				course.setCourseName(resultset.getString(1));
				course.setCourseId(resultset.getInt(2));
				course.setFacultyName(resultset.getString(3));
				course.setMode(resultset.getString(4));
				course.setCategory(resultset.getString(5));
				course.setDurationInDays(resultset.getInt(6));
				course.setCourseFee(resultset.getDouble(7));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DbConnection.closeConnection();
		}
		return course;

		
	}
	
	/**
	 * @author JagannathSutar
	 * @param courseId
	 * @param courseFee
	 * This method allow the admin to update price in a course
	 */

	@Override
	public int updateCourse(int courseId, double courseFee) {
		Connection connection = null;
		PreparedStatement statement = null;
		int output=0;
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryUpdate);
			statement.setDouble(1, courseFee);
			statement.setInt(2, courseId);
			 output = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			DbConnection.closeConnection();
		}
		return output;
	}

	/**
	 * @author JagannathSutar
	 * This method allows the user to delete a course by admin
	 */
	@Override
	public int deleteCourse(int courseId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int output=0;
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryDelete);
			statement.setInt(1, courseId);
			output = statement.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			DbConnection.closeConnection();
		}
		return output;

	}

	/**
	 * @author JagannathSutar
	 * This method helps user to filter course by category
	 */
	@Override
	public List<Course> findByCategory(String Category) {
		Connection connection = null;
		PreparedStatement statement = null;
		Course course;
		List<Course> courses = new ArrayList<Course>();
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryCourseByCategory);
			statement.setString(1, Category);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				course = new Course();
				course.setCourseName(resultset.getString(1));
				course.setCourseId(resultset.getInt(2));
				course.setFacultyName(resultset.getString(3));
				course.setMode(resultset.getString(4));
				course.setCategory(resultset.getString(5));
				course.setDurationInDays(resultset.getInt(6));
				course.setCourseFee(resultset.getDouble(7));
				courses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbConnection.closeConnection();
		}

		return courses;
	}
	
	/**
	 * @author JagannathSutar
	 * This method helps user to filter courses by category and courseFee
	 */
	@Override
	public List<Course> findByCategoryAndLessFee(String category, double courseFees) {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Course> courses = new ArrayList<>();
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryCourseByCategoryAndFee);
			statement.setString(1, category);
			statement.setDouble(2, courseFees);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Course course = new Course();
				course.setCourseName(resultset.getString(1));
				course.setCourseId(resultset.getInt(2));
				course.setFacultyName(resultset.getString(3));
				course.setMode(resultset.getString(4));
				course.setCategory(resultset.getString(5));
				course.setDurationInDays(resultset.getInt(6));
				course.setCourseFee(resultset.getDouble(7));
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DbConnection.closeConnection();
		}

		return courses;
	}
	
	/**
	 * @param category
	 * @param facultyName
	 * This method helps user to filter courses by category and faculty name
	 */

	@Override
	public List<Course> findByCategoryAndFaculty(String category, String facultyName) {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Course> courses = new ArrayList<>();
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryCourseByCategoryAndFaculty);
			statement.setString(1, category);
			statement.setString(2, facultyName);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Course course = new Course();
				course.setCourseName(resultset.getString(1));
				course.setCourseId(resultset.getInt(2));
				course.setFacultyName(resultset.getString(3));
				course.setMode(resultset.getString(4));
				course.setCategory(resultset.getString(5));
				course.setDurationInDays(resultset.getInt(6));
				course.setCourseFee(resultset.getDouble(7));
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DbConnection.closeConnection();
		}

		return courses;
	}

	/**
	 * @author JagannathSutar
	 * @param name
	 * This method helps user to find course by course name
	 */
	@Override
	public List<Course> findByNameContaining(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Course> courses = new ArrayList<>();
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryCourseByCourseName);
			statement.setString(1, name);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Course course = new Course();
				course.setCourseName(resultset.getString(1));
				course.setCourseId(resultset.getInt(2));
				course.setFacultyName(resultset.getString(3));
				course.setMode(resultset.getString(4));
				course.setCategory(resultset.getString(5));
				course.setDurationInDays(resultset.getInt(6));
				course.setCourseFee(resultset.getDouble(7));
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbConnection.closeConnection();
		}
		return courses;
	}
	
	/**
	 * @author JagannathSutar
	 * @param name
	 * @param faculty
	 * This method helps user to find course by course name and faculty name
	 */

	@Override
	public List<Course> findByNameAndFaculty(String name, String faculty) {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Course> courses = new ArrayList<>();
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryCourseByCourseNameAndFaculty);
			statement.setString(1, name);
			statement.setString(2, faculty);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Course course = new Course();
				course.setCourseName(resultset.getString(1));
				course.setCourseId(resultset.getInt(2));
				course.setFacultyName(resultset.getString(3));
				course.setMode(resultset.getString(4));
				course.setCategory(resultset.getString(5));
				course.setDurationInDays(resultset.getInt(6));
				course.setCourseFee(resultset.getDouble(7));
				courses.add(course);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbConnection.closeConnection();
		}

		return courses;
	}
	
	/**
	 * @author JagannathSutar
	 * This method show all the courses in the app
	 */

	@Override
	public List<Course> findAllCourse() {
		
		Connection connection = null;
		PreparedStatement statement = null;
		List<Course> courses = new ArrayList<>();
		try {
			connection = DbConnection.openConnection();
			statement = connection.prepareStatement(Queries.QueryAllCourses);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Course course = new Course();
				course.setCourseName(resultset.getString(1));
				course.setCourseId(resultset.getInt(2));
				course.setFacultyName(resultset.getString(3));
				course.setMode(resultset.getString(4));
				course.setCategory(resultset.getString(5));
				course.setDurationInDays(resultset.getInt(6));
				course.setCourseFee(resultset.getDouble(7));
				courses.add(course);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbConnection.closeConnection();
		}

		return courses;
	}

	

}
