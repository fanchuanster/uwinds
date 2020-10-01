import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Random;
import java.util.stream.IntStream;

import hashTable.*;
import searchtrees.*;


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
	
	
	/**
	 * part II - trees
	 */
	static private void insertTree(AVLTree<Integer> tree, int[] numbers) {
		int n = numbers.length;
		
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			tree.insert(numbers[i]);
		}		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);	
	}
	
	static private void deleteFromTree(AVLTree<Integer> tree, int[] numbers) {
		int n = numbers.length;
		
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			tree.remove(numbers[i]);
			tree.checkBalance();
		}
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);
	}
	
	static private void testTree(String treeType, int[] numbers, int[] findNumbers, int[] deleteNumbers) {
		Object tree = null;
		
		int n = numbers.length;
		long startTime = System.nanoTime();
		for (int i=0; i<n; i++)
		{
			tree.insert(numbers[i]);
		}		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);	
	}
	
	static private void testTrees() {
		final int n = 10000;
		int[] numbers = IntStream.rangeClosed(1, n+1).toArray();
		int[] randomNumbers = aR.ints(n, 1, n+1).toArray();
		List reversedNumbers = Arrays.asList(numbers); 
		Collections.reverse();
		
		BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();
		insertTree(bsTree, numbers);
		
		AVLTree<Integer> avlTree = new AVLTree<Integer>();
		insertTree(avlTree, numbers);
		Collections.reverse(Arrays.asList(numbers));
		deleteFromTree(avlTree, ArrayUtils.reverse(numbers));
	  
	}
	 
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
//		testHashtable();
		testTrees();
	}

}
