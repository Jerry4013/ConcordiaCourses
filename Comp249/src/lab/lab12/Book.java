package lab.lab12;

public class Book implements Comparable<Book>, Cloneable{
	private double price;
	private String title;
	
	public Book(){}
	/**
	 * @param price
	 * @param title
	 */
	public Book(double price, String title) {
		super();
		this.price = price;
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	public int compareTo(Book book){
		return (int) (price-book.price);
	}
	
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	@Override
	public String toString() {
		return "price=" + price + ", title=" + title;
	}

	

	
	
}
