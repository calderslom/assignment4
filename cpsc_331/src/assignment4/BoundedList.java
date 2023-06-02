package assignment4;
/**
 * A modification of BoundedList from the Lists module
 * for use with sorting algorithms
 *
 * @author Jalal Kawash
 */

import java.lang.reflect.Array;

public class BoundedList<T extends Comparable> 
{
   // accessible members from subclasses
    T[] list;
    int size;
    int currentIndex;

    /**
     * Constructor for objects of class BoundedList
     */
    public BoundedList(Class<T> clazz, int maxSize)
    {
        list = (T[]) Array.newInstance(clazz, maxSize);
        size = 0;
        currentIndex = -1;
        
    }

    /**
     * Precondition: None
     * Postcondition: returns true if list is empty
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    /**
     * Precondition: None
     * Postcondition: returns true if list is full
     */
    public boolean isFull()
    {
        return (size == list.length);
    }
    
    /**
     * Precondition: None
     * Postcondition: returns size of the list
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Precondition: None
     * Postcondition: deletes all the elements in the list and resests it to theinitial condition
     */
    public void clear()
    {
        size = 0;
        currentIndex = -1;
    }
    
    /**
     * Precondition: None
     * Postcondition: resets the current index to the begining of the list; throws an exception if list is empty
     */
    public void reset()
    {
        currentIndex = 0;
    }
    
    /**
     * Precondition: None
     * Postcondition: returns the position of the item the list; returns -1 if the item is not in the list
     */
    public int contains(T item) 
    {
        if (!isEmpty())
        {
            int i = 0;
            while (i < size) 
            {
                   if (item.compareTo(list[i]) == 0) return i;
                   i++;
            }
        }
        return -1;
    }
    
    /**
     * Precondition: None
     * Postcondition: Adds a new element to the list; throws an exception if the list is full
     */
    public void add(T item) 
    {
        if (!isFull())
        {
            list[size] = item;
            size++;
        }
    }
    
    /**
     * Swap method needed for sorting algorithms
     * 
     * Precondition: list is not empty
     * Postcondition: swaps to items at indices i and j in the list
     */
    public void swap(int i, int j)
    {
       T tmp = list[i];
       list[i] = list[j];
       list[j] = tmp;
    }
    
    /**
     * Retruns an item at a given index
     * Needed for sorting algorithms
     * 
     * Precondition: list is not empty
     * Postcondition: returns item at index i
     */
    public T getItem(int i)
    {
       return list[i];
    }
    
    /**
     * Retruns an the index of the minimum item in the list based on a comparable key
     * Needed for sorting algorithms
     * 
     * Precondition: list is not empty
     * Postcondition: returns the index of item with min key in the list
     */
    public int getMinIndex(int low, int high)
    {
       int minIndex = low;
       T minSoFar = list[low];
       for (int i = low+1; i <= high; i++)
           if (list[i].compareTo(minSoFar) < 0)
           {
               minSoFar = list[i];
               minIndex = i;
            }
       return minIndex;
    }
    
    /**
     * Retruns an the index of the maximum item in the list based on a comparable key
     * Needed for sorting algorithms
     * 
     * Precondition: list is not empty
     * Postcondition: returns the index of item with max key in the list
     */
    public int getMaxIndex(int low, int high)
    {
       int maxIndex = low;
       T maxSoFar = list[low];
       for (int i = low+1; i <= high; i++)
           if (list[i].compareTo(maxSoFar) > 0)
           {
               maxSoFar = list[i];
               maxIndex = i;
            }
       return maxIndex;
    }
    
    /**
     * Precondition: None
     * Postcondition: prints the contents of the list
     */
    public void printList()
    {
       System.out.print("list: ");
       for (int i = 0; i < size; i++)
       {
            System.out.print(list[i] + ", ");
       }
       System.out.println("end-list");
    }
    
    /**
     * Precondition: None
     * Postcondition: prints the contents of the list; used with quickSort to show the partitions
     */
    public void printList(int pivot)
    {
       for (int i = 0; i < size; i++)
       {
            if (i == pivot) System.out.print("[");
            System.out.print(list[i]);
            if (i == pivot) System.out.print("]");
            if (i < size - 1) System.out.print(", ");
       }
       System.out.println();
    }
}
