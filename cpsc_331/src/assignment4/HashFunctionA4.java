package assignment4;

/**
 * Implementation of the Hash function described in CPSC 331 Assignment 4.
 * <p>
 * 
 * @author 
 *
 */

public class HashFunctionA4 extends HashFunction {

	/**
     * Hash function for use in Assignmnent4
     * 
     * @param x the hash key to be used. In this case, we can just use the integer itself.
     * 
     * @return hash value
     */
	@Override
	public int hash(Integer x, int hashTableSize) {
		x = ((x >>> 16) ^ x) * 0x45d9f3b; // >>> is unsigned right shift
		x = ((x >>> 16) ^ x) * 0x45d9f3b;
		x = (x >>> 16) ^ x;
		return Math.abs(x)%hashTableSize; 
	}

}
