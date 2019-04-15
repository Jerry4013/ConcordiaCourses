package Chapter1;

import java.util.Scanner;

public class FinalTest {
    private final Scanner scanner = new Scanner(System.in);
    private static int a = 10;
    public static void fun1(int a){
       a = 9;
    }

    public static void main(String[] args) {
        fun1(4);
        System.out.println(a);
    }

}
