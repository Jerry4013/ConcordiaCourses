
public class C5P1_BookStore {
	private int storeID;
	private String category;
	private String author;
	private String title;
	private String publisher;
	private double price;
	private int quantity;
	private static int totalNumberSold;
	
	public C5P1_BookStore(int storeID, String category,String author, 
			String title,String publisher, double price, int quantity) 
	{
		if(storeID<=0)
		{
			System.out.print("Fatal error!");
			System.exit(0);
		}
		this.storeID = storeID;
		
		if(category!="Kids" && category!="Engineering" && category!="Story")
		{
			System.out.print("Fatal error!");
			System.exit(0);
		}
		this.category = category;
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		
		if(price<=0)
		{
			System.out.print("Fatal error!");
			System.exit(0);
		}
		this.price = price;
		
		if(quantity<=0)
		{
			System.out.print("Fatal error!");
			System.exit(0);
		}
		this.quantity = quantity;
	}
	
	public void sell(int numberOfSold)
	{
		quantity -= numberOfSold;
	}
	
	public static void trackSalesStatus()
	{
		System.out.println("The total number of books sold by the store: " 
				+ totalNumberSold);
	}
	
	public void quantity()
	{
		System.out.println("Quantity available: " + quantity);
	}
	
	public String toString()
	{
		return "ID: " + storeID + "\nCategory: " + category + " Author: " + author + " Title: " + title 
				+ "\nPublisher: " + publisher + " Price: " + price + " Quantity: " + quantity;
	}

}
