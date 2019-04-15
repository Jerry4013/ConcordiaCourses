package assignment.a4;

public class QuadraticProbeHashMap extends OpenAddressingHashMap{

    public QuadraticProbeHashMap() {
    }

    public QuadraticProbeHashMap(int cap) {
        super(cap);
    }

    @Override
    protected int nextSearch(int j, int counter) {
        return ( j + counter * counter - (counter - 1) * (counter - 1) ) % capacity;
    }
}
