package assignment4;

/**
 * This is the main application for Assignment 4.
 * <p>
 * It creates a text file filled with random integer values modulo 5000 before running separate search applications
 * 
 * @author Calder Sloman
 *
 */
public class MainApp {

	public static void main(String[] args) {
		// Generate a file with all the values we will use in the search array (this ensures we use the same values for all tests)
		ValueGenerator.generateSearchValues(); 
		// Sequential and Binary Search
		new SequentialBinaryApp();		
		SequentialBinaryApp.main(args);
		// Binary Search and Hash Lookup
		new BinaryHashApp();
		BinaryHashApp.main(args);
	}

}
