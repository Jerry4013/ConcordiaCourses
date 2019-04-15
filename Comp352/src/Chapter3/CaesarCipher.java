package Chapter3;

import java.util.Arrays;

public class CaesarCipher {

    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    public CaesarCipher(int rotation) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char)('A' + (i + rotation) % 26);
            decoder[i] = (char)('A' + (i - rotation + 26) % 26);
        }
    }

    private String transform(String original, char[] code){
        char[] msg = original.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            if(Character.isUpperCase(msg[i])) {
                int j = msg[i] - 'A';
                msg[i] = code[j];
            }
        }
        return new String(msg);
    }


}
