package assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IntegerFileReader {
	static final String INPUT_FILE = "searchValues.txt";
    
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

