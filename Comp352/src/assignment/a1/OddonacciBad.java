package assignment.a1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class OddonacciBad {
    /**
     * the test method for oddonacciBad.Test the run times of calculating oddonacci numbers with
     * this method. Print the result to an out.txt file.
     * @param args default
     */
    public static void main(String[] args) {
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream("out.txt",true));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file stuff.txt.");
            System.exit(0);
        }
        long startTime, endTime, elapsed;
        outputStream.println("oddonacciBad: ");
        for (int i = 5; i <= 100; i = i + 5) {
            startTime = System.currentTimeMillis();
            outputStream.println("Oddonacci(" + i + ") is: " + oddonacciBad(i));
            endTime = System.currentTimeMillis();
            elapsed = endTime - startTime;
            outputStream.println("Time: " + elapsed + " ms\n");
            outputStream.flush();
        }
        outputStream.close();
        System.out.println("Successfully Printed");
    }

    /**
     * Calculating the Oddonacci number at the nth position
     * @param n the position in the oddonacci series of the result.
     * @return the nth oddonacci number.
     */
    public static long oddonacciBad(int n){
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }else {
            return oddonacciBad(n - 1) + oddonacciBad(n - 2) + oddonacciBad(n - 3);
        }
    }
}
