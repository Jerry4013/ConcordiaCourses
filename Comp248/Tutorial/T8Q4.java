
public class T8Q4 {

	public static void main(String[] args) {
		int [] x = {0,0,1,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1,
				1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1,
				1,1,1,1,1, 1,1,1,1,1}; // x has 50 elements
				int i, t;
				for (i=2; i<8; i++) 				// line 1 
					if (x[i]!=0) 					// line 2
					{ 								
						System.out.print(i+ " "); 	// line 3 – for question A 
						t=2*i; 						// line 4
						while (t<50)
						{ 							// line 5 
							x[t]=0; 				// line 6
							t+=i; 					// line 7
						}
					}
				System.out.println(); 				// line 8 – for question B
				for (i=2; i<50; i++) 
					if (x[i]!=0)
				System.out.println(i);
	}

}
