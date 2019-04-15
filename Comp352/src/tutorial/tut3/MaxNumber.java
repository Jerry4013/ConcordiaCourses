package tutorial.tut3;

public class MaxNumber {
    public static void main(String[] args) {
        new MaxNumber().run();
    }

    private void run() {
        int[] arr = {6,7,3,8,4};
        System.out.println(max(arr));
    }

    public int max(int[] arr){
        return max(arr, arr.length);
    }

    private int max(int[] arr, int n){
        if (n == 1){
            return arr[0];
        }
        return Math.max(max(arr, n-1), arr[n-1]);
    }
}
