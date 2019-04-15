package Chapter3;

import java.util.Arrays;

public class CaesarCipherDriver {
    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher(3);
        System.out.println(Arrays.toString(caesarCipher.encoder));
        System.out.println(Arrays.toString(caesarCipher.decoder));



    }
}
