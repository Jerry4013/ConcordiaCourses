
public class T6Q5_SmallestPositiveInteger {

	public static void main(String[] args) {
		int i=1;
		boolean notFound = true;
		while(notFound)
		{
			if(i%3==1&&i%5==2&&i%7==3)
			{
				notFound = false;
				break;
			}
			i++;
		}
		System.out.println(i);
	}

}
