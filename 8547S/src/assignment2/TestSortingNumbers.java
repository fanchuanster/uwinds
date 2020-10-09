/**
 * 
 */
package assignment2;

import sorting.Sort;
import java.util.Random;
import java.util.Arrays;

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
	public static long testSorting(String algorithmName, Long[] numbers) {
		long start = System.currentTimeMillis();
		if (algorithmName.equals("Mergesort")) {
			Sort.mergeSort(numbers);
		} else if (algorithmName.equals("Quicksort")) {
			Sort.quicksort(numbers);
		} else if (algorithmName.equals("Heapsort")) {
			Sort.heapsort(numbers);
		} else if (algorithmName.equals("dual-pivot Quicksort")) {
//			Sort.
		} else {
			System.err.println("Unknown algorithm name " + algorithmName);
		}
		return System.currentTimeMillis() - start;
	}
	
	private static Long[] getRandomLongArray(long n) {
		Random aR = new Random(System.currentTimeMillis());
		long[] primitiveNumbers = aR.longs(n, 0, LONG_MAX).toArray();
		Long[] numbers = new Long[primitiveNumbers.length];
		for (int i=0; i<primitiveNumbers.length; i++) {
			numbers[i] = primitiveNumbers[i];
		}
		return numbers;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final long n = 100000;
		final int TEST_TIMES = 10;
		
		String[] algorithms = { "Mergesort", "Quicksort", "Heapsort", /* "dual-pivot Quicksort" */ };
		
		System.out.println(String.format("Testing sorting algorithms with %d random numbers for %d times, average time as below:", n, TEST_TIMES));
		System.out.println(("Algorithsm\tAvg time(ms)"));
		
		for (String algorithm:algorithms) {
			int totalTime = 0;
			for (int i=0; i<TEST_TIMES; i++) {
				Long[] numbers = getRandomLongArray(n);

				totalTime += testSorting(algorithm, numbers);
			}
			
			System.out.println(String.format("%s\t%d", algorithm, totalTime/TEST_TIMES));
		}		
	}

}
