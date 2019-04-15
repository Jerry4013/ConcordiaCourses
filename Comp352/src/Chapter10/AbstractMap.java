package Chapter10;

import java.util.Iterator;

public abstract class AbstractMap<K,V> implements Map<K,V> {
    public boolean isEmpty(){
        return size() == 0;
    }

    private class KeyIterator implements Iterator<K>{

        private Iterator<MapEntry<K,V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }

    }

    private class KeyIterable implements Iterable<K>{

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    public Iterable<K> keySet(){
        return new KeyIterable();
    }

    private class ValueIterator implements Iterator<V>{

        private Iterator<MapEntry<K,V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }
    }

    private class ValueIterable implements Iterable<V>{

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    public Iterable<V> values(){
        return new ValueIterable();
    }
}
