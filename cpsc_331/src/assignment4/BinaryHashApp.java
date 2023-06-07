package assignment4;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import assignment4.HashTable;

/** 
 * This is the class that executes a multitude of search algorithms and outputs the timed results of those 
 * searches to a text file in the working directory named a4_time_stamps.txt. The file is rewritten after every execution of the program.
 * 
 * Please note that the over documentation of code is to simplify the development process for the authors.
 * 
 * @author Calder Sloman
 * @author Carlene Kalin
 * 
 */
public class BinaryHashApp {
	static final String OUTPUT_FILE = "a4_binary_hash_stamps.txt";
	static final int MIN = 1000;
	static final int MAX = 1000000;
	
	public static <T> void main(String[] args) {
		//ValueGenerator.generateSearchValues();											// Generates a file with all the values we will use in the search array (this ensures we use the same values for all tests)
		int[] elements = ArrayGenerator.generateElementsArray();							
		int[] searchArray;
		long binaryStart, binaryEnd, binaryTotal, hashStart, hashEnd, hashTotal;
		System.out.println("The results of the search expiriment are written to the " + OUTPUT_FILE + " in your working directory.\n");
		
		try {
            // Creating objects for output
			FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("The arrangement of data in the output file is as follows -");
            System.out.println("\tArray Length:\tBinary Search:\tHash Search:");
    			
    			// Start of Hash Search and Sequential Search
            HashTable<HashableInteger> hashTable = new HashTable<HashableInteger>(9973, new HashFunctionA4());			// 9973 as specified in the assignment
            int previousN = 0;																		// Must track previous value of n so that we don't add the same searchArray elements to the HashTable on every iteration
				for (int n = MIN; n <= MAX; n += 1000) {  
                searchArray = IntegerFileReader.returnArray(n);
                for (int i = previousN; i < n; i++) {
                	hashTable.add(new HashableInteger(searchArray[i]));								// populate the hashTable
                	//System.out.println("searchArray[" + i + "]" + " = " + searchArray[i]);		// This proves that we are indexing the search array properly to add elements to the hash table
                }
                previousN = n;
                hashStart = System.nanoTime();
                for (int element : elements) {
                	System.out.println("Element = " + element);
                	//if (hashTable.contains(new HashableInteger(element))) System.out.println("TRUE");
                	//System.out.println(hashTable.contains(new HashableInteger(element)));
                    hashTable.contains(new HashableInteger(element));
                }
                hashEnd = System.nanoTime();
                hashTotal = hashEnd - hashStart;
                	// Beginning of Binary Search
	    			QuickSort.quickSort(searchArray);									// Sorting the search array to prepare for Binary Search
	        		binaryStart = System.nanoTime();									// START binary search for this array iteration
	        		for (int element : elements) {
	        			BinarySearch.searchArray(element, searchArray);					
	        		}
	        		binaryEnd = System.nanoTime();										// END binary search for this array iteration
	        		binaryTotal = binaryEnd - binaryStart;		
	    			bufferedWriter.write(n + "\t" + binaryTotal + "\t" + hashTotal + "\n");
	    			searchArray = null;
	    		}
            bufferedWriter.flush(); 
			bufferedWriter.close();
			fileWriter.close();
			System.out.println("\nProgram Terminating");
		} catch (IOException e) {
            e.printStackTrace();
        }
		
	}	// End of Main
	
}	// End of Class
