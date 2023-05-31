package assignment4;
/**
 * Defines an example hash functions for use in CPSC 331
 *
 * @author Jalal Kawash
 * 
 */
public class HashFunction2 extends HashFunction
{
    /**
         * An example hash function; From : Mark Weiss, Data Structures and Algorithm Analysis Using Java, 3rd ed, Pearson
         *
         * @preconsidtion: none
         * @postcondition: returns a hash value for this string
         * 
         */
    public int hash(String s, int size) 
    {
        int hashVal = 0;
        for (int i = 0; i < s.length(); i++)
            if (i == 0) hashVal += s.charAt(0);
            else if (i == 1) hashVal += 27 * s.charAt(1);
            else if (i == 2) hashVal += 729*s.charAt(2);
        return hashVal%size;
    }   
}
