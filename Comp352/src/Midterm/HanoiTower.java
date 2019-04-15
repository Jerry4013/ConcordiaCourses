package Midterm;


public class HanoiTower {
    public static void main(String[] args) {
        move2(5, 1, 2, 3,4);
    }
    public static void move(int n, int from, int auxiliary, int to){
        if (n == 1){
            System.out.println(from + " -> " + to);
            return;
        }
        move(n-1,from, to, auxiliary);
        System.out.println(from + " -> " + to);
        move(n -1, auxiliary, from, to);
    }

    public static void move2(int n, int from, int a1, int a2, int to){
        if (n == 1){
            System.out.println(from+ " -> " + to);
            return;
        }
        if (n == 2){
            System.out.println(from + " -> " + a2);
            System.out.println(from + " -> " + to);
            System.out.println(a2 + " -> " + to);
            return;
        }
        move2(n - 2, from, a2,to,a1);
        System.out.println(from + " -> " + a2);
        System.out.println(from + " -> " + to);
        System.out.println(a2 + " -> " + to);
        move2(n-2,a1,from,a2,to);
    }
}
