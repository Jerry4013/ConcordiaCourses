package chapter2;

public class BoxedItem implements Sellable, Transportable {

    private String descript;
    private int price;
    private int weight;
    private boolean haz;
    private int height = 0;
    private int width = 0;
    private int depth = 0;

    public BoxedItem(String desc, int p, int w, boolean h) {
        descript = desc;
        price = p;
        weight = w;
        haz = h;
    }

    @Override
    public String description() {
        return descript;
    }

    @Override
    public int listPrice() {
        return price;
    }

    @Override
    public int lowestPrice() {
        return price / 2;
    }

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public boolean isHazardous() {
        return haz;
    }

    public int insuredValue() {
        return price * 2;
    }

    public void setBox(int h, int w, int d) {
        height = h;
        width = w;
        depth = d;
    }
}
