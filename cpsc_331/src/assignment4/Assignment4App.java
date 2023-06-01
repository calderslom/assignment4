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
		boolean moreToSearch;
		int index;
		
		System.out.println("Elements Array Length: " + elements.length);
		
		System.out.println("HASHBROWNS!");
			
		int jag;
		try {
            FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            PrintWriter writer = new PrintWriter(fileWriter);
           
            searchArray = ArrayGenerator.generateSearchArray(1000);
    		
    		
    		// Implement sequential search of Arrays
    		long start = System.nanoTime();
    		for (int element : elements) {
    			moreToSearch = true;
    			index = 0;
    			while (moreToSearch && index < searchArray.length) {
    				if (element == searchArray[index]) {
    					System.out.println("Found one at " + index);
    					moreToSearch = false;
    				}
    				index++;
    			}
    		}
    		long end = System.nanoTime();
    		long time = end - start;
    		writer.print(searchArray.length + "\t" + time);
            
            
            
            
            System.out.println("Program Terminating");
            fileWriter.close();
            writer.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
		
	}	// End of Main
	
}	// End of Class
