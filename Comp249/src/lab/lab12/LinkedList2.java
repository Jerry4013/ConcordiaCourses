package lab.lab12;

public class LinkedList2 {
	
	private class Node{
		private Book book;
		private Node next;
		
		@SuppressWarnings("unused")
		public Node(){
			book = null;
			next = null;
		}
		/**
		 * @param book
		 * @param next
		 */
		public Node(Book book, Node next) {
			super();
			this.book = book;
			this.next = next;
		}
		@Override
		public String toString() {
			return book.toString();
		}
	}
	
	Node head;
	int size;
	
	
	public void insert(Book book){
		if(book==null){
			System.out.println("Cannot insert a null object.");
			System.exit(0);
		}
		if(head==null){
			head = new Node(book, head);
			size = 1;
		}
		else if(head.next==null){
			if(book.compareTo(head.book)>0)
				head.next = new Node((Book) book.clone(), null);
			else
				head = new Node((Book) book.clone(), head);
			size = 2;
		}
		else {
			Node position = head;
			while(position.next!=null){
				if(book.compareTo(position.book) < 0){
					head = new Node((Book) book.clone(), head);
					return;
				}
				else if(book.compareTo(position.next.book)<0)
				{
					position.next = new Node((Book) book.clone(), position.next);
					return;
				}
				position = position.next;
			}
			position.next = new Node((Book) book.clone(), null);
		}
	}
	
	public void remove(Book book){
		if(head==null)
			return;
		else if(head.next==null){
			if(head.book.equals(book)){
				head = null;
				return;
			}
		}else{
			Node position = head;
			while(position.next!=null){
				if(position.next.book.equals(book)){
					position.next = position.next.next;
					return;
				}
				position = position.next;
			}
		}
	}
	
	public String toString(){
		String list = "";
		Node position = head;
		while(position!=null){
			list += position.book.toString() + "\n";
			position = position.next;
		}
		return list;
	}
}









