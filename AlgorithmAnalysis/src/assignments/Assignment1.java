package assignments;

import java.util.*;

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
		System.out.println("insertion of " + aList.length + " took " + totalTime + " ms");
		return hashTable;
	}

	static private void deleteFromHT(Hashtable<String, Integer> hashTable, String[] toDeletes)
	{
		int hitCount = 0;
		
		long startTime = System.currentTimeMillis( );
		for (int i=0; i<toDeletes.length; i++)
		{
			String key = toDeletes[i];
			Integer v = hashTable.get(key);
			if (v != null)
			{
				hashTable.remove(key);
				hitCount++;
			}
		}
		long totalTime = System.currentTimeMillis( ) - startTime;
		System.out.println("deletion of " + hitCount + "/" + toDeletes.length + " took " + totalTime + " ms");
	}
	
	public static void main(String[] args)
	{
		for (int i=1; i<=20; i++)
		{
			System.out.println(i);
			int n = (int) Math.pow(2, i);
			
			String[] stringArray = createRandomStringArray(n);
			Hashtable<String, Integer> hashTable = createHT(stringArray);
			
			String[] stringArrayForDeletion = createRandomStringArray(n);
			deleteFromHT(hashTable, stringArrayForDeletion);
		}
	}

}
