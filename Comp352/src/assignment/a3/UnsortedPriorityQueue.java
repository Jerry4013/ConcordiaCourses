package assignment.a3;

import java.util.Iterator;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>
                                        implements Iterable{

    private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    public UnsortedPriorityQueue(){
        super();
    }

    private Position<Entry<K,V>> findMin(){
        Position<Entry<K,V>> small = list.first();
        for (Position<Entry<K,V>> walk : list.positions()) {
            if (compare(walk.getElement(), small.getElement()) < 0){
                small = walk;
            }
        }
        return small;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new Entry<>(key, value);
        list.addLast(newest);
        return newest;
    }

    @Override
    public Entry<K,V> min() {
        if (list.isEmpty()) {
            return null;
        }
        return findMin().getElement();
    }

    @Override
    public Entry<K,V> removeMin() {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(findMin());
    }

    public Iterator<Position<Entry<K,V>>> iterator(){
        LinkedPositionalList<Entry<K,V>> linkedList = (LinkedPositionalList<Entry<K,V>>)list;
        return linkedList.positions().iterator();
    }

}
