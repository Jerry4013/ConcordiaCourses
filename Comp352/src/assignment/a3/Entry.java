package assignment.a3;

public class Entry<K,V> {

    private K key;
    private V value;

    public Entry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K k) {
        this.key = k;
    }

    public void setValue(V v) {
        this.value = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry<?, ?> entry = (Entry<?, ?>) o;

        if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
        return value != null ? value.equals(entry.value) : entry.value == null;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
