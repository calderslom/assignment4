package assignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;



/**
 * 
 * This is the class that executes a multitude of search algorithms and outputs the timed results of those 
 * searches to a text file in the working directory named a4_time_stamps.txt. The file is rewritten after every execution of the program.
 * 
 */
public class Assignment4App {
	static final String OUTPUT_FILE = "a4_time_stamps.txt";
	static final int MIN = 1000;
	static final int MAX = 1000000;
	
	public static void main(String[] args) {
		int[] elements = ArrayGenerator.generateElementsArray();
		int[] searchArray;
		long sequentialStart, sequentialEnd, sequentialTotal, binaryStart, binaryEnd, binaryTotal, hashStart, hashEnd, hashTotal;
		boolean moreToSearch;
		int index;
		
		System.out.println("Elements Array Length: " + elements.length);
		
		System.out.println("HASHBROWNS!");
			
		
		try {
            FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            PrintWriter writer = new PrintWriter(fileWriter);
    		
    		
    		// Implement sequential search of Arrays
    		
    		for (int n = MIN; n <= MAX; n++) {									// This is the loop that iterates through arrays of length n where 1000<= n <= 1,000,000
    			searchArray = ArrayGenerator.generateSearchArray(n);
    			sequentialStart = System.nanoTime();							// Begin measuring search time for the nth iteration of the searchArray
        		for (int element : elements) {
        			moreToSearch = true;
        			index = 0;
        			while (moreToSearch && index < searchArray.length) {
        				if (element == searchArray[index]) {
        					//System.out.println("Found one at " + index);
        					moreToSearch = false;
        				}
        				index++;
        			}
        		}
        		sequentialEnd = System.nanoTime();								// Search for this array iteration finished
        		sequentialTotal = sequentialEnd - sequentialStart;
        		writer.println(searchArray.length + "\t" + sequentialTotal);
        		searchArray = null;												// dereferencing the array to make it a candidate for garbage collection
    		}
            
            
            
            
            System.out.println("Program Terminating");
            fileWriter.close();
            writer.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
		
	}	// End of Main
	
}	// End of Class
