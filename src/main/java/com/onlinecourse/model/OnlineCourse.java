package com.onlinecourse.model;

public class OnlineCourse {
	private String courseName;
	private int courseId;
	private String facultyName;
	private String category;
	private int timeduration;
	private double courseFee;
	public OnlineCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OnlineCourse(String courseName, String faculty, String category, int timeduration,
			double price) {
		super();
		this.courseName = courseName;
		this.facultyName = faculty;
		this.category = category;
		this.timeduration = timeduration;
		this.courseFee = price;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getFaculty() {
		return facultyName;
	}
	public void setFaculty(String faculty) {
		this.facultyName = faculty;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getTimeduration() {
		return timeduration;
	}
	public void setTimeduration(int timeduration) {
		this.timeduration = timeduration;
	}
	public double getPrice() {
		return courseFee;
	}
	public void setPrice(double price) {
		this.courseFee = price;
	}
	@Override
	public String toString() {
		return "OnlineCourse [courseName=" + courseName + ", courseId=" + courseId + ", faculty=" + facultyName
				+ ", category=" + category + ", timeduration=" + timeduration + ", price=" + courseFee + "]";
	}
		
	
}
