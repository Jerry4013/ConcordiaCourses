
public class RandomSequence {
		
	public static int[] generateRandomSequence(int numberOfItems)
	{
		int[] a = new int[numberOfItems];
		int[] temp = new int[numberOfItems];
		int[] newTemp;
		int randomIndex;
		
		for (int i=0; i<numberOfItems; i++)
		{
			temp[i] = i;
			randomIndex = (int)(Math.random()*temp.length);
			a[i] = temp[randomIndex];
			for(int j=randomIndex+1; j<temp.length; j++)
				temp[j-1] = temp[j];
			newTemp = new int[temp.length-1];
			for(int j=0; j<newTemp.length;j++)
				newTemp[j] = temp[j];
			temp = newTemp;
		}
		return a;
	}

}
