package assignment4;
/**
 * Defines some example hash functions for use in CPSC 331
 *
 * @author Jalal Kawash
 * 
 * Modified from Dr. Kawash's code. The first argument is now an integer instead of a string.
 */
public abstract class HashFunction
{
    /**
     * Abstract method for computing a hash value on a String
     */
    public abstract int hash(Integer x, int tableSize);
}
