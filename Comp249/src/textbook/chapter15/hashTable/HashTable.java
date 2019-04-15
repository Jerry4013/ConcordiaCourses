package chapter15.hashTable;

import chapter15.linkedList.LinkedList2;


public class HashTable {
    private LinkedList2[] hashArray;
    private static final int SIZE = 10;

    public HashTable(){
        hashArray = new LinkedList2[SIZE];
        for (int i = 0; i < SIZE; i++) {
            hashArray[i] = new LinkedList2();
        }
    }

    private int computeHash(String s){
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
        }
        return hash % SIZE;
    }

    public boolean containsString(String target){
        int hash = computeHash(target);
        LinkedList2 list = hashArray[hash];
        if (list.contains(target))
            return true;
        return false;
    }

    public void put(String s){
        int hash = computeHash(s);
        LinkedList2 list = hashArray[hash];
        if (!list.contains(s)){
            hashArray[hash].addToStart(s);
        }
    }

    public void outputHashTable( ){
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i].size()>0)
                hashArray[i].outputList();
        }
    }


}
