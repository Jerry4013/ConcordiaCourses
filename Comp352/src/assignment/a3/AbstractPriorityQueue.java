package assignment.a3;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    private Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;
    }

    protected AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    protected int compare(Entry<K,V> a, Entry<K,V> b){
        return comp.compare(a.getKey(),b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException{
        try {
            return (comp.compare(key,key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
