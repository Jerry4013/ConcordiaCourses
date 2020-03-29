package chapter3;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(char[] data) {
        for (int i = 1; i < data.length; i++) {
            char c = data[i];
            int j = i;
            while (j > 0 && c < data[j - 1]) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = c;
        }
    }

    public static void main(String[] args) {
        char[] data = {'B','C','D','A','E','H','G','F'};
        insertionSort(data);
        System.out.println("data = " + Arrays.toString(data));
    }

}
