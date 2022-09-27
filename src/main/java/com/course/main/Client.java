package com.course.main;

import java.util.Scanner;

import com.course.model.Categories;
import com.course.model.Course;
import com.course.model.Mode;
import com.course.service.CourseServiceImpl;
import com.course.service.ICourseService;

public class Client {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		ICourseService service = new CourseServiceImpl();
		System.out.println("Welcome to Education Application");
		/*
		 * DbConnection database=new DbConnection(); database.getConnection();
		 * database.closeConnection();
		 */

		boolean flag = false;
		do {
			System.out.println("Press 1 for Admin \nPress 2 for user");
			int userType = scn.nextInt();
			scn.nextLine();
			switch (userType) {
			case 1:

				System.out.println(
						"Press 1 for Add a new Course \nPress 2 for find course by id \nPress 3 for update course price \nPress 4 for delete course");
				int adminChoice = scn.nextInt();
				scn.nextLine();
				String category;
				String mode;
				double courseFee;

				switch (adminChoice) {
				case 1:
					System.out.println("Course name -");
					String courseName = scn.nextLine();
					System.out.println("Faculty name-");
					String facultyName = scn.nextLine();
					System.out.println("Mode \npress 1 for Online\npress 2 for Offline");
					int modeInput = scn.nextInt();
					scn.nextLine();
					mode = Mode.values()[modeInput - 1].toString();
					System.out.println("Choose category from below\n1-UPSC\r\n" + "2-JEE,\r\n" + "3-SSC,\r\n"
							+ "4-NET,\r\n" + "5-CAT,\r\n" + "6-DEVELOPER,\r\n" + "7-TESTING,\r\n" + "8-AGRICULTURE;");
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
				case 2:
					System.out.println("Enter the course Id");
					int courseId = scn.nextInt();
					System.out.println(service.getById(courseId));
					break;
				case 3:
					System.out.println("Course Id-");
					int updateCourseId = scn.nextInt();
					System.out.println("New fee for update-");
					double updateFee = scn.nextDouble();
					service.updateCourse(updateCourseId, updateFee);
					break;
				case 4:
					System.out.println("Enter the course Id");
					int deleteCourseId = scn.nextInt();
					service.deleteCourse(deleteCourseId);
					break;
				default:
					System.out.println("Invalid Input");
					break;

				}
				break;
//			System.exit(0);
			case 2:
				System.out.println("1-filter course by category\n2-filter course by category and course fee"
						+ "\n3-filter course by category and faculty\n4-filter course by course name\n"
						+ "5-Filter course by course name and faculty");
				int customerChoice = scn.nextInt();
				scn.nextLine();
				switch (customerChoice) {
				case 1:
					System.out.println("Choose category from below\n1-UPSC\r\n" + "2-JEE,\r\n" + "3-SSC,\r\n"
							+ "4-NET,\r\n" + "5-CAT,\r\n" + "6-DEVELOPER,\r\n" + "7-TESTING,\r\n" + "8-AGRICULTURE;");
					int catInput = scn.nextInt();
					scn.nextLine();
					category = Categories.values()[catInput - 1].toString();
					for (Course course : service.getByCategory(category)) {
						System.out.println(course);
					}
					break;
				case 2:
					System.out.println("Choose category from below\n1-UPSC\r\n" + "2-JEE,\r\n" + "3-SSC,\r\n"
							+ "4-NET,\r\n" + "5-CAT,\r\n" + "6-DEVELOPER,\r\n" + "7-TESTING,\r\n" + "8-AGRICULTURE;");
					catInput = scn.nextInt();
					scn.nextLine();
					category = Categories.values()[catInput - 1].toString();
					System.out.println("Course fee");
					courseFee = scn.nextDouble();
					for (Course course : service.getByCategoryAndLessFee(category.toUpperCase(), courseFee)) {
						System.out.println(course);
					}
					break;
				case 3:
					System.out.println("Choose category from below\n1-UPSC\r\n" + "2-JEE,\r\n" + "3-SSC,\r\n"
							+ "4-NET,\r\n" + "5-CAT,\r\n" + "6-DEVELOPER,\r\n" + "7-TESTING,\r\n" + "8-AGRICULTURE;");
					catInput = scn.nextInt();
					scn.nextLine();
					category = Categories.values()[catInput - 1].toString();
					System.out.println("Faculty name-");
					String faculty = scn.nextLine();
					for (Course course : service.getByCategoryAndFaculty(category, faculty)) {
						System.out.println(course);
					}
					break;
				case 4:
					System.out.println("Course name-");
					String courseName = scn.nextLine();
					for (Course course : service.getByNameContaining(courseName.toLowerCase())) {
						System.out.println(course);
					}
					break;
				case 5:
					System.out.println("Course name-");
					courseName = scn.nextLine();
					System.out.println("Faculty name-");
					String facultyName = scn.nextLine();
					for (Course course : service.getByNameAndFaculty(courseName, facultyName)) {
						System.out.println(course);
					}

				}
			}
			System.out.println("0-continue\n1-Exit");
			int ch = scn.nextInt();
			if (ch == 0)
				flag = true;
			else
				flag = false;
		} while (flag);
		System.out.println();
		System.out.println("Tankyou for visit us");
		scn.close();
	}
}
