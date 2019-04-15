package Chapter10;

import java.util.ArrayList;

public abstract class AbstractHashMap<K,V>  extends AbstractMap<K,V> {

    protected int n = 0;
    protected int capacity;
    protected int collision;
    public AbstractHashMap(int cap){
        capacity = cap;
        createTable();
    }

    public AbstractHashMap( ) {
        this(128);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    @Override
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        System.out.println("The size of the table is: " + size());
        System.out.println("The number of elements in the table after this \"put\": " + n);
        System.out.println("Collision: " + collision);
        if (n > capacity / 2)
            resize(2 * capacity - 1);
        return answer;
    }

    private int hashValue(K key){
        return (Math.abs(key.hashCode()) % capacity);
    }

    @Override
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    private void resize(int newCap){
        ArrayList<MapEntry<K,V>> buffer = new ArrayList<>(n);
        for (MapEntry<K,V> e : entrySet()){
            buffer.add(e);
        }
        capacity = newCap;
        createTable();
        n = 0;
        for (MapEntry<K,V> e : buffer)
            put(e.getKey(), e.getValue());
    }

    protected abstract void createTable();
    protected abstract V bucketGet(int h, K k);
    protected abstract V bucketPut(int h, K k, V v);
    protected abstract V bucketRemove(int h, K k);
}
