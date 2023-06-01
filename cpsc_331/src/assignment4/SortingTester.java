package assignment4;

/**
 * A tester class for the BoundedList ADT
 *
 * @author Jalal Kawash
*/

import java.util.Random;

public class SortingTester
{
    public static final int ASC = 0;    
    public static final int DESC = 1;
    public static final int SIZE = 10;
    
    public static void main(String[] args) 
    {
        BoundedList<Integer> list = new BoundedList<Integer>(Integer.class,SIZE);
        Random rand = new Random();
        
        System.out.println("Creating a new random list of integers");
        
        for(int i = 0; i < SIZE; i++)
            list.add(rand.nextInt(100));
        
        System.out.println("List before sorting:");
        list.printList();
        
        Sorting.bubbleSort(list, ASC);
        System.out.println("List after sorting (Bubble sort):");
        list.printList();
        
        System.out.println("Creating a new random list of integers");
        list.clear();
        for(int i = 0; i < SIZE; i++)
            list.add(rand.nextInt(100));
        
        System.out.println("List before sorting:");
        list.printList();
        
        Sorting.insertionSort(list, ASC);
        System.out.println("List after sorting (Insertion sort):");
        list.printList();
        
        System.out.println("Creating a new random list of integers");
        list.clear();
        for(int i = 0; i < SIZE; i++)
            list.add(rand.nextInt(100));
        
        System.out.println("List before sorting:");
        list.printList();
        
        Sorting.selectionSort(list, ASC);
        System.out.println("List before sorting (Selection sort), ascending:");
        list.printList();
        Sorting.selectionSort(list, DESC);
        System.out.println("List after sorting (Selection sort), desceding:");
        list.printList();
        
        System.out.println("\n\nQuick Sort");
        System.out.println("Creating a new random list of integers");
        list.clear();
        for(int i = 0; i < SIZE; i++)
            list.add(rand.nextInt(100));
        System.out.println("List before sorting:");
        list.printList();
        Sorting.quickSort(list);
        System.out.println("List after sorting (Quick sort), ascending:");
        list.printList();
        
        System.out.println("\n\nMerge Sort");
        System.out.println("Creating a new random list of integers");
        list.clear();
        for(int i = 0; i < SIZE; i++)
           list.add(rand.nextInt(100));
        
        System.out.println("List before sorting:");
        list.printList();
        Sorting.mergeSort(list);
        System.out.println("List after sorting (Merge sort), ascending:");
        list.printList();
    }
}
