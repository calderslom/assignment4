package assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
public class SequentialBinaryApp {
	static final String OUTPUT_FILE = "a4_sequential_binary_time_stamps.txt";
	static final int MIN = 1000;
	static final int MAX = 1000000;
	
	public static void main(String[] args) {
		//ValueGenerator.generateSearchValues();									// Generates a file with all the values we will use in the search array (this ensures we use the same values for all tests)
		int[] elements = ArrayGenerator.generateElementsArray();							
		int[] searchArray;
		long sequentialStart, sequentialEnd, sequentialTotal, binaryStart, binaryEnd, binaryTotal;
		boolean moreToSearch;
		int index;
		System.out.println("The results of the search expiriment are written to the " + OUTPUT_FILE + " in your working directory.\n");
		
		try {
            // Creating objects for output
			FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("The arrangement of data in the output file is as follows -\n");
            System.out.println("Array Length:\tSequential Search:\tBinary Search:");
    		
            // Start of Sequential & Binary Search
    		for (int n = MIN; n <= MAX; n+= 1000) {									// This is the loop that iterates through arrays of length n where 1000<= n <= 1,000,000
    			// Start of Sequential search
    			searchArray = IntegerFileReader.returnArray(n);						// Creates an array based on values from the input file (this keeps arrays consistent across all searches and was recommended by Dr. Kawash)
    			sequentialStart = System.nanoTime();								// START sequential search for this array iteration 
        		for (int element : elements) {
        			moreToSearch = true;
        			index = 0;
        			while (moreToSearch && index < n) {
        				if (element == searchArray[index]) {
        					moreToSearch = false;
        				}
        				index++;
        			}
        		}
        		sequentialEnd = System.nanoTime();									// FINISH sequential search for this array iteration finished
        		sequentialTotal = sequentialEnd - sequentialStart;
        		// Start of Binary Search
        		QuickSort.quickSort(searchArray);									// Sorting the search array to prepare for Binary Search
        		binaryStart = System.nanoTime();									// START binary search for this array iteration
        		for (int element : elements) {
        			BinarySearch.searchArray(element, searchArray);					
        		}
        		binaryEnd = System.nanoTime();										// END binary search for this array iteration
        		binaryTotal = binaryEnd - binaryStart;
        		bufferedWriter.write(n + "\t" + sequentialTotal + "\t" + binaryTotal + "\n");
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
