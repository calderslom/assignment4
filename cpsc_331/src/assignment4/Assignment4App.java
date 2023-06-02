package assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;



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
public class Assignment4App {
	static final String OUTPUT_FILE = "a4_time_stamps.txt";
	static final int MIN = 1000;
	static final int MAX = 999000;
	
	public static void main(String[] args) {
		ValueGenerator.generateSearchValues();									// Generates a file with all the values we will use in the search array (this ensures we use the same values for all tests)
		int[] elements = ArrayGenerator.generateElementsArray();							
		int[] searchArray;
		long sequentialStart, sequentialEnd, sequentialTotal, binaryStart, binaryEnd, binaryTotal, hashStart, hashEnd, hashTotal;
		boolean moreToSearch;
		int index;
		System.out.println("The results of the search expiriment are written to the " + OUTPUT_FILE + " in your working directory.\n");
		
		try {
            // Creating objects for output
			FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.print("The arrangement of data in the output file is as follows -\n");
            System.out.println("\t\t\t\t\t\t\t\tArray Length:\tSequential Search:\tBinary Search:\n");
    		
            // Start of Sequential & Binary Search
    		for (int n = MIN; n <= 10000; n++) {										// This is the loop that iterates through arrays of length n where 1000<= n <= 1,000,000
    			// Start of Sequential search
    			searchArray = IntegerFileReader.returnArray(n);						// Creates an array based on values from the input file (this keeps arrays consistent across all searches)
    			//System.out.println(searchArray.length);
    			//System.out.println(Arrays.toString(searchArray));
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

        		QuickSort.quickSort(searchArray);									// Sorting the search array to prepare for Binary Search
        		//System.out.println(Arrays.toString(searchArray));
        		binaryStart = System.nanoTime();									// START binary search for this array iteration
        		for (int element : elements) {
        			BinarySearch.searchArray(element, searchArray);					
//        			System.out.println("Element = " + element);
//        			int i = BinarySearch.searchArray(element, searchArray);
//        			if(i != -1) System.out.println(searchArray[i]);
        		}
        		binaryEnd = System.nanoTime();										// END binary search for this array iteration
        		binaryTotal = binaryEnd - binaryStart;
        		bufferedWriter.write(n + "\t" + sequentialTotal + "\t" + binaryTotal + "\n");
    		}
            System.out.println("Program Terminating");

            bufferedWriter.flush(); 
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
		
	}	// End of Main
	
}	// End of Class
