package chapter16;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    private static void outputSet(HashSet<String> set){
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashSet<String> round = new HashSet<String>();
        HashSet<String> green = new HashSet<String>();

        round.add("peas");
        round.add("ball");
        round.add("pie");
        round.add("grapes");

        green.add("peas");
        green.add("grapes");
        green.add("gardenHose");
        green.add("grass");

        outputSet(round);
        outputSet(green);


        HashSet<String> setUnion = new HashSet<String>(round);
        setUnion.addAll(green);
        System.out.println("\nUnion of green and round:");
        outputSet(setUnion);


        HashSet<String> setInter = new HashSet<String>(round);
        setInter.retainAll(green);
        System.out.println("\nIntersection of green and round:");
        outputSet(setInter);
        System.out.println();

    }
}
