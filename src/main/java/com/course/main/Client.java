package com.course.main;

import java.util.Scanner;

import com.course.model.Categories;
import com.course.model.Course;
import com.course.model.Mode;
import com.course.model.User;
import com.course.service.CourseServiceImpl;
import com.course.service.ICourseService;
import com.course.service.IUserService;
import com.course.service.UserService;
import com.mysql.cj.exceptions.PasswordExpiredException;

/**
 * @author JagannathSutar
 *  This is the main class of this application
 *  
 */
public class Client {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		ICourseService service = new CourseServiceImpl();
		IUserService userService = new UserService();
		System.out.println("Welcome to Education Application");
		/*
		 * DbConnection database=new DbConnection(); database.getConnection();
		 * database.closeConnection();
		 */

		System.out.println("Press 1 for Admin \nPress 2 for Existing user \nPress 3 for new user");
		int userNeed = scn.nextInt();
		scn.nextLine();
		switch (userNeed) {
		case 1:
			System.out.println("Admin id-");
			String adminId = scn.nextLine();
			System.out.println("Admin password-");
			String adminPassword = scn.nextLine();
			User admin = userService.login(adminId, adminPassword);
			if (admin == null) {

				scn.close();
				throw new PasswordExpiredException("Invalid AdminId or password");
			} else {
				boolean flag = false;
				do {

					System.out.println(
							"Press 1 for Add a new Course \nPress 2 for find course by id \nPress 3 for update course price \n"
									+ "Press 4 for delete course \nPress 5 for all courses");
					int adminChoice = scn.nextInt();
					scn.nextLine();
					String category;
					String mode;
					double courseFee;

					switch (adminChoice) {
					case 1: /* Add a Course */
						System.out.println("Course name -");
						String courseName = scn.nextLine();
						System.out.println("Faculty name-");
						String facultyName = scn.nextLine();
						System.out.println("Mode \npress 1 for Online\npress 2 for Offline");
						int modeInput = scn.nextInt();
						scn.nextLine();
						mode = Mode.values()[modeInput - 1].toString();
						System.out.println(
								"Choose category from below\n1-UPSC\r\n" + "2-JEE,\r\n" + "3-SSC,\r\n" + "4-NET,\r\n"
										+ "5-CAT,\r\n" + "6-DEVELOPER,\r\n" + "7-TESTING,\r\n" + "8-AGRICULTURE;");
						int catInput = scn.nextInt();
						scn.nextLine();
						category = Categories.values()[catInput - 1].toString();

						System.out.println("Duration in days");
						int durationInDays = scn.nextInt();
						System.out.println("Course fees");
						courseFee = scn.nextDouble();
						Course course = new Course(courseName, facultyName, mode, category, durationInDays, courseFee);

						service.addCourse(course);
						break;
					case 2: /* Course by id */
						System.out.println("Enter the course Id");
						int courseId = scn.nextInt();
						System.out.println(service.getById(courseId));
						break;
					case 3: /* Update the course fee */
						System.out.println("Course Id-");
						int updateCourseId = scn.nextInt();
						System.out.println("New fee for update-");
						double updateFee = scn.nextDouble();
						if (service.updateCourse(updateCourseId, updateFee) == 1)
							System.out.println("Updated");
						else
							System.out.println("Wrong Id");
						break;
					case 4: /* Delete the course */
						System.out.println("Enter the course Id");
						int deleteCourseId = scn.nextInt();
						if (service.deleteCourse(deleteCourseId) == 1)
							System.out.println("Course deleted");
						else
							System.out.println("Invalid ID");
						break;
					case 5:
						for (Course courses : service.getAllCourse()) {
							System.out.println(courses);
						}
						break;
					default:
						System.out.println("Invalid Input");
						break;

					}
					System.out.println("0-continue\n1-Exit");
					int ch = scn.nextInt();
					if (ch == 0)
						flag = true;
					else
						flag = false;
				} while (flag);
				break;
			}
		case 2:

			/* existing user */
			System.out.println("Username-");
			String username = scn.nextLine();
			System.out.println("password-");
			String password = scn.nextLine();
			User user = userService.login(username, password);
			if (user == null) {
				scn.close();
				throw new PasswordExpiredException("Invalid user id or password");
			} else {
				System.out.println("Welcome user-" + user.getName());
				username = user.getUsername();

				boolean flag = false;
				do {

					System.out.println("1-filter course by category\n2-filter course by category and course fee"
							+ "\n3-filter course by category and faculty\n4-filter course by course name\n"
							+ "5-Filter course by course name and faculty \n6-See your courses \n7-Change password");
					int customerChoice = scn.nextInt();
					scn.nextLine();
					switch (customerChoice) {
					case 1: /* Course by Category */
						System.out.println(
								"Choose category from below\n1-UPSC\r\n" + "2-JEE,\r\n" + "3-SSC,\r\n" + "4-NET,\r\n"
										+ "5-CAT,\r\n" + "6-DEVELOPER,\r\n" + "7-TESTING,\r\n" + "8-AGRICULTURE;");
						int catInput = scn.nextInt();
						scn.nextLine();
						String category = Categories.values()[catInput - 1].toString();
						for (Course course : service.getByCategory(category)) {
							System.out.println(course);
						}
						System.out.println("Choose the courseId, you want to purchase");
						int courseId = scn.nextInt();
						if (service.buyCourse(courseId, username) == 1) {
							System.out.println(userService.orderDetails(username));
							System.out.println("Thank you for Purchase the course");
						}
						break;
					case 2: /* course by category and course fee */
						System.out.println(
								"Choose category from below\n1-UPSC\r\n" + "2-JEE,\r\n" + "3-SSC,\r\n" + "4-NET,\r\n"
										+ "5-CAT,\r\n" + "6-DEVELOPER,\r\n" + "7-TESTING,\r\n" + "8-AGRICULTURE;");
						catInput = scn.nextInt();
						scn.nextLine();
						category = Categories.values()[catInput - 1].toString();
						System.out.println("Course fee");
						double courseFee = scn.nextDouble();
						for (Course course : service.getByCategoryAndLessFee(category.toUpperCase(), courseFee)) {
							System.out.println(course);
						}
						System.out.println("Choose the courseId, you want to purchase");
						courseId = scn.nextInt();
						if (service.buyCourse(courseId, username) == 1) {
							System.out.println(userService.orderDetails(username));
							System.out.println("Thank you for Purchase the course");
						}
						break;
					case 3: /* courses by category and faculty */
						System.out.println(
								"Choose category from below\n1-UPSC\r\n" + "2-JEE,\r\n" + "3-SSC,\r\n" + "4-NET,\r\n"
										+ "5-CAT,\r\n" + "6-DEVELOPER,\r\n" + "7-TESTING,\r\n" + "8-AGRICULTURE;");
						catInput = scn.nextInt();
						scn.nextLine();
						category = Categories.values()[catInput - 1].toString();
						System.out.println("Faculty name-");
						String faculty = scn.nextLine();
						for (Course course : service.getByCategoryAndFaculty(category, faculty)) {
							System.out.println(course);
						}
						System.out.println("Choose the courseId, you want to purchase");
						courseId = scn.nextInt();
						if (service.buyCourse(courseId, username) == 1) {
							System.out.println(userService.orderDetails(username));
							System.out.println("Thank you for Purchase the course");
						}

						break;
					case 4: /* course by course name */
						System.out.println("Course name-");
						String courseName = scn.nextLine();
						for (Course course : service.getByNameContaining(courseName.toLowerCase())) {
							System.out.println(course);
						}
						System.out.println("Choose the courseId, you want to purchase");
						courseId = scn.nextInt();
						if (service.buyCourse(courseId, username) == 1) {
							System.out.println(userService.orderDetails(username));
							System.out.println("Thank you for Purchase the course");
						}
						break;
					case 5: /* courses by course name and faculty name */
						System.out.println("Course name-");
						courseName = scn.nextLine();
						System.out.println("Faculty name-");
						String facultyName = scn.nextLine();
						for (Course course : service.getByNameAndFaculty(courseName, facultyName)) {
							System.out.println(course);
						}
						System.out.println("Choose the courseId, you want to purchase");
						courseId = scn.nextInt();
						if (service.buyCourse(courseId, username) == 1) {
							System.out.println(userService.orderDetails(username));
							System.out.println("Thank you for Purchase the course");
						}
						break;

					case 6: /* user purchase course */

						System.out.println(userService.orderDetails(username));
						break;

					case 7: /* change password */
						System.out.println("New 8 digit password");
						password = scn.nextLine();
						if (userService.changePassword(username, password) == 1)
							System.out.println("Password changed");
						else
							System.out.println("Something wrong");
						break;
					default:
						System.out.println("Invalid input");
						break;
					}
					System.out.println("0-continue\n1-Exit");
					int ch = scn.nextInt();
					if (ch == 0)
						flag = true;
					else
						flag = false;
				} while (flag);
				break;
			}
		case 3:
			System.out.println("Unique username-");
			String userName = scn.nextLine();
			System.out.println("Name-");
			String name = scn.nextLine();
			System.out.println("mobile no-");
			long mobile = scn.nextLong();
			scn.nextLine();
			System.out.println("Email-");
			String email = scn.nextLine();
			user = new User(userName, name, mobile, email);
			System.out.println(userService.addUser(user));
			break;

		default:
			System.out.println("Invalid input");
			break;
		}

		System.out.println();
		System.out.println("Tankyou for visit us");
		scn.close();
	}
}
