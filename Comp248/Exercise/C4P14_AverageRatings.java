
public class C4P14_AverageRatings {

	public static void main(String[] args) {
		
		C4P14_Ratings ratingFile1 = new C4P14_Ratings("G:\\workspace\\Exercise\\src\\ratings.txt");
		System.out.println(ratingFile1);
		System.out.println(ratingFile1.pridictRating());
	}
}
