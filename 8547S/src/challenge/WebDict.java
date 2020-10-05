package challenge;

import searchtrees.SplayTree;

import java.io.File;
import java.util.Hashtable;

import heaps.BinaryHeap;

public class WebDict {
	
	private Hashtable<String, Integer> wordsFrequencies = new Hashtable<String, Integer>();
	
	public SplayTree<IntKeyObject> getDictTree(boolean ascending) {
		SplayTree<IntKeyObject> sptree = new SplayTree<IntKeyObject>();
		wordsFrequencies.forEach((word, frequency) -> {
			sptree.insert(new IntKeyObject(frequency, word, ascending));
		});
		
		return sptree;
	}
	public void add(Hashtable<String, Integer> newWordsFrequencies) {
		newWordsFrequencies.forEach((key, val) -> {
			Integer newVal = wordsFrequencies.containsKey(key) ? wordsFrequencies.get(key) + val : val;
			wordsFrequencies.put(key, newVal);
		});
	}

	public static void main(String[] args) {
		
		final int TOP_LEAST_N = 10;
		final int TOP_MOST_N = 10;

		WebDict webDict = new WebDict();
		
		File dir = new File(WebSearchEngine.INPUT_PAGES_DIR);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
		  for (File file : directoryListing) {
			  Hashtable<String, Integer> wordsFrequencies = WordsCounter.CountWords(file.getAbsolutePath());
			  webDict.add(wordsFrequencies);
		  }
		}

		/*
		 * #5
		 */
		SplayTree<IntKeyObject> spTree = webDict.getDictTree(true);
		IntKeyObject[] wordsMostAndLeast = new IntKeyObject[TOP_MOST_N + TOP_LEAST_N];
		for (int i=0; i<TOP_MOST_N; i++) {
			if (spTree.isEmpty()) break;
			IntKeyObject wordMost = spTree.findMax();
			wordsMostAndLeast[i] = wordMost;
			spTree.remove(wordMost);
		}
		for (int i=0; i<TOP_LEAST_N; i++) {
			if (spTree.isEmpty()) break;
			IntKeyObject wordLeast = spTree.findMin();
			wordsMostAndLeast[TOP_MOST_N+TOP_LEAST_N-i-1] = wordLeast;
			spTree.remove(wordLeast);
		}
		System.out.println("Freq\tWord");
		for (int i=0; i<TOP_MOST_N + TOP_LEAST_N; i++) {
			if (wordsMostAndLeast[i] != null) {
				System.out.println(String.format("%d\t%s", wordsMostAndLeast[i].getKey(), wordsMostAndLeast[i].getContent()));
			}
		}
	}

}
