package assignment4;

/**
 * Defines elements that can be added to hashstable
 * My hash functions are defined for Strings. So,
 * A Hashable object's key is a String
 *
 * @author Jalal Kawash
 * 
 * Modified from Dr. Kawash's code. Key is now an Integer instead of a String
 *
 */

public interface Hashable<T extends Comparable>
{
    public Integer key();
}
