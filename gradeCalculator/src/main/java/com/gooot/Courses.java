package com.gooot;

import java.util.List;

public class Courses {
	List<Course> courses;

	public Courses(List<Course> courses) {
		this.courses = courses;
	}

	public double multiplyCreditAndCourseGrade() {

		return courses.stream()
			.mapToDouble(Course::multiplyCreditAndCourseGrade)
			.sum();

		// double multipliedCreditAndCourseGrade=0;
		//
		// for(Course course : courses) {
		// 	// multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
		// 	multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
		// }
		//
		// return multipliedCreditAndCourseGrade;

	}

	public int totalCompletedCredit() {
		int totalCompletedCredit = courses.stream()
			.mapToInt(Course::getCredit)
			.sum();
		return totalCompletedCredit;
	}
}
