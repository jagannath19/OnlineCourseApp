package com.course.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.course.model.Course;

/**
 * @author JagannathSutar
 * @implNote IRowMapper
 */
public class CourseMapper implements IRowMapper {

	/**
	 * @param resultset
	 * @return list of course
	 * @throws SQLException
	 * this  method use to set the output in a resultset 
	 */
	@Override
	public List<Course> mapRow(ResultSet resultset) throws SQLException {
			List<Course> courses=new ArrayList<>();
			while(resultset.next()) {
				Course course = new Course();
				course.setCourseName(resultset.getString(1));
				course.setCourseId(resultset.getInt(2));
				course.setFacultyName(resultset.getString(3));
				course.setMode(resultset.getString(4));
				course.setCategory(resultset.getString(5));
				course.setDurationInDays(resultset.getInt(6));
				course.setCourseFee(resultset.getDouble(7));
				courses.add(course);
			}
		return courses;
	}

	

}
