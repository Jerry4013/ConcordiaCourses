package assignment.a3;


import java.util.Iterator;

public class Test {
    public static void main(String[] args) {

        ArrayHeapPriorityQueue<Integer, Character> queue = new ArrayHeapPriorityQueue<>();
        queue.insert(20,'B');
        queue.insert(4,'C');
        queue.insert(5,'Z');
        queue.insert(5,'A');
        queue.insert(15,'K');
        queue.insert(9,'F');
        queue.insert(7,'Q');
        queue.insert(16,'X');
        System.out.println(queue);
        queue.replace(5, 2,'W');
        System.out.println(queue);

        Iterator<Entry<Integer, Character>> iterator = queue.iterator();
        while (iterator != null && iterator.hasNext()) {
            Entry<Integer, Character> entry = iterator.next();
            System.out.println(entry);
        }

    }
}
