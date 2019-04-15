package Midterm;

import java.util.LinkedList;

public class reverse {
    public static void main(String[] args) {
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);
        s1.add(5);
        System.out.println(s1);
        System.out.println(reverse(s1));
        System.out.println(s1);
    }
    public static LinkedList<Integer> reverse(LinkedList<Integer> s1){
        LinkedList<Integer> s2 = new LinkedList<>();

        while (!s1.isEmpty()){
            s2.add(s1.removeLast());
        }
        return s2;
    }

    public static LinkedList<Integer> reverse2(LinkedList<Integer> s1, LinkedList<Integer> s2){
        if (s1.size() == 0){
            return s2;
        }
        s2.add(s1.removeLast());
        return reverse2(s1,s2);
    }
}
