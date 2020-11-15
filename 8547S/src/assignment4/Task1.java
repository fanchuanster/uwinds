package assignment4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import memoryManagement.In;
import textprocessing.BoyerMoore;
import textprocessing.BruteForceMatch;
import textprocessing.KMP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task1 {
	

	static String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());        

	    try (Scanner scanner = new Scanner(file)) {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + System.lineSeparator());
	        }
	        return fileContents.toString();
	    }
	}
	
	static int[] searchPat(String[] patterns, String text, String algorithm, int times) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int N = text.length();
		for (String pat : patterns) {
			System.out.println("Indices of " + pat + ":");
			BoyerMoore boyermoore1 = new BoyerMoore(pat);
			int start = 0;
			while (start < N) {
				int index = boyermoore1.search(text.substring(start));
				if (start + index < N) {
//					System.out.print((start+index)+":"+text.substring(start+index, start+index+pat.length()));
					System.out.print((index+start) + ",");
				}
				
				start += index + 1;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		final int TIMES = 100;
		final String sourceDataFile = "resources/Hard disk.txt";
		String[] patterns = {"hard", "disk", "hard disk", "hard drive", "hard dist", "xltpru"};

		String fileString = readFile(sourceDataFile);
		
		
		
	}

}
