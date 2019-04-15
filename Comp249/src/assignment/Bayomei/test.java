package assignment.Bayomei;
// ----------------------------------------------------------
// Assignment#4
// Question:
// Written by: Natsume
// ----------------------------------------------------------

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 *
 * @author Natsume   <br/>
 * COMP249	<br/>
 * Assignment #4	<br/>
 * Due Date: Fri April 13st 	<br/>
 *
 *  WHAT DOES THIS PROGRAM DO? <br/>
 *  ----------------------------<br/>
 * This program is called EnrolmentResults. It is a tool which will determine if a student can enrol in
 * a specific course based on courses he/she has taken so far. First it reads the file "Syllabus.txt" which containing
 * information about various courses, and "Request.txt" which contains student enrollement request information
 * Then it parses these files to extract course information and produces an outcome for each of the course
 * student wants to enrol in.
 *
 */


// interface class
interface DirectlyRelatable{
	public boolean isDirectlyRelated(Course C) ;
}


// Course class
class Course implements DirectlyRelatable{
	
	//five attributes
	private String courseID;
	private String courseName;
	private double credit;
	private String preReqID;
	private String coReqID;
	
	//default constructor
	public Course() {
		courseID = null;
		courseName = null;
		credit = 0.0;
		preReqID = null;
		coReqID = null;
	}
	
	//parameterized constructor
	public Course(String cid, String cn, double cr, String pid, String coid) {
		courseID = cid;
		courseName = cn;
		credit = cr;
		preReqID = pid;
		coReqID = coid;
	}
	
	//copy constructor
	public Course(Course c, String newID) {
		setCourseID(newID);
		setCoursename(c.courseName);
		setCredit( c.credit);
		setPrereqID( c.preReqID);
		setCoreqID (c.coReqID) ;
	}
	
	public void setCourseID(String cid) {
		courseID = cid;
	}
	public String getCourseID() {
		return courseID;
	}
	
	public void setCoursename(String cn) {
		courseName = cn;
	}
	
	public String getCoursename() {
		return courseName;
	}
	
	public void setCredit(double cr) {
		credit = cr;
	}
	
	public double getCredit() {
		return credit;
	}
	
	public void setPrereqID(String pid) {
		preReqID = pid;
	}
	public String getPrereqID() {
		return preReqID;
	}
	
	public void setCoreqID(String coid) {
		coReqID = coid;
	}
	
	public String getCoreqID() {
		return coReqID;
	}
	
	// clone method
	public Course clone() {
		System.out.println("Please enter a new courseID: ");
		Scanner kb = new Scanner(System.in);
		String newCourseID = kb.next();
		return new Course(this, newCourseID);
	}

	public String toString() {
		return courseID+"\t"+courseName+"\t\t\n"+credit+"\t\t"+preReqID+"\t\t"+coReqID;
	}

	public boolean equals(Object another) {
		if(another==null || getClass()!=another.getClass())
			return false;
		else {
			Course c = (Course) another;
			if(preReqID==null && coReqID==null){
                return (courseName.equals(c.courseName) && credit==c.credit);
            }
            else{
			    if(preReqID!=null && coReqID==null )
                    return (courseName.equals(c.courseName) && credit==c.credit && preReqID.equals(c.preReqID) );
			    else
			        if(preReqID==null && coReqID!=null )
                        return (courseName.equals(c.courseName) && credit==c.credit && coReqID.equals(c.coReqID) );
			        else
                        return (courseName.equals(c.courseName) && credit==c.credit &&preReqID.equals(c.preReqID)
                            && coReqID.equals(c.coReqID) );
            }


		}		
	}

	// implements the interface DirectlyRelatable
	public boolean isDirectlyRelated(Course c) {
		if(c==null)
			return false;
		else {
			if(preReqID.equals(c.getCourseID()) || coReqID.equals(c.getCourseID()))
				return true;
			else
				return false;
		}
	}

}


//linkedList class
class CourseList{	
	
	//inner class
	class CourseNode{
		private Course cour;
		private CourseNode next;
		
		public CourseNode() {
			cour = null;
			next = null;
		}
		
		public CourseNode(Course c, CourseNode nt) {
			cour = c;
			next = nt;
		}
		
		public CourseNode(CourseNode cn) {
			cour = cn.cour.clone();
			next = cn.next;
		}


