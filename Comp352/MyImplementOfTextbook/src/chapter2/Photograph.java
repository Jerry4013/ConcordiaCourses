package chapter2;

public class Photograph implements Sellable {

    private String descript;
    private int price;
    private boolean color;


    public Photograph(String desc, int p, boolean c) {
        descript = desc;
        price = p;
        color = c;
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

    public boolean isColor() {
        return color;
    }
}
