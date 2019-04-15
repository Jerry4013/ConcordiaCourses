// -----------------------------------------------------
// Assignment 4
// Question:2
// Written by: Jingchao Zhang, 40049474
// -----------------------------------------------------

/**
 * Name(s) and ID(s): Jingchao Zhang 40049474 <br>
 * COMP249 <br>
 * Assignment # 4 <br>
 * Due Date: Apr 13, 2018 <br>
 * Purpose: create a courseList, fill in with the courses from the syllabus, then analyze whether he can take this course.
 *   
 */
package assignment.a4;

import java.util.Scanner;

public class Course implements DirectlyRelatable, Cloneable {

	private String courseID;
	private String courseName;
	private double credit;
	private String preReqID;
	private String coReqID;

	public Course(){}
	
	public Course(String courseID, String courseName, double credit, String preReqID, String coReqID) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
		this.preReqID = preReqID;
		this.coReqID = coReqID;
	}
	
	public Course(Course anotherCourse, String newCourseID){
		courseID = newCourseID;
		courseName = anotherCourse.courseName;
		credit = anotherCourse.credit;
		preReqID = anotherCourse.preReqID;
		coReqID = anotherCourse.coReqID;
	}
	
	public Course(Course anotherCourse){
		courseID = anotherCourse.courseID;
		courseName = anotherCourse.courseName;
		credit = anotherCourse.credit;
		preReqID = anotherCourse.preReqID;
		coReqID = anotherCourse.coReqID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getPreReqID() {
		return preReqID;
	}

	public void setPreReqID(String preReqID) {
		this.preReqID = preReqID;
	}

	public String getCoReqID() {
		return coReqID;
	}

	public void setCoReqID(String coReqID) {
		this.coReqID = coReqID;
	}

	public Object clone(){
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Please enter a new courseID for " + courseID + ": ");
		String newID = keyIn.next();
//		keyIn.close();
		try{
			Course copy = (Course)super.clone();
			copy.courseID = newID;
			return copy;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	
	public boolean isDirectlyRelated(Course C) {
		if(C.courseID.equals(preReqID)||C.courseID.equals(coReqID)||
				courseID.equals(C.preReqID)||courseID.equals(C.coReqID))
			return true;
		return false;
	}

	public String toString() {
		return courseID + "  " + courseName + "  " + credit + "\nP\t"
				+ (preReqID!=null?preReqID:"") + "\nC\t" + (coReqID!=null?coReqID:"") + "\n";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (coReqID == null) {
			if (other.coReqID != null)
				return false;
		} else if (!coReqID.equals(other.coReqID))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (Double.doubleToLongBits(credit) != Double.doubleToLongBits(other.credit))
			return false;
		if (preReqID == null) {
			if (other.preReqID != null)
				return false;
		} else if (!preReqID.equals(other.preReqID))
			return false;
		return true;
	}
	
	
}
