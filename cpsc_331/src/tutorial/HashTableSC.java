package tutorial;
/**
 * A hash table implementation using separate chaining
 *
 * @author Jalal Kawash
 * 
 */
import java.lang.reflect.Array;
import java.util.LinkedList;

public class HashTableSC<T extends Hashable> implements HashTableInterface<T>
{
    private LinkedList<T>[] hashTable;
    private HashFunction f;

    /**
     * Constructor for objects of class HashTableSC
     */
    public HashTableSC(HashFunction f, int maxSize)
    {
        hashTable = new LinkedList[maxSize];
        this.f = f;
    }

    /**
     * clears the hashtable
     *
     * @preconsidtion: none
     * @postcondition: hash table becomes empty
     * 
     */
    public void clear()
    {
        for (int i = 0; i < hashTable.length; i++) hashTable[i] = null;
    }
    
    /**
     * adds an item to the hashtable
     *
     * @preconsidtion: none
     * @postcondition: item is added to the appropriat chain
     * 
     */
    public void add(T item)
    {
        int i = f.hash(item.key(), hashTable.length);
        if (hashTable[i] == null) hashTable[i] = new LinkedList<T>();
        hashTable[i].add(item);
    }
    
    /**
     * removes an item to the hashtable
     *
     * @preconsidtion: none
     * @postcondition: item is deleted from the hashtable
     * 
     */
    public void remove(T item)
    {
        hashTable[f.hash(item.key(), hashTable.length)].remove(item.key());
    }
    
    /**
     * looks for an item in a hash table 
     *
     * @preconsidtion: none
     * @postcondition: returns true if item is in the table; false otherwise
     * 
     */
    public boolean contains(T item)
    {
        int i = f.hash(item.key(), hashTable.length);
        if (hashTable[i] == null) return false;
        else return hashTable[i].contains(item);
    }
    
    public void printStats() 
    {
        int chains = 0;
        int items = 0;
        int chainLength;
        int totChainLength = 0;
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] != null) {
                chains++;
                chainLength = 0;
                for (int j = 0; j < hashTable[i].size(); j++) 
                {
                    items++; 
                    chainLength++;
                }
                totChainLength += chainLength;
            }
        }
        //System.out.println("Statistics");
        System.out.println("--------------------------------------------");
        System.out.printf("Items hashed: %d, with load factor = %.2f\n", items, (float) items/hashTable.length);
        System.out.printf("Chains used: %d out of %d, chain usage: %.2f%%\n", chains, hashTable.length, ((float) chains/hashTable.length)*100);
        System.out.printf("Average chain length: %.2f (%d/%d)\n", (float) totChainLength/chains, totChainLength, chains);
        System.out.println("--------------------------------------------");
    }
    
    public void printTable() // only suitable for small hash tables
    {
        int chains = 0;
        int items = 0;
        int chainLength;
        int totChainLength = 0;
        System.out.println("Hash Table");
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] != null) {
                chains++;
                chainLength = 0;
                System.out.print(i + " : ");
                for (int j = 0; j < hashTable[i].size(); j++) 
                {
                    items++; 
                    chainLength++;
                    System.out.print(hashTable[i].get(j).key());
                    if (j != hashTable[i].size() - 1) System.out.print(", ");
                }
                totChainLength += chainLength;
                System.out.println();
            }
        }
        System.out.println("----");
        System.out.printf("Items hashed: %d, with load factor = %.2f\n", items, (float) items/hashTable.length);
        System.out.printf("Chains used: %d out of %d, chain usage: %.2f\n", chains, hashTable.length, ((float) chains/hashTable.length)*100);
        System.out.printf("Average chain length: %.2f (%d/%d)\n", (float) totChainLength/chains, totChainLength, chains);
    }
}
