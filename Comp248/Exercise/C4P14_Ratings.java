import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
public class C4P14_Ratings {
	
	private char[] product;
	private int[][] ratings;
	private int numberOfProducts;
	private int numberOfLines;
	private double[] averageRating;
	private Scanner fileIn = null;
	
	public C4P14_Ratings(String newRatingFilePath)
	{
		setProductAndRatings(newRatingFilePath);
	}
	
	public void setProductAndRatings(String newRatingFilePath)
	{
		setProducts(newRatingFilePath);
		setRatings(newRatingFilePath);
	}
	
	public void setNumberOfProducts(String newRatingFilePath)
	{
		setFileIn(newRatingFilePath);
		String productNameString = fileIn.nextLine();
		StringTokenizer st = new StringTokenizer(productNameString," ,");
		numberOfProducts = st.countTokens();
	}
	
	public void setProducts(String newRatingFilePath)
	{
		setNumberOfProducts(newRatingFilePath);
		setFileIn(newRatingFilePath);
		String productNameString = fileIn.nextLine();
		StringTokenizer st = new StringTokenizer(productNameString," ,");
		String singleProductString;
		product = new char[numberOfProducts];
		for(int i=0; i<numberOfProducts; i++)
		{
			singleProductString = st.nextToken();
			product[i] = singleProductString.charAt(0);
		}
	}
	
	public void setRatings(String newRatingFilePath)
	{
		setFileIn(newRatingFilePath);
		setNumberOfProducts(newRatingFilePath);
		while(fileIn.hasNextLine())
		{
			numberOfLines++;
			fileIn.nextLine();
		}
		setFileIn(newRatingFilePath);
		fileIn.nextLine();
		String[] ratingString = new String[numberOfLines];
		ratings = new int[numberOfLines][numberOfProducts];
		for (int i=0; i<numberOfLines; i++)
		{
			ratingString[i] = fileIn.nextLine();
			StringTokenizer st = new StringTokenizer(ratingString[i]," ,");
			for (int j=0; j<numberOfProducts; j++)
				ratings[i][j] = getIntNumber(st.nextToken());
		}
	}
	
	public void computeAverage()
	{
		averageRating = new double[numberOfProducts];
		for(int j=0; j<numberOfProducts; j++)
		{
			double sum=0;
			int nonZeroLines=0;
			for(int i=0; i<numberOfLines; i++)
				if(ratings[i][j]!=0)
				{
					sum = sum + ratings[i][j];
					nonZeroLines++;
				}
			averageRating[j] = sum / nonZeroLines;
		}	
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("0.0");
		String displayedString = "";
		for (int i=0; i<numberOfProducts; i++)
			displayedString = displayedString + product[i] + "\t";
		displayedString = displayedString + "\n----------------------------------\n";
		for (int i=0; i<numberOfLines; i++)
		{
			for (int j=0; j<numberOfProducts; j++)
				displayedString = displayedString + ratings[i][j] + "\t";
			displayedString = displayedString + "\n";
		}
		displayedString = displayedString + "----------------------------------\n";
		computeAverage();
		for(int i=0; i<numberOfProducts; i++)
			displayedString = displayedString + df.format(averageRating[i]) + "\t";
		return displayedString;
	}
	
	public int pridictRating()
	{
		int[] newRatings = new int[5];
		double similarity;
		double min_similarity= 1000000;
		int similarCustomer = 0;
		int pridiction;
		Scanner keyIn = new Scanner(System.in);
		System.out.println("Please enter your ratings for the first four products: ");
		for(int i=0; i<4; i++)
			newRatings[i] = keyIn.nextInt();
		for(int i=0; i<numberOfLines; i++)
		{
			similarity = 0;
			for (int j=0; j<4; j++)
				similarity = similarity + Math.abs(ratings[i][j]-newRatings[j]);
			if(similarity < min_similarity)
			{
				min_similarity = similarity;
				similarCustomer = i;
			}
		}
		pridiction = ratings[similarCustomer][4];
		keyIn.close();
		return pridiction;
	}
	
	private int getIntNumber(String stringNumber)
	{
		switch(stringNumber)
		{
		case "0":
			return 0;
		case "1":
			return 1;
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		default:
			return -1;
		}
	}
	
	private void setFileIn(String newRatingFilePath)
	{
		try
		{
			fileIn = new Scanner(new FileInputStream(newRatingFilePath));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not Found!");
			System.exit(0);
		}
	}
	
}
