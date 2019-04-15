package assignment.Bayomei;// ----------------------------------------------------------
// Assignment#4
// Question:
// Written by: Mohamed Hefny
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
 * @author Mohamed Hefny/   <br/>
 * COMP249	<br/>
 * Assignment #4	<br/>
 * Due Date: 	<br/>
 *	
 *  WHAT DOES THIS PROGRAM DO? <br/>
 *  ----------------------------<br/>
 * 
 *
 */
interface Watchable{

	public String  isOnSameTime(TVShow S	) ;

}

//Tv show class
class TVShow implements Watchable{
	//five attributes
	private String ShowID;
	private String ShowName;
	private double StartTime;
	private double EndTime;

	public TVShow() {
		ShowID = null;
		ShowName = null;
		StartTime = 0.0;
		EndTime = 0.0;	
	}

	/**
	 * @param showID
	 * @param showName
	 * @param startTime
	 * @param endTime
	 */
	//parameterized constructor

	public TVShow(String showID, String showName, double startTime, double endTime) {
		
		ShowID = showID;
		ShowName = showName;
		StartTime = startTime;
		EndTime = endTime;
	}

	//copy constructor
	/**
	 * 
	 * @param w
	 * @param newID
	 */
	public TVShow(TVShow w, String newID) {
		ShowName = w.ShowName;
		StartTime = w.StartTime;
		EndTime = w.EndTime;
		ShowID = newID;
	}

	/**
	 * @return the showID
	 */
	public String getShowID() {
		return ShowID;
	}

	/**
	 * @param showID the showID to set
	 */
	public void setShowID(String showID) {
		ShowID = showID;
	}

	/**
	 * @return the showName
	 */
	public String getShowName() {
		return ShowName;
	}

	/**
	 * @param showName the showName to set
	 */
	public void setShowName(String showName) {
		ShowName = showName;
	}

