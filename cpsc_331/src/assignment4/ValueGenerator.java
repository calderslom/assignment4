package assignment4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 * This class is used to create static integer values that are stored in a text file in the working directory.
 * It must be used before the IntegerFileReader class
 * 
 * @author Calder Sloman
 *
 */
public class ValueGenerator {
	static final String OUTPUT_FILE = "searchValues.txt";
	static final int MAX = 999000;
	
    /**
     * 
     *
     * @preconsidtion: none
     * @postcondition: searchValues.txt is created in the working directory
     * 
     */
	public static void generateSearchValues() {
        FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(OUTPUT_FILE);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			Random rand = new Random();
			for (int i = 0; i <= MAX; i++) {
				bufferedWriter.write(""+rand.nextInt(5001));
				bufferedWriter.newLine();
			}
			bufferedWriter.flush(); // Flush the buffered writer to ensure all data is written to the file
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
