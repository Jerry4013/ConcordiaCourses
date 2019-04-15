package textbook.chapter15;

public class GenericLinkedListDemo {

	public static void main(String[] args) {

		LinkedList<Entry> list = new LinkedList<Entry>();
		Entry e1 = new Entry("Apple", 1);
		list.addToStart(e1);
		Entry entry2 = new Entry("Bananas", 2);
		list.addToStart(entry2);
		Entry entry3 = new Entry("Cantaloupe", 3);
		list.addToStart(entry3);
		System.out.println("List has " + list.size() + " nodes.");

		list.outputList();
		System.out.println("End of list.");
		
		entry3.setItem("Canta");
		list.outputList();
		
	}

}
