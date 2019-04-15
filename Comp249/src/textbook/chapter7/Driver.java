package chapter7;

public class Driver {
    private int n;
    public static void main(String[] args) {
//        Child child = new Child();
//        child.eat();
//        Driver driver = new Driver();
//        driver.n = 1;
//        GrandChild grandChild = new GrandChild();
//        grandChild.eat();

        Child_protected child_protected = new Child_protected();
        child_protected.setValue("child");
        child_protected.checkValue();
    }
}
