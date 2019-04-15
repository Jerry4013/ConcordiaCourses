package chapter15.tree;

import java.util.Scanner;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        IntTree intTree = new IntTree();
        int next = keyboard.nextInt();
        while (next >= 0) {
            intTree.add(next);
            next = keyboard.nextInt();
        }

        intTree.showElements();

        keyboard.close();

    }
}
