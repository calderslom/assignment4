package assignment4;

/**
 * Defines an Integer class that can be used with Hash Tables
 * 
 * @author Calder Sloman
 *
 */
public class HashableInteger implements Hashable {

	private Integer key;
	
    /**
     * Constructor for objects of class HashableInteger
     */
	public HashableInteger(int n) {
		this.key = new Integer(n);
	}
	
	/*
	 * Getter for the HashableIntegers key value
	 */
	public Integer key() {
		return this.key;
	}
	
}
