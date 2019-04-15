package chapter16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class HashSetIteratorDemo {
    public static void main(String[] args) {

        HashSet<String> s = new HashSet<>();

        s.add("health");
        s.add("love");
        s.add("money");

        System.out.println("The set contains: ");

        Iterator<String> i = s.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        i.remove();
        System.out.println();
        System.out.println("The set now contains: ");

        i = s.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("End of program");

        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        ListIterator<String> stringListIterator = a.listIterator();
        System.out.println(stringListIterator.nextIndex());
        while (stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
        }
        System.out.println(stringListIterator.nextIndex());
    }
}
