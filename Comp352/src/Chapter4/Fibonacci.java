package Chapter4;

public class Fibonacci {
    public static final int F1 = 1;
    public static final int F2 = 1;
    public static void main(String[] args) {
//        System.out.println(fib(45));
        long[] answer = fibonacciGood(5);
        for (long l : answer) {
            System.out.println(l);
        }
    }

    public static int fib(int n){
        if (n == 1){
            return F1;
        }
        if (n == 2) {
            return F2;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static long[ ] fibonacciGood(int n){
        if (n <= 1){
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = fibonacciGood(n - 1);
            long[] answer = {temp[0] + temp[1], temp[0]};
            return answer;
        }
    }
}
