package common;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class util {

	public static String readFile(String filename) {
		File file = new File(filename);
		return readFile(file);	    
	}
	
	public static String readFile(File file) {
		try {
		    StringBuilder fileContents = new StringBuilder((int)file.length());        

		    try (Scanner scanner = new Scanner(file)) {
		        while(scanner.hasNextLine()) {
		            fileContents.append(scanner.nextLine() + System.lineSeparator());
		        }
		        return fileContents.toString();
		    }
		} catch (IOException e) {
			System.err.println("Failed to open file " + file.getName());
			return null;
		}
	}
	
}
