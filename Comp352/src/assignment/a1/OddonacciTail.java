package assignment.a1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;

public class OddonacciTail {

    /**
     * the test method for oddonacciTail.Test the run times of calculating oddonacci numbers with
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
        outputStream.println("oddonacciTail: ");
        for (int i = 5; i <= 100; i = i + 5) {
            startTime = System.currentTimeMillis();
            BigInteger answer = oddonacciTail(i);
            outputStream.println("Oddonacci(" + i + ") is: " + answer);
            endTime = System.currentTimeMillis();
            elapsed = endTime - startTime;
            outputStream.println("Time: " + elapsed + " ms\n");
            outputStream.flush();
        }
        outputStream.close();
        System.out.println("Successfully Printed");
    }

    /**
     * Calculating the Oddonacci number at the nth position.
     * @param n the position in the oddonacci series of the result.
     * @param a oddonacci(1)
     * @param b oddonacci(2)
     * @param c oddonacci(3)
     * @return the nth oddonacci number.
     */
    public static BigInteger oddonacciTail(int n, BigInteger a, BigInteger b, BigInteger c){
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        if (n == 3) {
            return c;
        }
        return oddonacciTail(n - 1, b, c, a.add(b).add(c));
    }

    /**
     * Calculating the Oddonacci number at the nth position.
     * @param n the position in the oddonacci series of the result.
     * @return the nth oddonacci number.
     */
    public static BigInteger oddonacciTail(int n){
        BigInteger one = new BigInteger("1");
        return oddonacciTail(n, one, one, one);
    }
}
