package concordia.comp354.calculator.utils;

import java.util.HashMap;
import java.util.Map;

public class Operator implements Comparable {

    private char symbol;
    private int priority;
    private static Map<Character, Integer> map;

    public Operator() {
        init();
    }

    public Operator(char symbol) {
        init();
        this.symbol = symbol;
        this.priority = map.get(symbol);
    }

    public char getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    private static void init(){
        map = new HashMap<>();
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);
        map.put('$', 0);
    }

    @Override
    public int compareTo(Object o) {
        Operator other = (Operator)o;
        return priority - other.priority;
    }

    public static double calculate(double num1, double num2, char operator){
        if (operator == '+'){
            return num1 + num2;
        } else if (operator == '-'){
            return num1 - num2;
        } else if (operator == '*'){
            return num1 * num2;
        } else if (operator == '/'){
            return num1 / num2;
        } else {
            System.out.println("Unknown operator");
            System.exit(0);
        }
        return 0;
    }
}
