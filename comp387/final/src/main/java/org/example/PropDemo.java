package org.example;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropDemo {
    public static void main(String[] args) {
        Properties capitals = new Properties();
        capitals.setProperty("Illinois", "Springfield");
        capitals.setProperty("Missouri","Jefferson City");
        Set<Object> states = capitals.keySet();
        Iterator<Object> iterator = states.iterator();
        while (iterator.hasNext()) {
            String cap = (String) iterator.next();
            System.out.println(cap + " is " + capitals.getProperty(cap));
        }
    }
}
