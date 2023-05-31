package assignment4;

/**
 * Implementation of the Hash function described in CPSC 331 Assignment 4.
 * <p>
 * Hash table size is declared as static and final as the table size is fixed as per Assignment requirements.
 * 
 * @author 
 *
 */

public class HashFunctionA4 {

	public static final int HASHTABLESIZE = 9973;
	/**
     * Hash function for use in Assignmnent4
     * 
     * @param x the hash key to be used. In this case, we can just use the integer itself.
     * 
     * @return hash value
     */
	public int hash(int x) {
		x = ((x >>> 16) ^ x) * 0x45d9f3b; // >>> is unsigned right shift
		x = ((x >>> 16) ^ x) * 0x45d9f3b;
		x = (x >>> 16) ^ x;
		return Math.abs(x)%HASHTABLESIZE; 
	}

}
