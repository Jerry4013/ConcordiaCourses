package assignment.a4;

import java.util.Random;

public class MapEntry {

    private Integer key;
    private String value;

    public MapEntry(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public MapEntry(String value){
        Random random = new Random();
        key = random.nextInt();
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public String setValue(String value) {
        String old = this.value;
        this.value = value;
        return old;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MapEntry mapEntry = (MapEntry) obj;

        if (key != null ? !key.equals(mapEntry.key) : mapEntry.key != null) return false;
        return value != null ? value.equals(mapEntry.value) : mapEntry.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = (result << 5) | (result >>> 27);
        return result;
    }

    @Override
    public String toString() {
        return "{" + key + ", " + value + "}";
    }
}
