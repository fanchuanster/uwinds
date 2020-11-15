package assignment4;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import common.util;

public class Task4 {
    
    static String[] findPattern(File file, Pattern pattern) {
		
	    Matcher matcher = pattern.matcher(util.readFile(file));
	    // Check all occurrences
	    ArrayList<String> emails = new ArrayList<String>();
	    while (matcher.find()) {	        
	        String key = matcher.group();
	        emails.add(key);
	    }
	    String[] array = new String[emails.size()];
	    emails.toArray(array);
	    return array;
	}
    

	public static void main(String[] args) {
		final Pattern EMAIL_ADDRESS_PATTERN = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
		
		final String inputTextDir = "output/";
		File directory = new File(inputTextDir);
		File[] files = directory.listFiles();
		
		Set<String> emailsSet = new HashSet<String>();
		Set<String> phoneNumberSet = new HashSet<String>();
		for ( File f : files) {
			if (!f.isFile()) {
				continue;
			}
			
			String[] emails = findPattern(f, EMAIL_ADDRESS_PATTERN);
			for (String email:emails) {
				emailsSet.add(email);
			}
			String[] phoneNumbers = findPattern(f, PHONE_NUMBER_PATTERN);
			for (String phoneNumber:phoneNumbers) {
				phoneNumberSet.add(phoneNumber);
			}
		}
		
		System.out.println("Found unique emails " + emailsSet.size());
		System.out.println("Found unique phone numbers " + phoneNumberSet.size());
	}
}
