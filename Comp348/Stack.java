import java.util.*;
public class Stack {
	private ArrayList<String> stack = new ArrayList<String>();
	protected int top = -1;
	public void push (String str) {
		stack.add(++top, str);
	}
	
	public String pop() {
		if(!this.isEmpty()) {
			String result = stack.get(top--);
			return result;
		} else {
			return null;
		}
	}
	
	public String top() {
		if(!this.isEmpty()) {
			String result = stack.get(top);
			return result;
		} else {
			return null;
		}
	}
	
	protected boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return (top + 1);
	}
	
}
