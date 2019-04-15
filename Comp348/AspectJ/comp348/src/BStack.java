
public class BStack extends Stack {
	private int capacity;

	public BStack(int capacity) {
		this.capacity = capacity;
	}
	
	public void push(String str) {
		if(!this.isFull()) {
			super.push(str);
		} 
	}
	
	private boolean isFull() {
		return top == (capacity - 1);
	}
	

}
