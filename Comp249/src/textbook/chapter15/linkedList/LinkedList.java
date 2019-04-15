package chapter15.linkedList;

public class LinkedList<T extends PubliclyCloneable> implements PubliclyCloneable {
    private class Node<T> {
        private T data;
        private Node<T> link;

        public Node(){
            data = null;
            link = null;
        }

        public Node(T data, Node<T> link){
            this.data = data;
            this.link = link;
        }
    }

    private Node<T> head;

    public LinkedList(){
        head = null;
    }

    public LinkedList(LinkedList<T> otherList){
        if (otherList == null)
            throw new NullPointerException();
        if (otherList.head == null) {
            head = null;
        }else
            head = copyOf(otherList.head);
    }

    public LinkedList<T> clone(){
        try {
            LinkedList<T> copy = (LinkedList<T>) super.clone();
            if (head == null)
                copy.head = null;
            else
                copy.head = copyOf(head);
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }


    private Node<T> copyOf(Node<T> otherHead){
        Node<T> position = otherHead;
        Node<T> newHead = new Node<T>((T)position.data.clone(), null);
        Node<T> end = null;
        end = newHead;
        position = position.link;
        while (position != null) {
            end.link = new Node<T>((T)(position.data).clone(), null);
            end = end.link;
            position = position.link;
        }
        return newHead;
    }
}
