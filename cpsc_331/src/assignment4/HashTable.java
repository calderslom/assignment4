package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

class HashTable<T>{
    private static final int TABLE_SIZE = 9973;     //Set the size of the table. 9973 was the req. from the assignment

    private List<List<Integer>> table;

    public HashTable() {
        table = new ArrayList<>(TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new ArrayList<>());           //Initialize each table with empty chains for each bucket
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void add(int key) {                   //Add keys to the hash table
        int index = hash(key);
        List<Integer> chain = table.get(index);     //Find the index of the bucket for each key we're adding
        chain.add(key);                             //Add the key to the chain
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public boolean contains(int key) {                 //Gets the chain and checks if the key's in it
        int index = hash(key);
        List<Integer> chain = table.get(index);      //Get the index of the hash bucket
        return chain.contains(key);                  //Check if the key is in the chain with the index we got
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void remove(int key) {                   //Delete keys from the hash table
        int index = hash(key);
        List<Integer> chain = table.get(index);     //Same as insert. Find the index.
        chain.remove(Integer.valueOf(key));         //Make sure the key is treated like and int and not an index!
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private int hash(int x) {                       //How the hash values are calculated as specified in the assignment doc
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = (x >>> 16) ^ x;
        return Math.abs(x) % TABLE_SIZE;
    }
}