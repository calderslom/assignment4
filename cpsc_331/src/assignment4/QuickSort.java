package assignment4;

/**
 * Performs the quick sort algorithm on an array of integers.
 * <p>
 * Note: This code was heavily based on the code provided by @author Jalal Kawash in CPSC 331
 * I also referred to https://www.geeksforgeeks.org/quick-sort/ when modifying the source code.
 * It is an adaptation of that code designed to work only with arrays of integers.
 *  
 * @author Calder Sloman
 *
 *
 */


public class QuickSort {
	
    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {						
            return;
        }
        recQuickSort(array, 0, array.length - 1);
    }

    private static void recQuickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            recQuickSort(array, low, pivot-1);
            recQuickSort(array, pivot+1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low-1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, high);
        return i+1;
    }

    /**
     * @param arr the array that needs to modified
     * @param i first index of element to be swapped
     * @param j second index of element to be swapped
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}