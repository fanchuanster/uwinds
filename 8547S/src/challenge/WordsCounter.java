/**
 * 
 */
package challenge;

import java.util.Hashtable;
import java.util.stream.IntStream;
import java.io.StreamTokenizer;
import java.io.FileReader;
import java.io.IOException;

/**
 * Count occurrences for each word in input files.
 * @author donwen
 *
 */
public class WordsCounter {

	public static Hashtable<String, Integer> CountWords(String filePath) {
		FileReader fr = null;
		try {
			fr = new FileReader(filePath);
		} catch (IOException e) {
			System.err.println("Failed to open file " + filePath);
			return null;
		}
		
		StreamTokenizer tokenizer = new StreamTokenizer(fr);
		tokenizer.lowerCaseMode(true);
		
		tokenizer.ordinaryChars(0, (int)'A' - 1);
		tokenizer.ordinaryChars((int)'Z' + 1, (int)'a' - 1);
		tokenizer.ordinaryChars((int)'z' + 1, 256);
		tokenizer.wordChars((int)'0', (int)'9');
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		try {
			int token = tokenizer.nextToken();
			while (token != StreamTokenizer.TT_EOF) {
				switch (token) {
				case StreamTokenizer.TT_WORD:
					String word = tokenizer.sval;
					int count = ht.containsKey(word) ? ht.get(word) : 0; 
					ht.put(word, count + 1);
					break;
				default:
					break;
				}
				token = tokenizer.nextToken();
			}
		} catch (IOException e) {
			System.err.println("Failed to nextToken " + filePath);
			e.printStackTrace();
		}
		return ht;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		Hashtable<String, Integer> ht = CountWords("resources\\W3C Web Pages\\Text\\Accessibility - W3C.txt");

		System.out.println(ht.size());
		
		
	}

}
