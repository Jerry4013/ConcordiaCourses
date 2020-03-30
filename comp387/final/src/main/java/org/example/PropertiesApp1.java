package org.example;

import java.io.*;

import java.util.Properties;

public class PropertiesApp1 {
    public static void main(String[] args) {
//        try (InputStream input = new FileInputStream("src/main/resources/application.properties")){
//            Properties properties = new Properties();
//            properties.load(input);
//            System.out.println(properties.getProperty("username"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try (OutputStream out = new FileOutputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.setProperty("new", "mynewvalue");
            properties.store(out, null);
            System.out.println(properties.getProperty("new"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
