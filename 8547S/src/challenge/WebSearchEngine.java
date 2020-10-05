/**
 * 
 */
package challenge;

import java.util.Hashtable;
import heaps.BinaryHeap;
import java.io.File;
/**
 * Given a set of keywords as input, it ranks the web pages based on their score (score = sum of matches per keyword, or keyword * frequency). 
 * The program should list the top 10 pages with the best matches
 * @author donwen
 *
 */
public class WebSearchEngine {
	
	public static int GetFileMatchScore(String filePath, String[] keywords) {
		Hashtable<String, Integer> hashtable = WordsCounter.CountWords(filePath);
		int score = 0;
		for (String keyword:keywords) {
			if (hashtable.containsKey(keyword)) {
				score += hashtable.get(keyword);
			}
		}
		return score;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (String arg:args) {
			System.out.println(arg);
		}
		
		final String INPUT_DIR = "resources\\W3C Web Pages\\Text\\";
		final boolean REVERSE_COMPARE = true;

		BinaryHeap<FileScore> heap = new BinaryHeap<FileScore>();
		
		File dir = new File(INPUT_DIR);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
		  for (File file : directoryListing) {
		  	int score = GetFileMatchScore(file.getAbsolutePath(), args);
		  	heap.insert(new FileScore(file.getName(), score, REVERSE_COMPARE));
		  }
		}
		
		FileScore fs = null;
		while ((fs = heap.deleteMin()) != null) {
			System.out.println(String.format("%d\t%s", fs.getScore(), fs.getFile()));
			
		}
	}
}
