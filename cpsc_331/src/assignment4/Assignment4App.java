package assignment4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Assignment4App {
	// Strings for output
	static final String OUTPUT_FILE = "a4_time_stamps.txt";
	static final int ELEMENTS_SIZE = 100;
	
	public static void main(String[] args) {
		
		// Generating a set of distinct numbers for the elements array
		int[] elements = new int[ELEMENTS_SIZE];
		Random rand = new Random();     												
		Set<Integer> distinctNumbers = new HashSet<>();
		while (distinctNumbers.size() < ELEMENTS_SIZE -1) distinctNumbers.add(rand.nextInt(5001));	// Bound is exclusive so this generate integers [0,5000]
		elements = distinctNumbers.stream().mapToInt(Integer::intValue).toArray();						
		elements[99] = 5001;																		// Last cell in elements array is 5001 as described in the assignment specification
		
		
		System.out.println(Arrays.toString(elements));
		System.out.println(elements.length);
		
		System.out.println("HASHBROWNS!");
		
		long start = System.nanoTime();
		long end = System.nanoTime();
		long time = end - start;
		
	}	// End of Main
	
}	// End of Class
