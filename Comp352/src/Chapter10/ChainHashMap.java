package Chapter10;

public class ChainHashMap<K,V> extends AbstractHashMap<K,V> {

    private UnsortedTableMap<K,V>[] table;

    public ChainHashMap( ){
        super( );
    }

    public ChainHashMap(int cap){
        super(cap);
    }

    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K,V>[ ]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null) return null;
        return bucket.get(k);
    }

    @Override
    protected V bucketPut(int h, K k, V v) {
        return null;
    }

    @Override
    protected V bucketRemove(int h, K k) {
        return null;
    }

    @Override
    public Iterable<MapEntry<K, V>> entrySet() {
        return null;
    }
}
