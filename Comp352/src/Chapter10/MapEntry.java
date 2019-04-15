package Chapter10;

public class MapEntry<K,V> {

    private K key;
    private V value;

    public MapEntry(K key, V value){
       this.key = key;
       this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) obj;

        if (!key.equals(mapEntry.key)) return false;
        return value.equals(mapEntry.value);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();

        return result;
    }
}
