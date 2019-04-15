package chapter15.textBookTest;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    private LinkedList[] hashArray;
    private static final int SIZE = 10;

    public HashTable(){
        hashArray = new LinkedList[SIZE];
        for(int i=0; i<hashArray.length; i++){
            hashArray[i] = new LinkedList();
        }
    }

    private int computeHash(String s){
        int hash=0;
        for(int i=0; i<s.length(); i++){
            hash += s.charAt(i);
        }
        return hash % SIZE;
    }

    public boolean containsString(String target){
        int hash = computeHash(target);
        LinkedList list = hashArray[hash];
        if(list.contains(target))
            return true;
        return false;
    }

    public void put(String s){
        int hash = computeHash(s);
        LinkedList list = hashArray[hash];
        if(!list.contains(s))
            hashArray[hash].addFirst(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTable hashTable = (HashTable) o;
        return Arrays.equals(hashArray, hashTable.hashArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(hashArray);
    }
}
