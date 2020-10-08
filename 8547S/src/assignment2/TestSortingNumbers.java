/**
 * 
 */
package assignment2;

import sorting.Sort;
import java.util.Random;

/**
 * @author donwen
 *
 */
public class TestSortingNumbers {
	static final long LONG_MAX = 2147483647;
	
	/**
	 * Test a given algorithm
	 * @param algorithmName the algorithm name to test, it can be Mergesort, Quicksort, Heapsort or dual-pivot Quicksort.
	 * @param numbers the input numbers array to sort
	 * @return time in milliseconds it has taken to sort 
	 */
	public static int testSorting(String algorithmName, long[] numbers) {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int n = 10000;
		Random aR = new Random();
		long[] numbers = aR.longs(n, 0, LONG_MAX).toArray();
		
		String[] algorithms = { "Mergesort", "Quicksort", "Heapsort", "dual-pivot Quicksort" };
		
		int totalTime = 0;
		totalTime += testSorting("Mergesort", numbers);
	}

}
