package assignment.a1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;

public class OddonacciGood {

    /**
     * the test method for oddonacciGood.Test the run times of calculating oddonacci numbers with
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
        outputStream.println("oddonacciGood: ");
        for (int i = 5; i <= 100; i = i + 5) {
            startTime = System.currentTimeMillis();
            BigInteger[] answer = oddonacciGood(i);
            outputStream.println("Oddonacci(" + i + ") is: " + answer[0]);
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
     * @return the nth oddonacci number.
     */
    public static BigInteger[] oddonacciGood(int n){
        if (n <= 0) {
            BigInteger[] answer = new BigInteger[3];
            for (int i = 0; i < 3; i++) {
                answer[i] = new BigInteger("0");
            }
            return answer;
        }
        if (n <= 3) {
            BigInteger[] answer = new BigInteger[3];
            for (int i = 0; i < 3; i++) {
                answer[i] = new BigInteger("1");
            }
            return answer;
        } else {
            BigInteger[] temp = oddonacciGood(n - 1);
            BigInteger[] answer = {temp[0].add(temp[1]).add(temp[2]), temp[0], temp[1]};
            return answer;
        }
    }
}
