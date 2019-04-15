package chapter15.linkedList;


public class LinkedList3<T> implements Cloneable{
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

    public LinkedList3(){
        head = null;
    }

    public void addToStart(T data){
        head = new Node<T>(data, head);
    }

    public boolean deleteHeadNode( ){
        if (head != null){
            head = head.link;
            return true;
        }
        return false;
    }

    public int size( ){
        int count = 0;
        Node<T> position = head;
        while (position != null) {
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean contains(T target){
        return (find(target) != null);
    }

    private Node find(T target){
        Node<T> position = head;
        while (position != null) {
            if (position.data.equals(target)){
                return position;
            }
            position = position.link;
        }
        return null;
    }

    public T findData(T target){
        Node<T> result = find(target);
        if (result == null){
            return null;
        }else{
            return result.data;
        }
    }

    public void outputList( ){
        Node<T> position = head;
        while (position != null) {
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

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;
        if (getClass() != otherObject.getClass())
            return false;
        LinkedList3<T> otherList = (LinkedList3<T>) otherObject;
        if (size() != otherList.size())
            return false;
        Node<T> position = head;
        Node<T> otherPosition = otherList.head;
        while (position != null) {
            if (!(position.data.equals(otherPosition.data)))
                return false;
            position = position.link;
            otherPosition = otherPosition.link;
        }
        return true;
    }

    public LinkedList3(LinkedList3<T> otherList){
        if (otherList == null) {
            throw new NullPointerException();
        }
        if (otherList.head == null) {
            head = null;
        }else
            head = copyOf(otherList.head);
    }


    public LinkedList3<T> clone(){
        try {
            LinkedList3<T> copy = (LinkedList3<T>)super.clone();
            if (head == null) {
                copy.head = null;
            }else
                copy.head = copyOf(head);
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private Node<T> copyOf(Node<T> otherHead){
        Node<T> position = otherHead;
        Node<T> newHead;
        Node<T> end = null;

        newHead = new Node<T>(position.data, null);
        end = newHead;
        position = position.link;

        while (position != null) {
            end.link = new Node<T>(position.data, null);
            end = end.link;
            position = position.link;
        }
        return newHead;
    }
}

