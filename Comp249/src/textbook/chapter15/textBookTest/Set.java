package chapter15.textBookTest;

public class Set<T> {

    private class Node<T>{
        private T data;
        private Node<T> link;

        private Node(){
            data = null;
            link  = null;
        }

        public Node(T data, Node<T> link) {
            this.data = data;
            this.link = link;
        }
    }

    private Node<T> head;

    public Set(){
        head = null;
    }

    public boolean add (T newItem){
        if(!contains(newItem)){
            head = new Node<T> (newItem, head);
            return true;
        }
        return false;
    }

    public boolean contains(T item){
        Node<T> position = head;
        T itemAtPosition;
        while(position!=null){
            itemAtPosition = position.data;
            if (itemAtPosition.equals(item))
                return true;
            position = position.link;
        }
        return false;
    }

    public void output(){
        Node<T> position = head;

        while(position!=null){
            System.out.println(position.data + " ");
            position = position.link;
        }
        System.out.println();
    }

    public Set<T> union(Set<T> otherSet){
        Set<T> unionSet = new Set<>();
        Node<T> position = head;
        while (position!=null){
            unionSet.add(position.data);
            position = position.link;
        }
        position = otherSet.head;

        while (position!=null){
            unionSet.add(position.data);
            position = position.link;
        }

        return unionSet;
    }

    public Set<T>  intersection(Set<T> otherSet){
        Set<T> intersection = new Set<>();
        Node<T> position = head;
        while(position!=null){
            if(otherSet.contains(position.data)){
                intersection.add(position.data);
            }
            position = position.link;
        }

        return intersection;
    }


}
