package tutorial.tut4;

import java.util.Stack;

public class BinaryRep {
    public static void main(String[] args) {
        new BinaryRep().run();
    }

    private void run() {
        System.out.println(binaryRep(16));
    }

    public String binaryRep(int value){
        Stack<Integer> integers = new Stack<>();
        while (value != 0){
            int remainder = value % 2;
            integers.push(remainder);
            value = value / 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!integers.isEmpty()){
            stringBuilder.append(integers.pop());
        }
        return stringBuilder.toString();
    }
}
