import java.util.*;

import java.util.stream.IntStream; 

public class Assignment1 {
	static private Random aR = new Random();
	static private char[] charArray = new char[10]; 
	
	static private String createRandomString(int length)
	{
		int[] intArray = aR.ints(10, 'a', 'z'+1).toArray();
		
		for (int i=0; i<10; i++)
		{
			charArray[i] = (char)intArray[i];
		}
		return String.valueOf(charArray);
	}
	
	static private String[] createRandomStringArray(int n)
	{
		String[] aList = new String[n];
		for (int i=0; i<n; i++)
		{
			aList[i] = createRandomString(10);
		}
		return aList;
	}
	
	static private Hashtable<String, Integer> createHT(String[] aList)
	{
		Hashtable<String, Integer> hashTable = new Hashtable<String, Integer>();

		long startTime = System.currentTimeMillis( );
		for (int i=0; i<aList.length; i++)
		{
			hashTable.put(aList[i], i);
		}		
		long totalTime = System.currentTimeMillis( ) - startTime;

		return hashTable;
	}

	static private void deleteFromHT(Hashtable<String, Integer> hashTable, String[] toDeletes)
	{
		for (int i=0; i<toDeletes.length; i++)
		{
			String key = toDeletes[i];
			Integer v = hashTable.get(key);
			if (v != null)
			{
				hashTable.remove(key);
			}
		}
	}
	
	/*
	 * static private void testTrees() { }
	 */
	/*
	 * static private void testBSTree() { System.out.println("testBSTree start...");
	 * BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	 * 
	 * long startTime = System.currentTimeMillis(); int to = 100000; for (int i=1;
	 * i<=to; i++) { bst.add(i); } long totalTimeAdd = System.currentTimeMillis( ) -
	 * startTime;
	 * 
	 * startTime = System.currentTimeMillis(); int[] ints = aR.ints(to, 1,
	 * to+1).toArray(); for (int i : ints) { int res = bst.get(i); assert res > 0 :
	 * "Failed to get " + i; } long totalTimeGet = System.currentTimeMillis( ) -
	 * startTime;
	 * 
	 * startTime = System.currentTimeMillis(); int from = 1; IntStream.range(1,
	 * to+1).map(i -> to - i + from).forEachOrdered(n -> { bst.remove(n); }); long
	 * totalTimeDeletion = System.currentTimeMillis( ) - startTime;
	 * 
	 * System.out.format("add %d\tget %d\tdelete %d%n", totalTimeAdd,totalTimeGet,
	 * totalTimeDeletion);
	 * 
	 * }
	 */
	private static void testHashtable()
	{
		for (int i=1; i<=20; i++)
		{
			int n = (int) Math.pow(2, i);
			
			String[] stringArray = createRandomStringArray(n);
			
			long startTime = System.currentTimeMillis();
			Hashtable<String, Integer> hashTable = createHT(stringArray);
			long totalTime = System.currentTimeMillis( ) - startTime;
			
			String[] stringArrayForDeletion = createRandomStringArray(n);
			
			startTime = System.currentTimeMillis();
			deleteFromHT(hashTable, stringArrayForDeletion);
			long totalTimeDeletion = System.currentTimeMillis( ) - startTime;
			
			System.out.format("%d\t%d\t%d%n", i, totalTime, totalTimeDeletion);
			System.out.println(hashTable.size());
		}
	}
	
	public static void main(String[] args)
	{
		testHashtable();
	}

}
