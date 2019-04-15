
public class T5Q3f {

	public static void main(String[] args) {
		int i=5, count=0;
		while (i!=1)
		{
			System.out.println(count + " " + i);
			count++;
			if ((i%2) == 0)
				i/=2;
			else
				i= 3*i+1;
		}
	}

}
