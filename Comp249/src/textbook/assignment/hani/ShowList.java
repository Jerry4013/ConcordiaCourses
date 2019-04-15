package assignment.hani;

import java.util.NoSuchElementException;

public class ShowList {
    private class ShowNode implements Cloneable {
        private TVShow show;
        private ShowNode link;

        public ShowNode() {
            show = null;
            link = null;
        }

        public ShowNode(TVShow show, ShowNode link) {
            this.show = show;
            this.link = link;
        }

        public ShowNode(ShowNode other){
            show = new TVShow(other.show);
            if(other.link==null)
                link = null;
            else{
                ShowNode position = other;
                position = position.link;
                link = new ShowNode(new TVShow(position.show), null);
                ShowNode end = link;
                position = position.link;
                while (position != null){
                    end.link = new ShowNode(new TVShow(position.show), null);
                    end = end.link;
                    position = position.link;
                }
            }
        }

        public Object clone(){
            try{
                ShowNode copy = (ShowNode)super.clone();
                if(show == null)
                    copy.show = null;
                else
                    copy.show = new TVShow(show);
                return copy;
            }catch(CloneNotSupportedException e){
                return null;
            }
        }

        public TVShow getShow() {
            return show;
        }

        public void setShow(TVShow show) {
            this.show = show;
        }

        public ShowNode getLink() {
            return link;
        }

        public void setLink(ShowNode link) {
            this.link = link;
        }
    }

    private ShowNode head;
    private int size;

    public ShowList() {
    }

    public ShowList(ShowList otherList){
        if (otherList == null)
            throw new NullPointerException();
        if (otherList.head == null){
            head = null;
            size = 0;
        }
        else {
            head = new ShowNode(otherList.head);
            size = otherList.size;
        }
    }

    public void addToStart(TVShow show){
        head = new ShowNode(new TVShow(show), head);
        size++;
    }

    public void insertAtIndex(TVShow show, int index){
        if(show == null || index<0 || index>size-1)
            throw new NoSuchElementException();
        if(index == 0)
            addToStart(new TVShow(show));
        else{
            ShowNode previous = findByIndex(index-1);
            previous.link = new ShowNode(new TVShow(show), findByIndex(index));
            size++;
        }
    }

    private ShowNode findByIndex(int index){
        if(index<0 || index>size-1)
            throw new NoSuchElementException();
        int count = 0;
        ShowNode position = head;
        while(count != index){
            position = position.link;
            count++;
        }
        return position;
    }

    public void deleteFromIndex(int index){
        if(head == null || index<0 || index>size-1)
            throw new NoSuchElementException();
        if(index == 0)
            head = head.link;
        else{
            ShowNode previous = findByIndex(index-1);
            previous.link = findByIndex(index+1);
        }
        size--;
    }

    public void deleteFromStart(){
        if (head != null){
            head = head.link;
            size--;
        }
        else
            System.out.println("No element in this list.");
    }

    public void replaceAtIndex(TVShow show, int index){
        if(show == null || index<0 || index>size-1)
            return;
        if(index == 0)
            head = new ShowNode(new TVShow(show), head.link);
        else{
            ShowNode previous = findByIndex(index-1);
            previous.link = new ShowNode(new TVShow(show), findByIndex(index).link);
        }
    }

    public ShowNode find(String showID){
        ShowNode position = head;
        while(position != null){
            if(position.show.getShowID().equals(showID))
                return position;
            position = position.link;
        }
        return null;
    }

    public TVShow findShow(String showID){
        return find(showID).getShow();
    }

    public boolean contains(String showID){
        return (find(showID) != null);
    }

    public boolean equals(ShowList otherList){
        if(otherList == null)
            return false;
        if (size!=otherList.size)
            return false;
        ShowNode position = head;
        ShowNode otherPosition = otherList.head;
        while(position != null){
            if (!(position.show.equals(otherPosition.show)))
                return false;
            position = position.link;
            otherPosition = otherPosition.link;
        }
        return true;
    }

}
