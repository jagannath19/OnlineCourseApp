package com.onlinecourse.service;

import java.util.List;

import com.onlinecourse.Dao.IOnlineCourseDao;
import com.onlinecourse.Dao.OnlineCourseDaoImpl;
import com.onlinecourse.model.OnlineCourse;

public class OnlineCourseServiceImpl implements IOnlineCourseService {
	
	IOnlineCourseDao dao=new OnlineCourseDaoImpl();
	public boolean adminLogin(String adminId, String adminPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean userlogin(String userId, String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addCourse(OnlineCourse course) {
		dao.addCourse(course);
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
