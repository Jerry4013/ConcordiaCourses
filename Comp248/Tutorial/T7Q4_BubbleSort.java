import java.util.Arrays;

public class T7Q4_BubbleSort {

	public static void main(String[] args) {
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length - i - 1; j++) {
				if(a[j] > a[j + 1]) { // swap if a[j] > a[j + 1] 
					int tmp = a[j];
					a[j]= a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		System.out.println(Arrays.toString(a));
	}

}
