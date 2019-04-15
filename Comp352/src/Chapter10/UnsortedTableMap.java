package Chapter10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {

    private ArrayList<MapEntry<K,V>> table = new ArrayList<>( );

    public UnsortedTableMap( ) { }

    private int findIndex(K key) {
        int n = table.size();
        for (int i = 0; i < n; i++) {
            if (table.get(i).getKey().equals(key))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) return null;
        return table.get(j).getValue();
    }

    @Override
    public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1){
            table.add(new MapEntry<>(key, value));
            return null;
        } else {
            return table.get(j).setValue(value);
        }
    }

    @Override
    public V remove(K key) {
        int j = findIndex(key);
        int n = size();
        if (j == -1) return null;
        V answer = table.get(j).getValue();
        if (j != n - 1){
            table.set(j, table.get(n - 1));
        }
        table.remove(n - 1);
        return answer;
    }

    private class EntryIterator implements Iterator<MapEntry<K,V>> {
        private int j = 0;

        @Override
        public boolean hasNext() {
            return j < table.size( );
        }

        @Override
        public MapEntry<K, V> next() {
            if (j == table.size( )) throw new NoSuchElementException( );
            return table.get(j++);
        }
    }

    private class EntryIterable implements Iterable<MapEntry<K,V>>{
        @Override
        public Iterator<MapEntry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    @Override
    public Iterable<MapEntry<K, V>> entrySet() {
        return new EntryIterable( );
    }
}
