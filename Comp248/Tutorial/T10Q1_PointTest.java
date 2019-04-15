
public class T10Q1_PointTest {

	public static void main(String[] args) {
		/* H- Declare 2 points:p1 with coordinates (0,0) and p2 with coordinates (2,3). */
		T10Q1_Point p1 = new T10Q1_Point(0,0);
		T10Q1_Point p2 = new T10Q1_Point(2,3);
		
		/* I- Write the necessary statement(s) to display the coordinates of p1 and p2. */
		System.out.println(p1);
		System.out.println(p2);
		
		/* J- Write a statement to reverse the coordinates of p2. */
		T10Q1_Point p3 = p2.reverse();
		
		/* K- Write the necessary statement(s) to set the coordinates of p1 to be the reverse of p2. 
		 * For example, if p1 is (1,2) and p2 is (2,3) then the coordinates of p1 will be changed to (3,2). */
		p1.setX(p3.getX());
		p1.setY(p3.getY());
		
		/* L- Write a statement to add 10 to both coordinates of p1.*/
		p1.moveBy(10);
		
		/* M- Write the necessary statements to compare the coordinates of points p1 and p2 and print “Same” 
		 * if they have the same coordinates and “Different” if they don’t have the same coordinates. */
		if(p1.equals(p2))
			System.out.println("Same");
		else
			System.out.println("Different");
		
	}

}
