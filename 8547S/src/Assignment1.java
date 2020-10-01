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
	@SuppressWarnings("unchecked")
	static private void actionTree(Object treeObject, String action, int[] numbers) {
		
		int n = numbers.length;
		
		long startTime = System.nanoTime();
		
		if (treeObject instanceof AVLTree<?>) {
			AVLTree<Integer> tree = (AVLTree<Integer>) treeObject;
			for (int i=0; i<n; i++)
			{
				if (action.equals("insert")) {
					tree.insert(numbers[i]);
					tree.checkBalance();
				} else if (action.equals("search")) {
					tree.contains(numbers[i]);
				} else if (action.equals("deletion")) {
					tree.remove(numbers[i]);
					tree.checkBalance();
				}
			}
		} else if (treeObject instanceof BinarySearchTree<?>) {
			BinarySearchTree<Integer> tree = (BinarySearchTree<Integer>) treeObject;
			for (int i=0; i<n; i++) {
				if (action.equals("insert")) {
					tree.insert(numbers[i]);
				} else if (action.equals("search")) {
					tree.contains(numbers[i]);
				} else if (action.equals("deletion")) {
					tree.remove(numbers[i]);
				}
			}
		} else if (treeObject instanceof RedBlackBST<?, ?>) {
			RedBlackBST<Integer, Integer> tree = (RedBlackBST<Integer, Integer>) treeObject;
			for (int i=0; i<n; i++)
			{
				if (action.equals("insert")) {
					tree.put(numbers[i], numbers[i]);
				} else if (action.equals("search")) {
					tree.get(numbers[i]);
				} else if (action.equals("deletion")) {
					tree.delete(numbers[i]);
				}
			}
		} else if (treeObject instanceof SplayTree<?>) {
			SplayTree<Integer> tree = (SplayTree<Integer>) treeObject;
			for (int i=0; i<n; i++)
			{
				if (action.equals("insert")) {
					tree.insert(numbers[i]);
				} else if (action.equals("search")) {
					tree.contains(numbers[i]);
				} else if (action.equals("deletion")) {
					tree.remove(numbers[i]);
				}
			}
		}
		
		long totalTime = System.nanoTime() - startTime;
		
		System.out.format("%d\t", totalTime/n);	
	}
	
	private static Object CreateTree(String treeType) {
		switch (treeType) {
		case "bs":
			return new BinarySearchTree<Integer>();
		case "avl":
			return new AVLTree<Integer>();
		case "rb":
			return new RedBlackTree<Integer>();
		case "splay":
			return new SplayTree<Integer>();
		default:
			return null;
		}
	}
	
	private static void testTree(String treeType, int[] numbers, int[] findNumbers, int[] deleteNumbers) {
		Object treeObject = CreateTree(treeType);
		actionTree(treeObject, "insert", numbers);
		actionTree(treeObject, "search", findNumbers);
		actionTree(treeObject, "deletion", deleteNumbers);
		System.out.println();
	}
	 
	static private void testTrees() {
		final int n = 100000;
		int[] numbers = IntStream.rangeClosed(1, n).toArray();
		int[] randomNumbers = aR.ints(n, 1, n+1).toArray();
		int[] reversedNumbers = IntStream.rangeClosed(1, numbers.length).map(i -> numbers[numbers.length-i]).toArray();
		
		testTree("bs", numbers, randomNumbers, reversedNumbers);
		testTree("avl", numbers, randomNumbers, reversedNumbers);
		testTree("bs", numbers, randomNumbers, reversedNumbers);
//		testTree("bs", numbers, randomNumbers, reversedNumbers);
	  
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
