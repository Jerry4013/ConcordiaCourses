package assignment.a1;

public class TwoSums {
    public static void main(String[] args) {
        new TwoSums().run();
    }

    private void run() {
        int[] arr = {10, 14, 3, 9, 22, 35, 92, 5, 9, 64};
        int[] result = findSums(arr, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public int[] findSums(int[] a, int x){
        int greaterSum = 0, smallerSum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > x){
                greaterSum += a[i];
            } else if (a[i] < x){
                smallerSum += a[i];
            }
        }
        int[] sums = {greaterSum, smallerSum};
        return sums;
    }
}
