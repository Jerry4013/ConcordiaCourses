
public class T7Q1_ComputePi {

	public static void main(String[] args) {
		double pi=0;
		boolean version_a = false;
		if (version_a)
		{
			int negation = 1;
			for (int i=0; i<10000; i++)
				if (i%2==1)
				{
					pi = pi + 4 * negation * (1.0 / i);
					negation = negation * (-1);
				}
			System.out.println(pi);
		}
		else
		{
			int negation = 1;
			for (int i=1; i<=10000; i=i+2)
			{
				pi = pi + 4 * negation * 1.0 / i;
				negation = negation * (-1);
			}
			System.out.println(pi);
		}
	}
}
