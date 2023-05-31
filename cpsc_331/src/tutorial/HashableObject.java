package tutorial;
/**
 * Defines a String class that can be used with hash tables
 *
 * @author Jalal Kawash
 * 
 */
public class HashableObject implements Hashable
{
    private String string;
    // other members of the object
    
    /**
     * Constructor for objects of class HashableString
     */
    public HashableObject(String s)
    {
        string = new String(s);
    }
    
    public String key()
    {
        return string;
    }
}
