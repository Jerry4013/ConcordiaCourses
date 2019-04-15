package chapter15;

public class Set<T> {
    private class Node<T>{
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

    public Set(){
        head = null;
    }

    public boolean add(T newItem){
        if (!contains(newItem)){
            head = new Node<T>(newItem, head);
            return true;
        }
        return false;
    }

    public boolean contains(T item){
        Node<T> position = head;
        T itemAtPosition;
        while (position != null){
            itemAtPosition = position.data;
            if (itemAtPosition.equals(item))
                return true;
            position = position.link;
        }
        return false;
    }

    public void output(){
        Node position = head;
        while (position != null) {
            System.out.println(position.data.toString() + " ");
            position = position.link;
        }
        System.out.println();
    }

    public Set<T> union(Set<T> otherSet){
        Set<T> unionSet = new Set<T>();
        Node<T> position = head;
        while (position != null) {
            unionSet.add(position.data);
            position = position.link;
        }
        position = otherSet.head;
        while (position != null) {
            unionSet.add(position.data);
            position = position.link;
        }
        return unionSet;
    }

    public Set<T> intersection(Set<T> otherSet){
        Set<T> interSet = new Set<T>( );
        Node<T> position = head;
        while (position != null) {
            if (otherSet.contains(position.data)){
                interSet.add(position.data);
            }
            position = position.link;
        }
        return interSet;
    }

    public Set<T> difference(Set<T> otherSet){
        Set<T> differentSet = new Set<T>( );
        Node<T> position = head;
        while (position != null) {
            if (!otherSet.contains(position.data)){
                differentSet.add(position.data);
            }
            position = position.link;
        }
        return differentSet;
    }

}
