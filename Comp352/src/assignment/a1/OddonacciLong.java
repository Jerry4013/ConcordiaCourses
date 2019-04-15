package assignment.a1;

public class OddonacciLong {
    public static long[] oddonacciGoodLong(int n){
        if (n <= 0) {
            long[] answer = {0,0,0};
            return answer;
        }
        if (n <= 3) {
            long[] answer = {1, 1, 1};
            return answer;
        } else {
            long[] temp = oddonacciGoodLong(n - 1);
            long[] answer = {temp[0] + temp[1] + temp[2], temp[0], temp[1]};
            return answer;
        }
    }

}
