package assignment4;
/**
 * Defines some example hash functions for use in CPSC 331
 *
 * @author Jalal Kawash
 * 
 */
public abstract class HashFunction
{
    /**
     * Abstract method for computing a hash value on a String
     */
    public abstract int hash(String key, int tableSize);
}
