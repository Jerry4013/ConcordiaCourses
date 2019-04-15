// -----------------------------------------------------
// Assignment 4
// Question:4
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class EnrolmentResults {

	public static void main(String[] args) {
		Scanner keyIn = new Scanner(System.in);

		CourseList list1 = new CourseList();
		CourseList list2 = new CourseList(list1);
		readSyllabus(list2);
		readRequest(keyIn, list2);
		searchCourse(keyIn, list2);
		
		CourseList list3 = new CourseList(list2);
		list3.outputList(keyIn);
		System.out.println("Are list2 and list3 equal?");
		System.out.println(list2.equals(list3));
		
		list3.reverseList();
		System.out.println("We reversed the list.");
		list3.outputList(keyIn);
		
		Course c1 = new Course("COMP233", "PROBABILITY", 3, "MATH205", null);
		list3.addToStart(c1);
		System.out.println("We added COMP233 at the beginning.");
		list3.outputList(keyIn);
		
		Course c2 = new Course("SOEN287", "Web", 3, "COMP248", null);
		list3.insertAtIndex(c2,2);
		System.out.println("We added SOEN287 at index 2.");
		list3.outputList(keyIn);
		
		list3.deleteFromIndex(2);
		System.out.println("We deleted the course at index 2");
		list3.outputList(keyIn);
		
		list3.deleteFromStart();
		System.out.println("We deleted the course at the start");
		list3.outputList(keyIn);
		
		Course c3 = new Course("COMP352", "Data_Structures_and_Algorithms", 3, "COMP249", "COMP232");
		list3.replaceAtIndex(c3, 1);
		System.out.println("We replaced the course at index 1 with COMP352");
		list3.outputList(keyIn);
		
		System.out.println("Are list2 and list3 still equal now?");
		System.out.println(list2.equals(list3));
		
		System.out.println("Thank you for using this program!");
		keyIn.close();
	}
	
	public static void readSyllabus(CourseList list){
		Scanner fileIn = null;
		try{
			fileIn = new Scanner(new FileInputStream("IOfiles/Comp249_W18_Assg4_Files/Syllabus.txt"));
		}catch(FileNotFoundException e){
			System.out.println("Cannot find the file.");
			System.exit(0);
		}
		while(fileIn.hasNextLine()){
			String courseID = fileIn.next();
			String courseName = fileIn.next();
			double credit = fileIn.nextDouble();
			fileIn.nextLine();
			String preReqID = fileIn.nextLine();
			if(preReqID.trim().length()==1)
				preReqID = null;
			else
				preReqID = preReqID.substring(1).trim();
			String coReqID = fileIn.nextLine();
			if(coReqID.trim().length()==1)
				coReqID = null;
			else
				coReqID = coReqID.substring(1).trim();
			Course course = new Course(courseID, courseName, credit, preReqID, coReqID);
			if(!list.contains(courseID))
				list.addToStart(course);
		}
		fileIn.close();
	}

	public static void readRequest(Scanner keyIn, CourseList list){
		Scanner fileIn = null;
		System.out.println("Request: Enter the name of the file: ");
		String answer = keyIn.next();
		try{
			fileIn = new Scanner(new FileInputStream("IOfiles/Comp249_W18_Assg4_Files/" + answer));
		}catch(FileNotFoundException e){
			System.out.println("Cannot find the file.");
			System.exit(0);
		}
		String course = fileIn.next();
		course = fileIn.next();
		ArrayList<String> finished = new ArrayList<>();
		while(!course.equalsIgnoreCase("Requested")){
			finished.add(course);
			course = fileIn.next();
		}
		ArrayList<String> requested = new ArrayList<>();
		while(fileIn.hasNext()){
			course = fileIn.next();
			requested.add(course);
		}
		process(finished, requested, list);
	}
	
	public static void process(ArrayList<String> finished, ArrayList<String> requested, CourseList list){
		if(requested.size()==0){
			System.out.println("No enrollment courses found.\n");
			return;
		}
		for(String element : requested){
			String pre = list.findCourse(element).getPreReqID();
			String co = list.findCourse(element).getCoReqID();
			if(pre==null && co==null)
				System.out.println("Student can enroll in " + element + " course as there is no pre-requisite or co-requisite");
			else if(pre==null && co!=null){
				if(finished.contains(co) || requested.contains(co))
					System.out.println("Student can enroll in " + element + " course as he/she has completed or is enrolling co-requisite " + co);
				else
					System.out.println("Student can't enrol in " + element + " course as he/she doesn't have sufficient background needed.");
			}else if(pre!=null && co==null){
				if(finished.contains(pre))
					System.out.println("Student can enroll in " + element + " course as he/she has completed pre-requisite " + pre);
				else
					System.out.println("Student can't enrol in " + element + " course as he/she doesn't have sufficient background needed.");
			}else if(pre!=null && co!=null){
				if(pre.equals(co))
					if(finished.contains(pre) || requested.contains(co))
						System.out.println("Student can enroll in " + element + " course as he/she has completed the pre-requisite "
								+ pre + " or is enrolling the co-requisite " + co);
					else 
						System.out.println("Student can't enrol in " + element + " course as he/she doesn't have sufficient background needed.");
				else if(!finished.contains(pre))
					System.out.println("Student can't enrol in " + element + " course as he/she doesn't have sufficient background needed.");
				else if(finished.contains(co)||(requested.contains(co) && (finished.contains(list.findCourse(co).getPreReqID()) && 
						(requested.contains(list.findCourse(co).getCoReqID())||finished.contains(list.findCourse(co).getCoReqID())))))
					System.out.println("Student can enroll in " + element + " course as he/she has completed the pre-requisite " + pre
							+ ", and has completed or is enrolling co-requisite " + co);
				else
					System.out.println("Student can't enrol in " + element + " course as he/she doesn't have sufficient background needed.");
			}
		}
		System.out.println();
	}
	
	
	private static void searchCourse(Scanner keyIn, CourseList list) {
		String course = null;
		String answer = null;
		do{
			System.out.println("Enter courseID to search course: ");
			course = keyIn.next();
			System.out.println(list.searchCourse(course));
			System.out.println("Do you want to search another course? (Y/N)");
			answer = keyIn.next();
		}while(answer.equalsIgnoreCase("Y"));
	}
	 
}

