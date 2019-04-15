package textbook.chapter15;

public class LinkedList<T extends PubliclyCloneable> implements PubliclyCloneable{
	@SuppressWarnings("hiding")
	private class Node<T>{
		private T data;
		private Node<T> link;
		
		@SuppressWarnings("unused")
		public Node (){
			data = null;
			link = null;
		}
		
		public Node (T newData, Node<T> linkValue){
			data = newData;
			link = linkValue;
		}
	}
	private Node<T> head;
	
	public LinkedList(){
		head = null;
	}
	
	public LinkedList(LinkedList<T> otherList){
		if (otherList == null)
			throw new NullPointerException();
		if (otherList.head == null)
			head = null;
		else head = copyOf(otherList.head);
	}
	
	public LinkedList<T> clone(){
		try{
			@SuppressWarnings("unchecked")
			LinkedList<T> copy = (LinkedList<T>)super.clone();
			if(head == null)
				copy.head= null;
			else copy.head = copyOf(head);
			return copy;
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private Node<T> copyOf(Node<T> otherHead) {
		Node<T> position = otherHead;
		Node<T> newHead;
		Node<T> end = null;
		
		newHead = new Node<T>((T)(position.data).clone(), null);
		end = newHead;
		position = position.link;
		
		while (position != null){
			end.link = new Node<T>((T)(position.data).clone(), null);
			end = end.link;
			position = position.link;
		}
		
		return newHead;
	}

	public void addToStart(T itemData){
		head = new Node<T> (itemData, head);
	}
	
	public boolean deleteHeadNode(){
		if (head != null){
			head = head.link;
			return true;
		}
		else
			return false;
	}
	
	public int size(){
		int count = 0;
		Node<T> position = head;
		while(position != null){
			count++;
			position = position.link;
		}
		return count;
	}
	
	public boolean contains(T item){
		return (find(item) != null);
	}
	
	private Node<T> find (T target){
		Node<T> position = head;
		T itemAtPosition;
		while(position != null){
			itemAtPosition = position.data;
			if (itemAtPosition.equals(target))
				return position;
			position  = position.link;
		}
		return null;
	}
	
	public T findData(T target){
		Node<T> result = find (target);
		if(result == null)
			return null;
		else return result.data;
	}
	
	public void outputList(){
		Node<T> position = head;
		while (position != null){
			System.out.println(position.data);
			position = position.link;
		}
	}
	
	public boolean isEmpty(){
		return (head == null);
	}
	
	public void clear(){
		head = null;
	}
	
	public boolean equals(Object otherObject){
		if(otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		@SuppressWarnings("unchecked")
		LinkedList<T> otherList = (LinkedList<T>)otherObject;
		if (size()!=otherList.size())
			return false;
		Node<T> position = head;
		Node<T> otherPosition = otherList.head;
		while(position != null){
			if (!(position.data.equals(otherPosition.data)))
				return false;
			position = position.link;
			otherPosition = otherPosition.link;
		}
		return true;
	}
	
	public String toString(){
		Node<T> position = head;
		String theString = "";
		while (position != null){
			theString += position.data + "\n";
			position = position.link;
		}
		return theString;
	}
}



























