package com.gooot;

import java.util.List;

public class GradeCalculator {

	public Courses courses;

	// List<Course> courses;

	public GradeCalculator(List<Course> courses) {
		this.courses = new Courses(courses);

	}


	/*
	 * 요구사항
	 * 평균학점 계산 방법 = (학점 * 교과목 평점)의 합계 / 수강 신청 총학점 수
	 * 일급 컬렉션 사용
	 * */

	public double calculateGrade() {

		// (학점수 * 교과목 평점)의 합계
		double multipliedCreditAndCourseGrade=0;

		// for(Course course : courses) {
		// 	// multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
		// 	multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
		// }

		multipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();


		int totalCompletedCredit =0 ;
		// int totalCompletedCredit = courses.stream()
		// 	.mapToInt(Course::getCredit)
		// 	.sum();

		totalCompletedCredit = courses.totalCompletedCredit();

		return multipliedCreditAndCourseGrade / totalCompletedCredit;

	}
}
