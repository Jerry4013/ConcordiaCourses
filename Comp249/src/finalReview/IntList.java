package finalReview;

public class IntList {
	private class Node{
		private int n;
		private Node next;
		
		@SuppressWarnings("unused")
		public Node(){
			
		}
		public Node(int n, Node next){
			this.n = n;
			this.next = next;
		}
		
		
	}
	
	private Node head;
	
	public boolean swap(int m, int n){
		if(head==null){
			System.out.println("no element.");
			return false;
		}
		if(head.next==null){
			System.out.println("only one element, cannot swap.");
			return false;
		}
		Node position1 = head;
		Node position2 = head;
		while(position1!=null && position1.n!= m)
			position1 = position1.next;
		if(position1==null){
			System.out.println("Cannot find the first number");
			return false;
		}
		while(position2!=null && position2.n!=n)
			position2 = position2.next;
		if(position2==null){
			System.out.println("Cannot find the second number");
			return false;
		}
		int temp = position1.n;
		position1.n = position2.n;
		position2.n = temp;
		return true;
	}
	
	public void removeAll(int n){
		if(head==null){
			System.out.println("nothing to remove");
			return;
		}
		if (head.n==n)
			head = head.next;
		Node position = head;
		while(position.next!=null){
			if(position.next.n != n)
				position = position.next;
			else
				position.next = position.next.next;
		}
	}
	
	public boolean remove(int n){
		if(head == null)
			return false;
		if (head.n==n){
			head = head.next;
			return true;
		}
		Node position = head;
		while (position.next!=null && position.next.n!=n){
			position = position.next;
		}
		if(position.next==null)
			return false;
		position.next = position.next.next;
		return true;
	}
	
	public void addToStart(int n){
		head = new Node(n, head);
	}
	
	public void addToEnd(int n){
		if(head==null)
			addToStart(n);
		else{
			Node position = head;
			while(position.next!=null){
				position = position.next;
			}
			position.next = new Node(n, null);
		}
	}
	
	public Node find(int x){
		if (head == null)
			return null;
		Node position = head;
		while(position!= null && position.n!=x){
			position = position.next;
		}
		if(position==null)
			return null;
		return position;
	}
	
	public void outputList(){
		if(head == null){
			System.out.println("no element in this list");
			return;
		}
				
		Node position = head;
		while(position!=null){
			if(position.next != null)
				System.out.print(position.n + "--->");
			else
				System.out.print(position.n);
			position = position.next;
		}
	}
}
