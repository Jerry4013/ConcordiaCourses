package Chapter3;

public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(6);
        list.addLast(7);
        list.addLast(3);
        list.addLast(8);
        list.addLast(4);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
