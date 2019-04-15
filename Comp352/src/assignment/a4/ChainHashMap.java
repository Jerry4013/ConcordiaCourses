package assignment.a4;

import java.util.ArrayList;

public class ChainHashMap extends AbstractHashMap {

    private UnsortedTableMap[] table;

    public ChainHashMap( ){
        super( );
    }

    public ChainHashMap(int cap){
        super(cap);
    }

    @Override
    protected void createTable() {
        table = new UnsortedTableMap[capacity];
    }

    /**
     * Returns the value v associated with key k, if such an entry exists;
     * otherwise returns null.
     * @param key key
     * @return see above
     */
    public String get(Integer key){
        long startTime, endTime, elapsed;
        startTime = System.nanoTime();
        int h = hashValue(key);
        System.out.println("hash value: " + h);
        UnsortedTableMap bucket = table[h];
        if (bucket == null) return null;
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("Time: " + elapsed + " ns\n");
        return bucket.get(key);
    }

    /**
     * If M does not have an entry with key equal to k, then adds entry
     * (k,v) to M and returns null; else, replaces with v the existing
     * value of the entry with key equal to k and returns the old value.
     * @param key the key to be put
     * @param value the value to be put
     * @return
     */
    public String bucketPut(Integer key, String value) {
        int h = hashValue(key);
        UnsortedTableMap bucket = table[h];
        if (bucket == null){
            bucket = table[h] = new UnsortedTableMap();
        } else {
            collision++;
        }
        int oldSize = bucket.size( );
        String answer = bucket.put(key,value);
        if ((bucket.size( ) - oldSize) > 0){
            n++;
        }
        if (n > capacity / 2)
            resize(2 * capacity );
        System.out.println("The number of items in this bucket: " + bucket.size());
        return answer;
    }

    /**
     * Removes from M the entry with key equal to k, and returns its
     * value; if M has no such entry, then returns null.
     * @param key key
     * @return see above
     */
    public String remove(Integer key){
        long startTime, endTime, elapsed;
        startTime = System.nanoTime();
        int h = hashValue(key);
        UnsortedTableMap bucket = table[h];
        if (bucket == null){
            return null;
        }
        int oldSize = bucket.size( );
        String answer = bucket.remove(key);
        if ((oldSize - bucket.size()) > 0){
            n--;
        }
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("Time: " + elapsed + " ns\n");
        return answer;
    }

    @Override
    public Iterable<MapEntry> entrySet() {
        ArrayList<MapEntry> buffer = new ArrayList<>( );
        for (int h = 0; h < capacity; h++){
            if (table[h] != null)
                for (MapEntry entry : table[h].entrySet( ))
                    buffer.add(entry);
        }
        return buffer;
    }
}
