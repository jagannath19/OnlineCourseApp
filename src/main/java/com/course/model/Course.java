package com.course.model;

public class Course {
	private String courseName;
	private Integer courseId;
	private String facultyName;
	private String mode;
	private String category;
	private int durationInDays;
	private double courseFee;
	public Course() {
		super();
	}
	public Course(String courseName, String facultyName, String mode, String category,
			int durationInDays, double courseFee) {
		super();
		this.courseName = courseName;
		this.facultyName = facultyName;
		this.mode = mode;
		this.category = category;
		this.durationInDays = durationInDays;
		this.courseFee = courseFee;
	}
	
	
	
	
	public Course(String courseName, Integer courseId, String facultyName, String mode, String category,
			int durationInDays, double courseFee) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.facultyName = facultyName;
		this.mode = mode;
		this.category = category;
		this.durationInDays = durationInDays;
		this.courseFee = courseFee;
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
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getDurationInDays() {
		return durationInDays;
	}
	public void setDurationInDays(int durationInDays) {
		this.durationInDays = durationInDays;
	}
	public double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	@Override
	public String toString() {
		return "OnlineCourse [courseName=" + courseName + ", courseId=" + courseId + ", facultyName=" + facultyName
				+ ", mode=" + mode + ", category=" + category + ", durationInDays=" + durationInDays + ", courseFee="
				+ courseFee + "]";
	}
	
	
		
	
}
