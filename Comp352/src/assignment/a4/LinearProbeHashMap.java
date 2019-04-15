package assignment.a4;

public class LinearProbeHashMap extends OpenAddressingHashMap {
    public LinearProbeHashMap() {
    }

    public LinearProbeHashMap(int cap) {
        super(cap);
    }

    protected int nextSearch(int j, int counter){
        return (j + 1) % capacity;
    }
}
