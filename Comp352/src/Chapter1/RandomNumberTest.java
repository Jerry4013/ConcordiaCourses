package Chapter1;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberTest {
    public static void main(String[] args) {
        Random random = new Random();
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(data));
    }
}