		//this method allows a privacy leak, because 
		//it allows a programmer to change the private instance variables of the object.
		public void setCourse(Course c) {
			cour = c;
		}
		
		//this method allows a privacy leak, because 
		//it returns a reference to a Course object, and the object can be modified by other behavior.
		public Course getCourse() {
			return cour;
		}
		
		public void setCourseNode(CourseNode cn) {
			next = cn;
		}
		
		public CourseNode getCourseNode() {
			return next;
		}
	}
	
	
	//attributes
	private CourseNode head;	// used to point to the first node in this list object
	private int size;		    // indicates the current size of the list
	static int ctr = 0;
	
	// find the size of the list
	public int getSize() {
		if(head==null)
			return 0;
		else {
			CourseNode t = head;
			int size = 0;
			while(t!=null) {
				size++;
				t = t.next;
			}
			return size;
		}
	}

	// the default constructor
	public CourseList() {
		head=null;
	}

	// the copy constructor
	public CourseList(CourseList l) {
	    if(l.head==null)
			head=null;
		else {
			CourseNode t1 = l.head;
			CourseNode t2 = null, t3 = null;
			head = null;
			while(t1!=null){
				if(head==null){
                    t2 = new CourseNode(t1);
                    head = t2;
                }
				else {
				    t3 = new CourseNode(t1);
					t2.next = t3;
					t2 = t3;
				}
				t1 = t1.next;
			}
			t2 = t3 =null;
		}
	}

	public CourseList clone(){
	    return new CourseList(this);
    }

	// add a CourseNode with an object from Course class at the head of the list;
	public void addTostart(Course c) {
		head = new CourseNode(c, head); 
		size = getSize();
	}
	
	// creates a node with the passed Course object and inserts this node at the given index
	public void insertAtIndex(Course c, int index) {
		try {
		    getSize();
			if(index > size-1 || index < 0)
				throw new NoSuchElementException();
			else {
				CourseNode t = head ;
				if(index==0) {
					head = new CourseNode(c,t);
				}
				else {
					for(int i=0; i<index-1; i++)
						t = t.next;
					t.next = new CourseNode(c,t.next);
				}
                t = null;
                size=getSize();
			}
		}catch(NoSuchElementException e) {
			System.out.println("Program will be terminated");
			System.out.println("\n--------------------------------------");
			System.out.println("Thank you for using Yanqi's program! ");
			System.exit(0);
		}
	}
	
	// deletes the node pointed by that index from the list.
	public void deleteFromIndex(int index) {
		try {
            size=getSize();
			if(index > size-1 || index < 0)
				throw new NoSuchElementException();
			else {
				CourseNode t = head ;
				if(index==0) {
					head = t.next;
				}
				else {
					for(int i=0; i<index-1; i++)
						t = t.next;
					if(t.next.next==null) {
						t.next = null;
					}
					else {
						t.next = t.next.next;
					}
                    size=getSize();
				}
			}
		}catch(NoSuchElementException e) {
			System.out.println("Program will be terminated");
			System.out.println("\n--------------------------------------");
			System.out.println("Thank you for using Yanqi's program! ");
			System.exit(0);
		}
	}
	
	// deletes the first node in the list
	public boolean deleteFromStart() {
		if(head!=null) {
			head = head.next;
			size = this.getSize();
			return true;
		}
		else
			return false;
	}
	
	// replace the node at the passed index with the passed object
	public boolean replaceAtIndex(Course c, int index) {
		if(head==null)
			return false;
		else {
			if(index >= size-1 || index < 0)
				return false;
			else {
				CourseNode t = head;
				if(index==0) 
					head = new CourseNode(c,t.next);
				else {
					for(int i=0; i<index-1; i++)
						t = t.next;
					if(t.next.next==null) {
						t.next = new CourseNode(c,null);
					}
					else {
						t.next = new CourseNode(c,t.next.next);
						t = null;
					}
				}
				return true;
			}
		}
	}
	
	//searches the list for a CourseNode with the courseID
	//However, this method allows a privacy leak, because 
	//it returns a reference to a node, and the node can be modified by other behavior.
	public CourseNode find(String cid) {
		if(head==null) {
			//System.out.println("The list is empty.");
			return null;
		}	
		else {
			CourseNode t = head;
			ctr = 0;
			boolean find = false;
			while(t!=null) {
				ctr++;
				if(t.cour.getCourseID().equals(cid)) {
				//	System.out.println(ctr+"iteratons were made before the search finds the course.");
					find = true;
					break;
				}
				t = t.next;
			}
			if(!find) {
				System.out.println("The course is not in the list.");
				return null;	
			}	
			else {
				return t;
			}
		}

	}

