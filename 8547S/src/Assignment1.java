import java.util.Hashtable;
import java.util.Random;

//import hashTable.CuckooHashTable;
import hashTable.*;




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
		String[] strList = new String[n];
		for (int i=0; i<n; i++)
		{
			strList[i] = createRandomString(10);
		}
		return strList;
	}
	
//	CuckooHashTable
	static private void insertHT(CuckooHashTable<String> hashTable, String[] strList)
	{
		int n = strList.length;
		
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			hashTable.insert(strList[i]);
		}		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);
	}

	static private void deleteFromHT(CuckooHashTable<String> hashTable, String[] strList)
	{
		int n = strList.length;
		
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			hashTable.remove(strList[i]);
		}
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);
	}
	
	
	//	QuadraticProbingHashTable
	static private void insertHT(QuadraticProbingHashTable<String> hashTable, String[] strList)
	{
		int n = strList.length;
		
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			hashTable.insert(strList[i]);
		}		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);
	}

	static private void deleteFromHT(QuadraticProbingHashTable<String> hashTable, String[] strList)
	{
		int n = strList.length;
		
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			hashTable.remove(strList[i]);
		}
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);
	}
	
	
	//	SeparateChainingHashTable
	static private void insertHT(SeparateChainingHashTable<String> hashTable, String[] strList)
	{
		int n = strList.length;
		
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			hashTable.insert(strList[i]);
		}		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);
	}

	static private void deleteFromHT(SeparateChainingHashTable<String> hashTable, String[] strList)
	{
		int n = strList.length;
		
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			hashTable.remove(strList[i]);
		}
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);
	}
	
	/*
	 * static private void testTrees() { }

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
		System.out.println("i\tCuck I\tCuck D\tQuad I\tQuad D\tSpCh I\tSpCh D");
		for (int i=1; i<=20; i++)
		{
			int n = (int) Math.pow(2, i);
			
			System.out.format("%d\t", i);
			
			String[] strList = createRandomStringArray(n);
			String[] stringArrayForDeletion = createRandomStringArray(n);
			
			CuckooHashTable<String> cuckooHashTable = new CuckooHashTable<String>(new StringHashFamily(100), 10000);
			insertHT(cuckooHashTable, strList);
			deleteFromHT(cuckooHashTable, stringArrayForDeletion);
			
			QuadraticProbingHashTable<String> quadraticProbingHashTable = new QuadraticProbingHashTable<String>();
			insertHT(quadraticProbingHashTable, strList);
			deleteFromHT(quadraticProbingHashTable, stringArrayForDeletion);
			
			SeparateChainingHashTable<String> separateChainingHashTable = new SeparateChainingHashTable<String>();
			insertHT(separateChainingHashTable, strList);
			deleteFromHT(separateChainingHashTable, stringArrayForDeletion);
			System.out.println();
		}
		System.out.println();
		System.out.println("Insertion(I) and Deletion(D) average time in nano second");
	}
	
	public static void main(String[] args)
	{
		testHashtable();
	}

}
