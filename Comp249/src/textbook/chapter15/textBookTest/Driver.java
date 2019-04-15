package chapter15.textBookTest;


import java.util.LinkedList;

public class Driver {
    public static void main(String[] args) {
        Set<Car> s1 = new Set<Car>();
        LinkedList<String> strings = new LinkedList<>();
        strings.add("56");
        strings.add("fwe");
        strings.set(1, "asdf");
        System.out.println(strings);
    }
}
