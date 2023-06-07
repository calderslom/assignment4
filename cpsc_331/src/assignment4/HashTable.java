package assignment4;

import java.util.LinkedList;
import java.util.ListIterator;
import java.lang.Math;

class HashTable<T extends Hashable> implements HashTableInterface<T> {
	private int size;
    private LinkedList<T>[] table;
    private HashFunction f;

    public HashTable(int size, HashFunction hashFunc) {
    	this.size = size;
        this.f = hashFunc;
        table = new LinkedList[size];
    }

    /**
     * Clears the hashtable
     *
     * @preconsidtion: none
     * @postcondition: hash table becomes empty
     * 
     */
    public void clear()
    {
        for (int i = 0; i < size; i++) table[i] = null;
    }

    public void add(T item) {
        int index = f.hash(item.key(), this.size);
        if (table[index] == null) table[index] = new LinkedList<>();
        table[index].add(item);
    }

    public void remove(T item) {
        int index = f.hash(item.key(), this.size);
        table[index].remove(item);
    }

    /**
     * This method returns true if the key of the item passed in as argument exists within the 
     * hash table.
     * 
     * @param item to be searched for in the Hash Table
     * 
     * @return boolean  
     */
    public boolean contains(T item) {
        int index = f.hash(item.key(), this.size);
        if (table[index] == null ) return false;						// null list means trivial false condition
        // Because the values stored in the hash table are different integer objects than those in the elements array, we must check their key values to "compare" and search for them 
        ListIterator<T> iterator = table[index].listIterator();			// creates an iterator from the Linked List at table[index]
        while (iterator.hasNext()) {									// Loops until there is no "next" object in the linked list
        	T listItem = iterator.next();								// gets the next object
        	System.out.println("List key = " + listItem.key() + "\t Item key = " + item.key());
        	if (listItem.key().equals(item.key())) {					// compares the key of the object to the key of the item
        		System.out.println(true);
        		return true;											// returns true if the keys match (because that's how we are supposed to decide if searchArray values match elementsArray values)
        	}
        }
        return false;
    }

}