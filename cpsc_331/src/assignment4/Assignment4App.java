package assignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;



public class Assignment4App {
	// Strings for output
	static final String OUTPUT_FILE = "a4_time_stamps.txt";

	
	
	public int[] generateSearchArray(int size) {
		Random rand = new Random(); 
		int[] searchArray = new int[size];
		for (int i = 0; i < size; i++) {
			
		}
		return searchArray;
	}
	
	public static void main(String[] args) {
		
		int[] elements = ArrayGenerator.generateElementsArray();
		int[] searchArray;
		
		
		System.out.println(Arrays.toString(elements));
		System.out.println(elements.length);
		
		System.out.println("HASHBROWNS!");
		
		searchArray = ArrayGenerator.generateSearchArray(10);
		System.out.println(Arrays.toString(searchArray));
		
		long start = System.nanoTime();
		long end = System.nanoTime();
		long time = end - start;
		
		try {
            FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            
            
            
            
            
            
            fileWriter.close();
            printWriter.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
		
	}	// End of Main
	

	
}	// End of Class
