package org.example;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String string= "TutorialsPoint?java8";
        // Encode
        String base64encodedString = Base64.getEncoder().encodeToString(string.getBytes("utf-8"));
        System.out.println("Base64 Encoded String (Basic) :"+base64encodedString);
        // Decode
        byte[]base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println(new String(base64decodedBytes,"utf-8"));
    }
}
