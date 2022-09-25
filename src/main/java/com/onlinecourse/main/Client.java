package com.onlinecourse.main;

import java.util.Scanner;

import com.onlinecourse.model.OnlineCourse;
import com.onlinecourse.service.IOnlineCourseService;
import com.onlinecourse.service.OnlineCourseServiceImpl;
import com.onlinecourse.util.DbConnection;

public class Client {

	public static void main(String[] args) {
		IOnlineCourseService courseService=new OnlineCourseServiceImpl();
		System.out.println("Welcome to MYDEMY application");
		System.out.println("Login page");
//		DbConnection db=new DbConnection();
//		db.getConnection();
//		db.closeConnection();
		Scanner scn=new Scanner(System.in);
		String courseName=scn.nextLine();
		String faculty=scn.nextLine();
		String category=scn.nextLine();
		int timeduration=scn.nextInt();
		double price=scn.nextDouble();
		courseService.addCourse(new OnlineCourse(courseName, faculty, category, timeduration, price));
//		System.out.println("press 1 for Admin login \npress 2 for user Login");
		/*int loginChoice=scn.nextInt();
		scn.nextLine();
		IOnlineCourseService courseService=new OnlineCourseServiceImpl();
		
		
		switch(loginChoice) {
		case 1:
			System.out.println("Enter your user id");
			String adminUserId=scn.nextLine();
			System.out.println("Enter your password");
			String adminPassword=scn.nextLine();
			
			if(courseService.adminLogin(adminUserId, adminPassword)==true) {
				System.out.println("Welcome Admin;-"+adminUserId);}
				else
					System.out.println("Wrong uid or password");*/
				
				
				
				
				
			}
		}
	