	//The method returns true if the a course with that courseID is in the list
	public boolean contains(String cid) {
		if(head==null) {
			//System.out.println("The list is empty.");
			return false;
		}	
		else {
			CourseNode t = head;
			boolean find = false;
			while(t!=null) {
				if(t.cour.getCourseID().equals(cid)) {
					find = true;
					break;
				}
				t = t.next;
			}
			if(!find) {
				return false;	
			}	
			else {
				return true;
			}
		}
	}

	//The method returns true if the two lists contain similar courses
	public boolean equals(CourseList l) {
        System.out.println("begin");
		if(getSize()!=l.getSize())
			return false;
		else {
            System.out.println("cedon");
			CourseNode t = head, t2 = l.head;
			boolean similar = false;
			while(t!=null) {
				while(t2!=null) {
					if(t.cour.equals(t2.cour)) {
						similar = true;
						break;
					}
					t2=t2.next;
				}
				if(!similar) 
					break;
				System.out.println(t.cour);
				t=t.next;
			}
			if(!similar)
				return false;
			else
				return true;
		}
	}

	
	//print the objects in CourseList
	public void show() {
		CourseNode t = head; 
		while(t!=null) {
			System.out.println(t.cour);
			t=t.next;
		}
	}
		
		
}
	





class EnrolmentResults {

	
    // the method to open Request file and print outcome
	public static void openRequest(CourseList l) throws FileNotFoundException, IOException{
		System.out.println("Please enter the name of the file that needs to be processed: ");
		BufferedReader br;
		Scanner kb = new Scanner(System.in);
		String next;
		String fileName = kb.next();
		br = new BufferedReader(new FileReader(fileName));
		next = br.readLine();
		ArrayList<String> requestList = new ArrayList<String>();            //store request courses
		ArrayList<String> finishedList = new ArrayList<String>();           //store finished courses
		ArrayList<String> enrolledList = new ArrayList<String>();           //store enrolled courses

		while(next!=null && !(next.equals("Requested"))) {
			finishedList.add(next);
			next = br.readLine();
		}
		next = br.readLine();
		while(next!=null) {
			requestList.add(next);
			next = br.readLine();
		}		
		
		br.close();
		
		if(requestList.isEmpty())
			System.out.println("No enrollment courses found.");
		else {
			for(String requestCourseID : requestList) {
				String preCourseID;
				String coCourseID;
				preCourseID = l.find(requestCourseID).getCourse().getPrereqID();
				coCourseID = l.find(requestCourseID).getCourse().getCoreqID();
				if(finishedList.contains(preCourseID)||preCourseID==null) {
					System.out.println("Student can enrol in "+requestCourseID+" course as he/she has completed the pre-requisite "+preCourseID+".");
					enrolledList.add(requestCourseID);
				}
				else {
					if( enrolledList.contains(coCourseID)) {
						System.out.println("Student can enrol in "+requestCourseID+" course as he/she is enrolling for c0-requisite "+coCourseID+".");
						enrolledList.add(requestCourseID);
					}else
						System.out.println("Student can't enrol in "+requestCourseID+" course as he/she doesn't have sufficient background needed.");
				}
			}
		}
	}
	
