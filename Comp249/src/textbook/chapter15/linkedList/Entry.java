package chapter15.linkedList;


public class Entry {
    private String item;
    private int count;

    public Entry(String item, int count) {
        this.item = item;
        this.count = count;
    }

    public String toString(){
        return (item + " " + count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return count == entry.count &&
                item.equals(entry.item);
    }




}