	/**
	 * @return the startTime
	 */
	public double getStartTime() {
		return StartTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(double startTime) {
		StartTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public double getEndTime() {
		return EndTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(double endTime) {
		EndTime = endTime;
	}


	public TVShow clone() {
		System.out.println("Please enter a new ShowID: ");
		Scanner kb = new Scanner(System.in);
		String newShowID = kb.next();
		return new TVShow(this, newShowID);
	}
	/**
	 * @return ShowID+"\t"+ShowName+"\t\t"+StartTime+"\t\t"+EndTime;
	 */

	public String toString() {
		return ShowID+"\t"+ShowName+"\t\t"+StartTime+"\t\t"+EndTime;
	}
	/**
	 * @param another
	 */

	public boolean equals(Object another) {
		if(another==null || getClass()!=another.getClass()) {
			return false;
		}			
		TVShow w = (TVShow) another;
		return (this.ShowName.equals(w.ShowName)&& this.StartTime==w.StartTime && this.EndTime==w.EndTime);
	
	}	
	/**
	 * @param s
	 */
	public String isOnSameTime(TVShow s) {
		if(this.StartTime==s.StartTime) {
			return "Same time";
		}else if((this.EndTime-this.StartTime)==01.00) {
			if((this.StartTime+00.30)==s.StartTime)
				return "Some Overlap";
		}else if((this.EndTime-this.StartTime)==01.30) {
			if((this.StartTime+00.30)==s.StartTime||(this.StartTime+01.00)==s.StartTime)
				return "Some Overlap";
		}else if ((this.EndTime-this.StartTime)==02.00) {
			if((this.StartTime+00.30)==s.StartTime||(this.StartTime+01.00)==s.StartTime||(this.StartTime+01.30)==s.StartTime) 
				return "Some Overlap";
		}
		return "Different time";
	}
}
	class ShowList{

		class ShowNode{

			private TVShow tv;
			private ShowNode next;

			public ShowNode() {
				tv=null;
				next=null;
			}
			public ShowNode(TVShow t,ShowNode sn) {
				tv=t;
				next=sn;	
			}
			public ShowNode(ShowNode showName) {
				tv=showName.tv.clone();
				next=showName.next;
			}
			public void setTVShow(TVShow t) {
				tv = t;
			}

			//this method allows a privacy leak, because 
			//it returns a reference to a Course object, and the object can be modified by other behavior.
			public TVShow getTVShow() {
				return tv;
			}

			public void setShowNode(ShowNode sn) {
				next = sn;
			}

			public ShowNode getShowNode() {
				return next;
			}
		}
		//attributes
		private ShowNode head;
		private int size;
		static int ctr;
		public int getSize() {
			if(head==null)
				return 0;
			else {
				ShowNode t = head;
				int size = 0;
				while(t!=null) {
					size++;
					t = t.next;
				}
				return size;
			}				
		}
		// the default constructor
		public ShowList() {
			head=null;
		}
		// The copy constructor
		public ShowList(ShowList l) {
			if(l.head==null)
				head=null;
			else {
				ShowNode t1=l.head;
				ShowNode t2=null,t3=null;
				head=null;
				while (t1!=null) {
					if(head==null) {
						t2=new ShowNode(t1);
						head=t2;
					}
					else {
						t3=new ShowNode(t1);
						t2.next=t3;
						t2=t3;
					}
					t1=t1.next;
				}
				t2=t3=null;
			}
		}
		public ShowList clone() {
			return new ShowList(this);
		}
		//add a Showlist with an object from Show class at the head of this list
		public void addToStart(TVShow S) {
			head=new ShowNode(S,head);
			size=getSize();
		}
		//creates a node with pssed course oject and inserts this node at the given index
		public void insertAtIndex(TVShow S,int index) {
			try {
				getSize();
				if(index>size-1||index<0)
					throw new NoSuchElementException();
				else {
					ShowNode t=head;
					if(index==0) {
						head=new ShowNode(S,t);
					}
					else {
						for(int i=0;i<index-1;i++)
							t=t.next;
						t.next=new ShowNode(S,t.next);
					}
					t=null;
					size=getSize();
				}
			}catch(NoSuchElementException e) {
				System.out.println("Promgram will be terminated");
				System.out.println("\n-------------------------");
				System.out.println("Thank youfor using Yanqi's program!");
				System.exit(0);
			}
		}
		//deletes the node pointed by that index from the list.
		public void deleteFromIndex(int index) {
			try {
				size=getSize();
				if(index>size-1||index<0)
					throw new NoSuchElementException();
				else {
					ShowNode t=head;
					if(index==0) {
						head=t.next;
					}
					else {
						for(int i=0;i<index-1;i++)
							t=t.next;
						if(t.next.next==null) {
							t.next=null;
						}
						else {
							t.next=t.next.next;
						}
						size=getSize();
					}
				}
			}catch(NoSuchElementException e) {
				System.out.println("Program will be terminated");
				System.out.print("\n-----------------------");
				System.out.print("Thank you for using Mohamed's program!");
				System.out.println(0);
			}
		}
		//deletes the first node in the list
		public boolean deleteFromStart() {
			if(head!=null) {
				head=head.next;
				size=this.getSize();
				return true;
			}
			else
				return false;
		}
		//replace the node at the passed index with the passed object
		public boolean replaceAtIndex(TVShow S,int index) {
			if(head==null)
				return false;
			else {
				if(index>=size-1||index<0)
					return false;
				else {
					ShowNode t = head;
					if(index==0) 
						head = new ShowNode(S,t.next);
					else {
						for(int i=0; i<index-1; i++)
							t = t.next;
						if(t.next.next==null) {
							t.next = new ShowNode(S,null);
						}
						else {
							t.next = new ShowNode(S,t.next.next);
							t = null;
						}
					}
					return true;
				}
			}
		}
		//The method returns true if a show with that ShowID is in the list
		public ShowNode find(String showID) {
			if(head==null) {
				//System.out.print("The list is empty.");
				return null;
			}
			else {
				ShowNode t=head;
				ctr=0;
				boolean find=false;
				while(t!=null) {
					ctr++;
					if(t.tv.getShowID().equals(showID)) {
						find=true;
						break;
					}
					t=t.next;
				}
				if(!find) {
					System.out.println("The Show is not in the list.");
					return null;	
				}
				else {
					return t;
				}
			}
		}
		//The method returns true if the a course with that courseID is in the list
		public boolean contains(String ShowID) {
			if(head==null) {
				//System.out.println("The list is empty.");
				return false;
			}	
			else {
				ShowNode t = head;
				boolean find = false;
				while(t!=null) {
					if(t.tv.getShowID().equals(ShowID)) {
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
		//The method returns true if the two lists contain similar shows
		public boolean equals(ShowList l) {
			System.out.println("begin");
			if(getSize()!=l.getSize())
				return false;
			else {
				System.out.println("cedon");
				ShowNode t=head, t2 = l.head;
				boolean similar = false;
				while(t!=null) {
					while(t2!=null) {
						if(t.tv.equals(t2.tv)) {
							similar = true;
							break;
						}
						t2=t2.next;
					}
					if(!similar) 
						break;
					System.out.println(t.tv);
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
			ShowNode t = head; 
			while(t!=null) {
				System.out.println(t.tv);
				t=t.next;
			}
		}


	}
	public class ProcessWishlist{
		// the method to open Request file and print outcome
		public static void openRequest(ShowList l) throws FileNotFoundException, IOException{
			System.out.println("Please enter the name of the file that needs to be processed: ");
			BufferedReader br;
			Scanner kb = new Scanner(System.in);
			String next;
			String fileName = kb.next();
			br = new BufferedReader(new FileReader(fileName));
			next = br.readLine();
			ArrayList<String> wishList = new ArrayList<String>();            //store request courses
			ArrayList<String> watchingList = new ArrayList<String>();           //store finished courses
			ArrayList<String> enrolledList = new ArrayList<String>();           //store enrolled courses

			while(next!=null && !(next.equals("Wishlist"))) {
				watchingList.add(next);
				next = br.readLine();
			}
			next = br.readLine();
			while(next!=null) {
				wishList.add(next);
				next = br.readLine();
			}		

			br.close();
			if(wishList.isEmpty())
				System.out.println("No wishList Found");
		else {
			for(String wishListID: wishList) {
				
				double startTime;
				double endTime;
				startTime=l.find(wishListID).getTVShow().getStartTime();
				endTime=l.find(wishListID).getTVShow().getEndTime();
				if(watchingList.contains(startTime)) {
					System.out.println("can watch "+wishListID+" tv show as he/she has completed the tv show before");
					enrolledList.add(wishListID);
				}
				else {
					if(enrolledList.contains(endTime)) {
						System.out.println("Can watch"+ wishListID);	
					}else
						System.out.println("cant watch");
				}
				
			}
		}
		}
		public static void searchTVShow(ShowList l) {
			boolean end=false;
			while(!false) {	
				System.out.println("Please enter the TVShow ID that you want to search: ");
				Scanner kb = new Scanner(System.in);
				String showID = kb.next();			//for user to search the list
				if(l.contains(showID)) {
					System.out.println("The show "+showID+" is found in y.");
					System.out.println(ShowList.ctr+" iteratons were made before the search finds the show.");
				}
				else {
					System.out.println("NO such show in the list.");
				}	
	            System.out.println("Search again?: Y/N");
	            if(kb.next().equals("N"))
	                end = true;
			}
			
		}	
		public static void main(String[] args) {

			ShowList l1 =new ShowList();
			TVShow s= new TVShow();
			BufferedReader br;
			String next;
			Scanner kb = new Scanner(System.in);
		
			//Opent the TVGudie.txt and intiallize l1 
			try {
			br=new BufferedReader(new FileReader("TVGuide.txt"));
			next=br.readLine();
			while(next!=null) {
				StringTokenizer nextString=new StringTokenizer(next.toString());
				if(nextString.countTokens()==2 && nextString.nextToken().equals("S"))
				{
					s.setStartTime(Double.parseDouble(nextString.nextToken()));

				}else if(nextString.nextToken().equals("E")&&nextString.countTokens()==2) {
					s.setEndTime(Double.parseDouble(nextString.nextToken()));
				}
				else {
					if(nextString.countTokens()==2) {
						s.setShowID(nextString.nextToken());
						s.setShowName(nextString.nextToken());
					}
				}
				if(next.length()==0) {
					if(l1.contains(s.getShowID()))
						continue;
					else {
						l1.addToStart(new TVShow(s.getShowID(),s.getShowName(),s.getStartTime(),s.getEndTime()));
					}
				}
				next=br.readLine();
			}
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}catch(IOException e) {
			e.printStackTrace();
		}
			l1.show();
			System.out.println("=====================\n\n");
			
		//open request file, and print outcome
			boolean end=false;
			while(!end) {
				try {
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
			searchTVShow(l1);
			   System.out.println("\n--------------------------------------");
		        System.out.println("Thank you for using Mohamed's program! ");
			}
		}