	// the method to search course in CourseList
	public static void searchCourse(CourseList l) {
		
		boolean end =false;
		while(!end) {
			System.out.println("Please enter the course ID that you want to search: ");
			Scanner kb = new Scanner(System.in);
			String courseID = kb.next();			//for user to search the list
			if(l.contains(courseID)) {
				System.out.println("The course "+courseID+" is found in syllabus.");
				System.out.println(CourseList.ctr+" iteratons were made before the search finds the course.");
			}
			else {
				System.out.println("NO such course in the syllabus.");
			}	
            System.out.println("Search again?: Y/N");
            if(kb.next().equals("N"))
                end = true;
		}
		
	}	
	
	
	
	

	
	public static void main(String[] args) {
		
		CourseList l1 = new CourseList();               //store the courses in syllabus
		Course c = new Course();                        // a object of Course
		BufferedReader br;
		String next;                                    //control the content read by BufferedReader
		Scanner kb = new Scanner(System.in);

        //Open the Syllabus.txt file, and initialize l1
		try {
			br = new BufferedReader(new FileReader("Syllabus.txt"));
			next = br.readLine();
			while(next!=null) {
				
				StringTokenizer nextString = new StringTokenizer(next.toString());
				if(nextString.countTokens()==3) {
					c.setCourseID(nextString.nextToken());
					c.setCoursename(nextString.nextToken());
					c.setCredit(Double.parseDouble(nextString.nextToken()));
				}
				else {
					if(nextString.countTokens()==2) {
						
						if(nextString.nextToken().equals("P"))
							
							c.setPrereqID(nextString.nextToken());
						else
							c.setCoreqID(nextString.nextToken());
					}
				}
				if(next.length()==0) {
					if(l1.contains(c.getCourseID()))
						continue;
					else {
						l1.addTostart(new Course(c.getCourseID(), c.getCoursename(), c.getCredit(), c.getPrereqID(), c.getCoreqID()));
					}
				}
				next = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File is not found.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		l1.show();
		System.out.print("============================\n\n");
		
		
        // open request file, and print the outcome
		boolean end=false;
		while(!end) {
			try{
				openRequest(l1);
			}catch(FileNotFoundException e) {
				System.out.println("File is not found.");
			}catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Request again?: Y/N");
			if(kb.next().equals("N"))
				end = true;
		}
		

		// search the list
		searchCourse(l1);



        // 4.5 test part
        /*
        System.out.println("\nTest isDirectlyRelated method: ");
        Course c1 = l1.find("COMP249").getCourse();
		Course c2 = l1.find("COMP248").getCourse();
		if(c1.isDirectlyRelated(c2))
			System.out.println(c1.getCourseID()+" is pre-requisite or co-requisite of "+c2.getCourseID());
		else
		    System.out.println(c1.getCourseID()+"is not related with "+c2.getCourseID());

        System.out.println("\nTest the parameterized constructor of Course class: ");
        Course c3 = new Course("COMP352", "Data Structure and Algorithms", 3, "COMP249", "COMP348");
        System.out.println(c3);

        System.out.println("\nTest the copy constructor and clone() method of Course class");
        Course c4 = new Course(c1, "comp1");
        Course c5 = c2.clone();
        System.out.println(c4);
        System.out.println(c5);

        System.out.println("\nTest equals() method of Course class:");
        if(c1.equals(c4))
            System.out.println("c1 is equal to c4");
        else
            System.out.println("c1 is not equal to c4");


        System.out.println("\nTest the size of CourseList:");
        System.out.println(l1.getSize());

        System.out.println("\nTest the copy constructor of CourseList");
        CourseList l2 = new CourseList(l1);
        System.out.println(l2.getSize());
        l2.show();

        System.out.println("\nTest the equals() method:");
        if(l1.equals(l2))
            System.out.println("l1 is equal to l2");
        else
            System.out.println("l1 is not equal to l2");

        System.out.println("\nTest the insertAtindex() method:");
        l1.insertAtIndex(c3, 4);
        l1.show();

        System.out.println("\nTest the deleteFromindex() method:");
        l1.deleteFromIndex(4);
        l1.show();

        System.out.println("\nTest the insertAtindex() method when index is 0:");
        l1.insertAtIndex(c3, 0);
        l1.show();

        System.out.println("\nTest the deleteFromindex() method when index is 0:");
        l1.deleteFromIndex(0);
        l1.show();

        System.out.println("\nTest the insertAtindex() method when index is size-1:");
        l1.insertAtIndex(c3, l1.getSize()-1);
        l1.show();

        System.out.println("\nTest the deleteFromindex() method when index is size-1:");
        l1.deleteFromIndex(l1.getSize()-2);
        l1.show();

        System.out.println("\nTest the deleteFromStart() method:");
        l1.deleteFromStart();
        l1.show();

        System.out.println("\nTest the replaceAtIndex() method:");
        l1.replaceAtIndex(c3,0);
        l1.show();

        System.out.println("\nTest the replaceAtIndex() method:");
        l1.replaceAtIndex(c3,3);
        l1.show();
        */


        System.out.println("\n--------------------------------------");
        System.out.println("Thank you for using Yanqi's program! ");
	}
}