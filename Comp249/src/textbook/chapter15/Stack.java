package chapter15;

public class Stack {
    private class Node{
        private String item;
        private Node link;

        public Node(){
            item = null;
            link = null;
        }

        public Node(String newItem, Node linkValue){
            item = newItem;
            link = linkValue;
        }
    }

    private Node head;

    public Stack(){
        head = null;
    }

    public void push(String item){
        head = new Node(item, head);
    }

    public String pop(){
        if (head == null)
            throw new IllegalStateException();
        else {
            String toReturn = head.item;
            head = head.link;
            return toReturn;
        }
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public String peek(){
        if (head == null)
            return null;
        else {
            return head.item;
        }
    }
}
