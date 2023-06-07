package assignment4;

import java.io.IOException;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
	
		
		HashTable hashTable = new HashTable(30, new HashFunctionA4());
		
		Integer num1 = new Integer(50);
		Integer num2 = new Integer(80);
		
		HashableInteger int1 = new HashableInteger(num1);
		HashableInteger int2 = new HashableInteger(num2);
		
		hashTable.add(int1);
		hashTable.add(int2);
		
		System.out.println("Added 50 and then 80");
		hashTable.printKeys();
		
		System.out.println("Removing 50");
		hashTable.remove(int1);
		hashTable.printKeys();
		
		System.out.println("Added 50");
		hashTable.add(int1);
		hashTable.printKeys();
		
		System.out.println("Clearing the Hash Table");
		hashTable.clear();
		hashTable.printKeys();
		
		// Showing that you cannot remove an item based on its integer value
		hashTable.add(new HashableInteger(255));
		hashTable.printKeys();
		hashTable.remove(new HashableInteger(255));
		hashTable.printKeys();
		
		// Showing that you CAN compare an item based on its integer value 
		// This is an integer comparison rather than an object comparison, which is what the assignment asked us to do
		hashTable.add(int1);
		System.out.println("Stored HashableInteger with key value = 50 is considered the same as a totally different object by comparison: " + hashTable.contains(new HashableInteger(50)));
		
	} // end of main
	
	

} // end of class
