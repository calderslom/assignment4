package assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Used in conjunction with the ValueGenerator class.
 * <p>
 * Returns arrays populated with static integer values that are stored in a text file in the working directory.
 * 
 * @author Calder Sloman
 *
 */
public class IntegerFileReader {
	static final String INPUT_FILE = "searchValues.txt";
    
    /**
     * Use the ValueGenerator class to create the searchValues.txt file before using this method for the first time.
     * 
     * @preconsidtion: searchValues.txt must exist within the working directory.
     * @postcondition: none
     * 
     * @return an array of values taken from the searchValues.txt file in the working directory
     */
	public static int[] returnArray(int size) {
        int[] array = new int[size];

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < array.length) {
                int value = Integer.parseInt(line);
                array[index] = value;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}

