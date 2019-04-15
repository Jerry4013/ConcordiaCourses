// -----------------------------------------------------
// Assignment 4
// Question:3
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

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CourseList implements Cloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private class CourseNode implements Cloneable,Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Course course;
		private CourseNode link;
		
		@SuppressWarnings("unused")
		public CourseNode(){
			course = null;
			link = null;
		}

		public CourseNode (Course course, CourseNode link) {
			this.course = course;
			this.link = link;
		}
		
		/**
		 * Copy Constructor
		 * @param other
		 */
		public CourseNode(CourseNode other){
			if(other==null || other.course==null){
				System.out.println("This node cannot be copied. Aborting");
				System.exit(0);
			}
			course = new Course(other.course);
			if(other.link==null)
				link = null;
			else{
				CourseNode position = other;
				position = position.link;
				link = new CourseNode(new Course(position.course), null);
				CourseNode end = link;
				position = position.link;
				while (position != null){
					end.link = new CourseNode(new Course(position.course), null);
					end = end.link;
					position = position.link;
				}
			}
		}
		
		public Object clone(){
			try{
				CourseNode copy = (CourseNode)super.clone();
				if(course == null)
					copy.course = null;
				else
					copy.course = new Course(course);
				return copy;
			}catch(CloneNotSupportedException e){
				return null;
			}
		}

		public Course getCourse() {
			return new Course(course);
		}

		@SuppressWarnings("unused")
		public void setCourse(Course course) {
			this.course = new Course(course);
		}

		@SuppressWarnings("unused")
		public CourseNode getLink() {
			return link;
		}

		@SuppressWarnings("unused")
		public void setLink(CourseNode link) {
			this.link = link;
		}
	}
	
	private CourseNode head;
	private int size;
	
	public CourseList(){
		head = null;
		size = 0;
	}
	
	/**
	 * Copy Constructor
	 * @param otherList some other list we want to copy
	 */
	public CourseList(CourseList otherList){
		if (otherList == null)
			throw new NullPointerException();
		if (otherList.head == null){
			head = null;
			size = 0;
		}
		else {
			head = new CourseNode(otherList.head);
			size = otherList.size;
		}
	}
	
	public void addToStart(Course course){
		head = new CourseNode(new Course(course), head);
		size++;
	}
	
	public void insertAtIndex(Course course, int index){
		if(course == null || index<0 || index>size-1)
			throw new NoSuchElementException();
		if(index == 0)
			addToStart(new Course(course));
		else{
			CourseNode previous = findByIndex(index-1);
			previous.link = new CourseNode(new Course(course), findByIndex(index));
			size++;
		}
	}
	
	public void deleteFromIndex(int index){
		if(head == null || index<0 || index>size-1)
			throw new NoSuchElementException();
		if(index == 0)
			head = head.link;
		else{
			CourseNode previous = findByIndex(index-1);
			previous.link = findByIndex(index+1);
		}
		size--;
	}
	
	public void deleteFromStart(){
		if (head != null){
			head = head.link;
			size--;
		}
		else
			System.out.println("No element in this list.");
	}
	
	public void replaceAtIndex(Course course, int index){
		if(course == null || index<0 || index>size-1)
			return;
		if(index == 0)
			head = new CourseNode(new Course(course), head.link);
		else{
			CourseNode previous = findByIndex(index-1);
			previous.link = new CourseNode(new Course(course), findByIndex(index).link);
		}
	}
	
	private CourseNode findByIndex(int index){
		if(index<0 || index>size-1)
			return null;
		int count = 0;
		CourseNode position = head;
		while(count != index){
			position = position.link;
			count++;
		}
		return position;
	}
	
	private CourseNode find(String courseID){
		CourseNode position = head;
		while(position != null){
			if(position.course.getCourseID().equals(courseID))
				return position;
			position = position.link;
		}
		return null;
	}
	
	public Course findCourse(String courseID){
		return find(courseID).getCourse();
	}
	
	public Course searchCourse(String courseID){
		CourseNode position = head;
		int count = 0;
		while(position != null){
			count++;
			if(position.course.getCourseID().equalsIgnoreCase(courseID)){
				System.out.println("We found this course after " + count + " iterations");
				return position.course;
			}
			else
				position = position.link;
		}
		System.out.println("We cannot find this course. The result is: ");
		return null;
	}
	
	public boolean contains(String courseID){
		return (find(courseID) != null);
	}
	
	/**
	 * 
	 * @param otherList Comparing two lists 
	 * @return if equals return true.
	 */
	public boolean equals(CourseList otherList){
		if(otherList == null)
			return false;
		if (size!=otherList.size)
			return false;
		CourseNode position = head;
		CourseNode otherPosition = otherList.head;
		while(position != null){
			if (!(position.course.equals(otherPosition.course)))
				return false;
			position = position.link;
			otherPosition = otherPosition.link;
		}
		return true;
	}
	
	public void outputList(Scanner keyIn){
		System.out.println("Do you want to display the course list? (Y/N)");
		String answer = keyIn.next();
		if(answer.equalsIgnoreCase("Y"))
		{
			CourseNode position = head;
			while (position != null){
				System.out.println(position.course);
				position = position.link;
			}
		}
	}
	
	public void reverseList(){
		CourseList newList = new CourseList();
		CourseNode position = head;
		while(position!=null){
			newList.head = new CourseNode(new Course(position.course), newList.head);
			position = position.link;
		}
		head = newList.head;
	}
	
	public Object clone(){
		
		try{
			CourseList copy = (CourseList)super.clone();
			if(head == null)
				copy.head = null;
			else
				copy.head = (CourseNode) head.clone();
			return copy;
		}catch(CloneNotSupportedException e){
			System.out.println("Cannot clone this object.");
			return null;
		}
		
		
	}
}










