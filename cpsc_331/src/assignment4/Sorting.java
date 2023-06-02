package assignment4;

/**
 * An implementation for sorting algorithms on a BoundedList ADT
 * Sorting a linked lists is left as an exercise
 *
 * @author Jalal Kawash
 * 
 */

 public class Sorting<T>
 {
     public static final int ASC = 0;    
     public static final int DESC = 1;
     public static final boolean SHOW_STEPS = true;
 
     /**
      * An implemntation of Bubble Sort
      *
      * @precond: none
      * @postcond: the input list is sorted in ascending or descending order
      */
     public static void bubbleSort(BoundedList list, int sortType)
     {
         if (list.isEmpty()) return;
         
         if (sortType == ASC)
             for (int i = 0; i < list.size(); i++)
                for (int j = list.size()-1; j > i; j--)
                    if(list.getItem(j).compareTo(list.getItem(j-1)) < 0)
                        list.swap(j, j-1);
     
         if (sortType == DESC)
             for (int i = 0; i < list.size(); i++)
                for (int j = list.size()-1; j > i; j--)
                    if(list.getItem(j).compareTo(list.getItem(j-1)) > 0)
                        list.swap(j, j-1);
     }
     
     /**
      * An implemntation of Insertion Sort
      *
      * @precond: none
      * @postcond: the input list is sorted in ascending or descending order
      */
     public static void insertionSort(BoundedList list, int sortType)
     {
         if (list.isEmpty()) return;
         
         if (sortType == ASC)
             for (int i = 1; i < list.size(); i++)
             {
                int j= i;
                while (j !=0 && list.getItem(j).compareTo(list.getItem(j - 1)) < 0)
                {
                        list.swap(j,j-1);
                        j--;
                }
             }
     
         if (sortType == DESC)
             for (int i = 1; i < list.size(); i++)
             {
                int j= i;
                while (j !=0 && list.getItem(j).compareTo(list.getItem(j - 1)) < 0)
                {
                        list.swap(j,j-1);
                        j--;
                }
             }
     }
     
     /**
      * An implemntation of Selection Sort
      *
      * @precond: none
      * @postcond: the input list is sorted in ascending or descending order
      */
     public static void selectionSort(BoundedList list, int sortType)
     {
         if (list.isEmpty()) return;
         
         if (sortType == ASC)
             for (int i = 0; i < list.size()-1; i++)
             {
                int minIndex = list.getMinIndex(i,list.size()-1);
                System.out.println("Min index " + minIndex);
                list.swap(i, minIndex);
                list.printList();
             }
         
         if (sortType == DESC)
             for (int i = 0; i < list.size()-1; i++)
             {
                int maxIndex = list.getMaxIndex(i,list.size()-1);
                list.swap(i, maxIndex);
             }
     }
     
     /**
      * An implemntation of Quick Sort
      *
      * @precond: none
      * @postcond: the input list is sorted in ascending  order
      */
     public static void quickSort(BoundedList list)
     {
         if (list.isEmpty()) return;
         else recQuickSort(list, 0, list.size()-1);  
     }
     
     private static void recQuickSort(BoundedList list, int low, int high)
     {
         if (low < high) 
         {
             int pivot = partition(list, low, high);
             recQuickSort(list, low, pivot-1);
             recQuickSort(list, pivot+1, high);
         }
     }
     
     private static int partition(BoundedList list, int low, int high)
     {
         Comparable x = list.getItem(high);
         int i = low - 1;
         for (int j = low; j < high; j++)
             if (list.getItem(j).compareTo(x) <= 0) 
             {
                 i++;
                 if (i != j) 
                 {
                     if (SHOW_STEPS) System.out.printf("Swap %d <-> %d\n", list.getItem(i), list.getItem(j));
                     list.swap(i,j);
                     if (SHOW_STEPS) list.printList();
                 }
             }
         if (high != i+1) list.swap(high,i+1);
         //if (SHOW_STEPS) System.out.printf("Pivot is %d, ",list.getItem(i+1));
         if (SHOW_STEPS) list.printList(i+1);
         return i+1;
     }
     
     /**
      * An implemntation of Merge Sort
      *
      * @precond: none
      * @postcond: the input list is sorted in ascending  order
      */
     public static void mergeSort(BoundedList list)
     {
         if (list.isEmpty()) return;
         else 
         {
             int n = list.size();
             Comparable[] array = new Comparable[n];
             for (int i = 0; i < n; i++) array[i] = list.getItem(i);
             recMergeSort(array, 0, n-1);
             list.clear();
             for (int i = 0; i < n; i++) list.add(array[i]);
         }
     }
     
     private static void recMergeSort(Comparable[] array, int low, int high)
     {
         if (low < high)
         {
             int midPoint = (low+high)/2;
             if (SHOW_STEPS) 
             {
                 //System.out.printf("Mid=%d,  low=%d, high=%d\n",array[midPoint], low, high);
                 System.out.printf("[ ");   
                 for (int i = low; i <= midPoint; i++) 
                 {
                     //if (i == midPoint) System.out.printf("*");
                     System.out.printf("%d ", array[i]);
                 }
                 
                 System.out.printf("]");   
                 System.out.printf("[ ");   
                 for (int i = midPoint+1; i <= high; i++) System.out.printf("%d ", array[i]);
                 System.out.printf("]\n"); 
             }
             recMergeSort(array, low, midPoint);
             recMergeSort(array, midPoint+1, high);
             merge(array, low, high, midPoint);
         }
     }
     
     private static void merge(Comparable[] array, int low, int high, int mid)
     {
         BoundedList mergedList = new BoundedList(Comparable.class, high-low+1);
         int n1 = mid-low+1;
         int n2 = high-mid;
         Comparable[] L = new Comparable[n1];
         for (int i = 0; i < n1; i++) L[i] = array[low+i];
         Comparable[] R = new Comparable[n2];
         for (int i = 0; i < n2; i++) R[i] = array[mid+1+i];
         if (SHOW_STEPS) 
         {
          System.out.printf("[ ");   
          for (int i = 0; i < n1; i++) System.out.printf("%d ", L[i]);
          System.out.printf("] ++ ");   
          System.out.printf("[ ");   
          for (int i = 0; i < n2; i++) System.out.printf("%d ", R[i]);
          System.out.printf("]");   
         }
         
         int i = 0;
         int j = 0;
         int k = low;
         
         while (i < n1 && j < n2)
         {
             if (L[i].compareTo(R[j]) <= 0)
             {
                 array[k] = L[i];
                 i++;
             }
             else 
             {
                 array[k] = R[j];
                 j++;
             }
             k++;
         }
         
         while(i < n1)
         {
             array[k] = L[i];
             i++;
             k++;
         }
         
         while(j < n2)
         {
             array[k] = R[j];
             j++;
             k++;
         }
         
         if (SHOW_STEPS) 
             {
              System.out.printf(" = [ ");   
              for (int m = low; m <= high; m++) System.out.printf("%d ", array[m]);
              System.out.printf("]\n");   
             }
     }
 }