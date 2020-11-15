package common;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class util {

	public static String readFile(String filename) {

		try {
			File file = new File(filename);
		    StringBuilder fileContents = new StringBuilder((int)file.length());        

		    try (Scanner scanner = new Scanner(file)) {
		        while(scanner.hasNextLine()) {
		            fileContents.append(scanner.nextLine() + System.lineSeparator());
		        }
		        return fileContents.toString();
		    }
		} catch (IOException e) {
			System.err.println("Failed to open file " + filename);
			return null;
		}
	    
	}
	
}
