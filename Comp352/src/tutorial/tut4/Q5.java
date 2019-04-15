package tutorial.tut4;

import java.util.Stack;

public class Q5 {
    public static void main(String[] args) {
        new Q5().run();
    }

    private void run() {
        System.out.println(isPalindrome("asdffdsa"));
    }

    public boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        if (chars.length % 2 == 0){
            for (int i = 0; i < chars.length / 2; i++) {
                characters.push(chars[i]);
            }
            for (int i = chars.length / 2; i < chars.length; i++) {
                if (chars[i] == characters.peek()){
                    characters.pop();
                }
            }
            return characters.isEmpty();
        }
        return false;
    }
}
