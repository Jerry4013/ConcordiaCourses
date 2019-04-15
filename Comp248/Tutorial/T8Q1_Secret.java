//Array before:
//n[0] = 4
//n[1] = 2

//Array after:
//n[0] = 2

public class T8Q1_Secret {

	public static void main(String[] args) {
		int[] n = {4, 2, 6, 12, 0, -4, 6, 3, 8, 1};
		System.out.println("Array before:"); 
		for (int i = 0; i < n.length; i++) 
		{
			System.out.println("n["+i+"] = " + n[i]);
		}
		boolean secretProperty = false; 
		while (!secretProperty) 
		{
			secretProperty = true;
			for (int i=0; i < (n.length-1); i++)
			{ 
				if (n[i] > n[i+1])
				{
					int temp = n[i]; n[i] = n[i+1]; n[i+1] = temp;
					secretProperty = false;
				}
			}
		}
		System.out.println(); 
		System.out.println("Array after:"); 
		for (int i = 0; i < n.length; i++) 
		{
			System.out.println("n["+i+"] = " + n[i]);
		}
	}

}
