package com.course.model;

/**
 * @author JagannathSutar
 *
 */
public class User {
	private String username; //pk
	private String name;
	private long mobile;
	private String email;
	private String password;
	private Integer courseId; //fk
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param username
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public User(String username, String name, long mobile, String email) {
		super();
		this.username = username;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	/**
	 * @param username
	 * @param name
	 * @param mobile
	 * @param email
	 * @param password
	 */
	public User(String username, String name, long mobile, String email, String password) {
		super();
		this.username = username;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * @param username
	 * @param name
	 * @param mobile
	 * @param email
	 * @param password
	 * @param courseId
	 */
	public User(String username, String name, long mobile, String email, String password, Integer courseId) {
		super();
		this.username = username;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.courseId = courseId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getcourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId=courseId;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
