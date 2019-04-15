package assignment.a4;

import java.util.Iterator;

public abstract class AbstractMap implements Map {
    public boolean isEmpty(){
        return size() == 0;
    }

    private class KeyIterator implements Iterator<Integer>{

        private Iterator<MapEntry> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public Integer next() {
            return entries.next().getKey();
        }

    }

    private class KeyIterable implements Iterable<Integer>{

        @Override
        public Iterator<Integer> iterator() {
            return new KeyIterator();
        }
    }

    public Iterable<Integer> keySet(){
        return new KeyIterable();
    }

    private class ValueIterator implements Iterator<String>{

        private Iterator<MapEntry> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public String next() {
            return entries.next().getValue();
        }
    }

    private class ValueIterable implements Iterable<String>{

        @Override
        public Iterator<String> iterator() {
            return new ValueIterator();
        }
    }

    public Iterable<String> values(){
        return new ValueIterable();
    }
}
