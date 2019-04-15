package assignment.a4;

public interface Map {
    int size();
    boolean isEmpty();
    String get(Integer key);
    String put(Integer key, String value);
    String remove(Integer key);
    Iterable<Integer> keySet();
    Iterable<String> values();
    Iterable<MapEntry> entrySet();
}
