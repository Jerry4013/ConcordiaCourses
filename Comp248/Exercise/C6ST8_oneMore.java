import java.util.Arrays;
public class C6ST8_oneMore {
	public static void oneMore(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
			arr[i] = arr[i]+1;
	}
	
	public static void main(String[] args){
		int[] a = {1, 2, 3};
		
		oneMore(a);
		System.out.print(Arrays.toString(a));
		
	}
}
