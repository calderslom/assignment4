package assignment4;

/**
 * 
 * Contains a static method designed to perform a Binary Search on an array of integers.
 * 
 * @author Calder Sloman
 *
 */

public class BinarySearch {

	/**
	 * Iterative Binary Search designed to look for integer values inside an array of integers.
	 * 
	 * @param x integer to search for
	 * @param arr the array to search x for
	 * @return the index of the cell containing x
	 */
	public static int searchArray(int x, int[] arr) {
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while (low <= high) {
			mid = (low+high)/2;
			if (x == arr[mid]) return mid;
			else if (x < arr[mid]) high = mid-1;
			else low = mid+1;
		}
		return -1;
	}
	
}
