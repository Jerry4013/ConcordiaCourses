package tutorial.tut2;

public class MaxAndMin {
    public static void main(String[] args) {
        new MaxAndMin().run();
    }

    private void run() {

    }

    public int[] findMaxAndMin(int[] arr){
        int n = arr.length;
        int[] result = new int[2];
        int max = arr[0];
        int min = arr[0];
        int[] maxGroup = new int[n / 2];
        int[] minGroup = new int[n / 2];
        for (int i = 0; i < n; i = i + 2) {
            if (arr[i] <= arr[i + 1]){
                minGroup[i / 2] = arr[i];
                maxGroup[i / 2] = arr[i+1];
            } else {
                minGroup[i / 2] = arr[i+1];
                maxGroup[i / 2] = arr[i];
            }
        }
        for (int i : minGroup) {
            if (i < min) {
                min = i;
            }
        }
        for (int i : maxGroup) {
            if (i > max) {
                max = i;
            }
        }
        if (n % 2 == 1){

        }
        return result;
    }
}
