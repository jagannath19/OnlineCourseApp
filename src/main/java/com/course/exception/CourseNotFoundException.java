package com.course.exception;

/**
 * @author JagannathSutar
 * This exception class extends  RuntimeException
 */
public class CourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseNotFoundException() {
		super();
	}

	public CourseNotFoundException(String message) {
		super(message);
	}
	

}
