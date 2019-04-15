package chapter15.linkedList;

import java.util.NoSuchElementException;

public class LinkedList2 {
    private class Node{
        private String item;
        private Node link;

        public Node(){
            item = null;
            link = null;
        }

        public Node(String item, Node link){
            this.item = item;
            this.link = link;
        }
    }

    public class List2Iterator{
        private Node position;
        private Node previous;

        public List2Iterator(){
            position = head;
            previous = null;
        }

        public void restart(){
            position = head;
            previous = null;
        }

        public String next(){
            if (position == null){
                throw new NoSuchElementException();
            }
            String toReturn = position.item;
            previous = position;
            position = position.link;
            return toReturn;
        }

        public boolean hasNext(){
            return (position != null);
        }

        public String peek(){
            if (!hasNext())
                throw new IllegalStateException( );
            return position.item;
        }

        public void addHere(String newData){
            if (position == null && previous != null)
                previous.link = new Node(newData, null);
            else if (position == null || previous == null){
                LinkedList2.this.addToStart(newData);
                position = head;
            }else{
                Node temp = new Node(newData, position);
                previous.link = temp;
                previous = temp;
            }
        }

        public void delete(){
            if (position == null) {
                throw new IllegalStateException();
            } else if (previous == null) {
                head = head.link;
                position = head;
            } else {
                previous.link = position.link;
                position = position.link;
            }
        }

        public void changeHere(String newData) {
            if (position == null)
                throw new IllegalStateException();
            else
                position.item = newData;
        }
    }

    private Node head;

    public List2Iterator iterator(){
        return new List2Iterator();
    }

    public LinkedList2(){
        head = null;
    }

    public void addToStart(String itemName){
        head = new Node(itemName, head);
    }

    public boolean deleteHeadNode(){
        if(head != null){
            head = head.link;
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        int count = 0;
        Node position = head;
        while (position != null){
            count++;
            position = position.link;
        }
        return count;
    }

    public boolean contains(String item){
        return (find(item) != null);
    }

    private Node find(String target){
        Node position = head;
        while (position != null){
            if(position.item.equals(target)){
                return position;
            }
            position = position.link;
        }
        return null;
    }

    public void outputList(){
        Node position = head;
        while (position != null){
            System.out.println(position.item);
            position = position.link;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void clear(){
        head = null;
    }


}
