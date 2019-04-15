package assignment.a2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTester {
    public static final int NUMBER_OF_LIST_TYPES = 4;
    public static void main(String[] args) {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream("testrun.txt",true));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file testrun.txt.");
            System.exit(0);
        }
        List<Integer>[] lists = new List[NUMBER_OF_LIST_TYPES];
        lists[0] = new MyArrayList<>();
        lists[1] = new ArrayList<>();
        lists[2] = new MyLinkedList<>();
        lists[3] = new LinkedList<>();

        int[] n ={10, 100, 1000, 10000, 100000, 1000000};
        Random randomGenerator = new Random();
        double startTime, endTime, elapsed;

        for (int i = 0; i < n.length; i++) {
            outputStream.println("N = " + n[i] + "  " +
                    "\t\tInsert@start(ms)\tInsert@end (ms)\t\tInsert@random (ms)");
            for (int j = 0; j < NUMBER_OF_LIST_TYPES; j++) {
                outputStream.print(lists[j].getClass().getSimpleName()+"\t\t");

                startTime = System.currentTimeMillis();
                for (int k = 0; k < n[i]; k++) {
                    lists[j].add(0, randomGenerator.nextInt(n[i] * 2));
                }
                endTime = System.currentTimeMillis();
                elapsed = endTime - startTime;
                outputStream.print(elapsed + "\t\t\t");

                startTime = System.currentTimeMillis();
                for (int k = 0; k < n[i]; k++) {
                    lists[j].add(randomGenerator.nextInt(n[i] * 2));
                }
                endTime = System.currentTimeMillis();
                elapsed = endTime - startTime;
                outputStream.print(elapsed + "\t\t\t");

                int randomLocation = randomGenerator.nextInt(lists[j].size());
                startTime = System.currentTimeMillis();
                for (int k = 0; k < n[i]; k++) {
                    lists[j].add(randomLocation, randomGenerator.nextInt(n[i] * 2));
                }
                endTime = System.currentTimeMillis();
                elapsed = endTime - startTime;
                outputStream.print(elapsed + "\t\t\t");

                outputStream.println();

            }

            outputStream.println("\t\t\tRemove@start(ms)\tRemove@end(ms)\t\tRemove@random(ms)\tRemove by value (ms)");
            for (int j = 0; j < NUMBER_OF_LIST_TYPES; j++) {
                outputStream.print(lists[j].getClass().getSimpleName()+"\t\t");

                startTime = System.currentTimeMillis();
                for (int k = 0; k < n[i]; k++) {
                    lists[j].remove(0);
                }
                endTime = System.currentTimeMillis();
                elapsed = endTime - startTime;
                outputStream.print(elapsed + "\t\t\t");

                startTime = System.currentTimeMillis();
                for (int k = lists[j].size() - 1; k >= 2 * n[i]; k--) {
                    lists[j].remove(k);
                }
                endTime = System.currentTimeMillis();
                elapsed = endTime - startTime;
                outputStream.print(elapsed + "\t\t\t");

                startTime = System.currentTimeMillis();
                for (int k = 0; k < n[i]; k++) {
                    int randomLocation = randomGenerator.nextInt(lists[j].size());
                    lists[j].remove(randomLocation);
                }
                endTime = System.currentTimeMillis();
                elapsed = endTime - startTime;
                outputStream.print(elapsed + "\t\t\t");

                for (int k = 0; k < n[i]; k++) {
                    lists[j].add(randomGenerator.nextInt(n[i] * 2));
                }
                startTime = System.currentTimeMillis();
                for (int k = 0; k < n[i]; k++) {
                    lists[j].remove((Object)randomGenerator.nextInt(n[i] * 2));
                }
                endTime = System.currentTimeMillis();
                elapsed = endTime - startTime;
                outputStream.println(elapsed + "\t\t\t");
            }
            outputStream.flush();
            outputStream.println();
        }
        outputStream.close();
    }
}
