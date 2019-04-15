package Chapter4;

public class Asterisks {
    public static String repeat1(char c, int n){
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer += c;
        }
        return answer;
    }

    public static String repeat2(char c, int n){
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        repeat1('*', 500000);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println(elapsed);

        start = System.currentTimeMillis();
        repeat2('*', 500000);
        end = System.currentTimeMillis();
        elapsed = end - start;
        System.out.println(elapsed);

    }
}
