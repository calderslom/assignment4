package assignment4;
/**
 * Defines an example hash functions for use in CPSC 331
 *
 * @author Jalal Kawash
 * 
 */
public class HashFunction3 extends HashFunction
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
        for(int i = 0; i < s.length(); i++)
            hashVal = 37 * hashVal + s.charAt(i);
        hashVal %= size;
        if (hashVal < 0) hashVal += size;
        return hashVal;
    }   
}
