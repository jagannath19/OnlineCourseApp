package com.course.model;

/**
 * @author JagannathSutar
 *
 */
public class Order {
	private String userName;
	private long mobile;
	private String email;
	private String courseName;
	private String facultyName;
	private String mode;
	private String category;
	private int durationInDays;
	private double courseFee;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userName
	 * @param mobile
	 * @param email
	 * @param courseName
	 * @param facultyName
	 * @param mode
	 * @param category
	 * @param durationInDays
	 * @param courseFee
	 */
	public Order(String userName, long mobile, String email, String courseName, String facultyName, String mode,
			String category, int durationInDays, double courseFee) {
		super();
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.courseName = courseName;
		this.facultyName = facultyName;
		this.mode = mode;
		this.category = category;
		this.durationInDays = durationInDays;
		this.courseFee = courseFee;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
		return "Order [userName=" + userName + ", mobile=" + mobile + ", email=" + email + ", courseName=" + courseName
				+ ", facultyName=" + facultyName + ", mode=" + mode + ", category=" + category + ", durationInDays="
				+ durationInDays + ", courseFee=" + courseFee + "]";
	}
	
	

}
