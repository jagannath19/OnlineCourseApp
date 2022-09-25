package com.onlinecourse.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.onlinecourse.model.OnlineCourse;
import com.onlinecourse.util.DbConnection;
import com.onlinecourse.util.Quary;

public class OnlineCourseDaoImpl implements IOnlineCourseDao {
	DbConnection dbConnection=new DbConnection();
	Connection connection;
	PreparedStatement ps=null;
	ResultSet loginRs=null;
	public boolean adminLogin(String adminId, String adminPassword) {
		try {
			connection=dbConnection.getConnection();
			ps=connection.prepareStatement(Quary.verifyUserDetailsQuary);
			ps.setString(1, adminId);
			ps.setString(2, adminPassword);
			loginRs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbConnection.closeConnection();
			
		}
		if(loginRs==null)
			return false;
		else
			return true;
		
	}

	public boolean userlogin(String userId, String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addCourse(OnlineCourse course) {
		
		try {
			connection = dbConnection.getConnection();
			ps=connection.prepareStatement(Quary.addCourseQuary);
			ps.setString(1, course.getCourseName());
			ps.setString(2, course.getFaculty());
			ps.setString(3, course.getCategory());
			ps.setInt(4, course.getTimeduration());
			ps.setDouble(5, course.getPrice());
			boolean created=ps.execute();
			if(created==false)
				System.out.println("course added");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbConnection.closeConnection();
		}
	}

	public OnlineCourse findCourseByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateCourse(int courseId, double courseFee) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

	public List<OnlineCourse> getCourseByCategory(String Category) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OnlineCourse> getCourseByCategoryAndCourseFee(String category, double courseFees) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OnlineCourse> getCourseByCategoryAndFaculty(String category, String facultyName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	


}
