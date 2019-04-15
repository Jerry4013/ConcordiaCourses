package chapter15;

public class Queue {
    private class Node{
        private String item;
        private Node link;

        public Node (){
            item = null;
            link = null;
        }

        public Node (String newItem, Node linkValue){
            item = newItem;
            link = linkValue;
        }
    }


    private Node front;
    private Node back;

    public Queue () {
        front = null;
        back = null;
    }

    public void addToBack (String itemName){
        if (front == null) {
            back = new Node(itemName, null);
            front = back;
        } else {
            back.link = new Node(itemName, null);
            back = back.link;
        }
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void clear(){
        front = null;
        back = null;
    }

    public String whoIsNext( ){
        if (front == null)
            return null;
        else
            return front.item;
    }

    public boolean removeFront( ){
        if (front != null){
            front = front.link;
            return true;
        }else
            return false;
    }
}
