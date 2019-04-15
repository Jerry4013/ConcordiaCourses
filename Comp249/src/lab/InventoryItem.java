package lab;

import java.io.Serializable;

public class InventoryItem  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String description;
	private double price;
	private int inStock;
	
	
	public InventoryItem(){}
	/**
	 * @param id
	 * @param description
	 * @param price
	 * @param inStock
	 */
	public InventoryItem(long id, String description, double price, int inStock) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
	}
	
	@Override
	public String toString() {
		return "InventoryItem [id=" + id + ", description=" + description + ", price=" + price + ", inStock=" + inStock
				+ "]";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + inStock;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryItem other = (InventoryItem) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (inStock != other.inStock)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	
	
	
}
