import java.util.Random;
public class C3P11_Prize {

	public static void main(String[] args) {
		Random selection = new Random();
		int finallist1, finallist2, finallist3;
		finallist1 = selection.nextInt(30)+1;
		do
		{
			finallist2 = selection.nextInt(30)+1;
		}while(finallist2 == finallist1);
		
		do
		{
			finallist3 = selection.nextInt(30)+1;
		}while(finallist3==finallist2||finallist3==finallist1);
		
		System.out.println("The selected finalists are: "+ finallist1 + ", " + finallist2 + ", " + finallist3);
		
	}

}
