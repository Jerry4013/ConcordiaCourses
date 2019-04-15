package assignment.a4;

import java.util.ArrayList;

public abstract class OpenAddressingHashMap extends AbstractHashMap {

    private MapEntry[] table;
    private MapEntry DEFUNCT = new MapEntry(null, null);
    public OpenAddressingHashMap( ) { super( ); }
    public OpenAddressingHashMap(int cap) { super(cap); }

    @Override
    protected void createTable() {
        table = new MapEntry[capacity];
    }

    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    private int findSlot(Integer key){
        int avail = -1;
        int h = hashValue(key);
        int j = h;
        int counter = 0;
        do{
            if (isAvailable(j)){
                if (avail == -1) avail = j;
                if (table[j] == null) break;
            } else if (table[j].getKey().equals(key)){
                return j;
            }
            counter++;
            j = nextSearch(j, counter);
        } while (j != h);
        return -(avail + 1);
    }

    protected abstract int nextSearch(int j, int counter);

    /**
     * If M does not have an entry with key equal to k, then adds entry
     * (k,v) to M and returns null; else, replaces with v the existing
     * value of the entry with key equal to k and returns the old value.
     * @param key the key to be put
     * @param value the value to be put
     * @return
     */
    @Override
    protected String bucketPut(Integer key, String value) {
        int h = hashValue(key);
        System.out.println("hash value: " + h);
        int j = h;
        int avail = -1;
        int probingAttempts = 0;
        do{
            if (isAvailable(j)){
                if (avail == -1) avail = j;
                if (table[j] == null) break;
            }
            if (table[j].getKey().equals(key)){
                System.out.println("We have probed " + probingAttempts +
                        " times before adding the element.");
                return table[j].setValue(value);
            }
            probingAttempts++;
            j = nextSearch(j, probingAttempts);
            System.out.println("Trying: " + j);
        } while (j != h);
        if (table[h] != null && table[h].getKey() != null && !table[h].getKey().equals(key)){
            collision++;
        }
        if (avail != -1)
            table[avail] = new MapEntry(key, value);
        System.out.println("We have probed " + probingAttempts +
                " times before adding the element.");
        n++;
        return null;
    }

    /**
     * Returns the value v associated with key k, if such an entry exists;
     * otherwise returns null.
     * @param key key
     * @return see above
     */
    @Override
    public String get(Integer key) {
        long startTime, endTime, elapsed;
        startTime = System.nanoTime();
        int j = findSlot(key);
        if (j <= 0) return null;
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("Time: " + elapsed + " ns\n");
        return table[j].getValue();
    }

    /**
     * Removes from M the entry with key equal to k, and returns its
     * value; if M has no such entry, then returns null.
     * @param key key
     * @return see above
     */
    @Override
    public String remove(Integer key) {
        long startTime, endTime, elapsed;
        startTime = System.nanoTime();
        int j = findSlot(key);
        if (j < 0) return null;
        String answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("Time: " + elapsed + " ns\n");
        return answer;
    }

    /**
     * Returns an iterable collection containing all the key-value entries
     * in M.
     * @return an iterable collection
     */
    @Override
    public Iterable<MapEntry> entrySet() {
        ArrayList<MapEntry> buffer = new ArrayList<>( );
        for (int h = 0; h < capacity; h++){
            if (!isAvailable(h)) buffer.add(table[h]);
        }
        return buffer;
    }
}
