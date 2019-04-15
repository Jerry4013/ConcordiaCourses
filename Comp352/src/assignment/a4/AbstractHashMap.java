package assignment.a4;

import java.util.ArrayList;

public abstract class AbstractHashMap extends AbstractMap {

    protected int n = 0;
    protected int capacity;
    protected int collision;

    /**
     * Constructor with a capacity
     * @param cap capacity
     */
    public AbstractHashMap(int cap){
        capacity = cap;
        createTable();
    }

    /**
     * default constructor
     */
    public AbstractHashMap( ) {
        this(128);
    }

    @Override
    public int size() {
        return n;
    }

    /**
     * If M does not have an entry with key equal to k, then adds entry
     * (k,v) to M and returns null; else, replaces with v the existing
     * value of the entry with key equal to k and returns the old value.
     * @param key the key to be put
     * @param value the value to be put
     * @return
     */
    @Override
    public String put(Integer key, String value) {
        long startTime, endTime, elapsed;
        startTime = System.nanoTime();
        String answer = bucketPut(key, value);
        System.out.println("The size of the table is: " + capacity);
        System.out.println("The number of elements in the table after this \"put\": " + n);
        System.out.println("Collision: " + collision + "\n");
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("Time: " + elapsed + " ns\n");
        return answer;
    }

    /**
     * Compute the hash value using the key
     * @param key the key
     * @return int value
     */
    public int hashValue(Integer key){
        MapEntry entry = new MapEntry(key, "");
        int h = entry.hashCode();
        return (Math.abs(h) % capacity);
    }

    /**
     * if the size reach some point of the capacity, resize the hash table and put all the values
     * in it again.
     * @param newCap the size of the table.
     */
    protected void resize(int newCap){
        ArrayList<MapEntry> buffer = new ArrayList<>(n);
        for (MapEntry e : entrySet()){
            buffer.add(e);
        }
        capacity = newCap;
        createTable();
        n = 0;
        for (MapEntry e : buffer)
            put(e.getKey(), e.getValue());
    }

    protected abstract void createTable();
    protected abstract String bucketPut(Integer k, String v);
}
