/**
 * 
 */
package challenge;

import java.util.ArrayList;
import java.util.Hashtable;

import searchtrees.SplayTree;

/**
 * @author donwen
 *
 */
public class SpellChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pathOfFileToCheck = "resources\\W3C Web Pages\\SpellCheckerTestPages\\Data - W3C.txt";
		Hashtable<String, Integer> wordsFrequencies = WordsCounter.CountWords(pathOfFileToCheck);
		
		System.out.println("Spell checking " + pathOfFileToCheck + "...");
		
		WebDict webDict = new WebDict();
		webDict.buildDict(WebSearchEngine.INPUT_PAGES_DIR);
		Hashtable<String, Integer> hashtable = webDict.getWordsFrequenciesAsHashtable();
		System.out.println("WebDict is of size " + hashtable.size());		
		
		ArrayList<IntKeyObject> missingWords = new ArrayList<IntKeyObject>();
		wordsFrequencies.forEach((word, freq) -> {
			if (!hashtable.containsKey(word)) {
				missingWords.add(new IntKeyObject(freq, word, true));
				hashtable.put(word, freq);
			}
		});
		
		System.out.println(missingWords.size() + " was missing as below and added to WebDict:");
		for (IntKeyObject obj:missingWords) {
			System.out.println(obj.getContent());
		}
		
		System.out.println("WebDict now is of size " + hashtable.size());
	}

}
