package assignment4;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
			    Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);
		final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}" 
				+ "|(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}" 
				+ "|(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}");
		
		final String inputTextDir = "output/";
		File directory = new File(inputTextDir);
		File[] files = directory.listFiles();
		
		ArrayList<String> emailsList = new ArrayList<String>();
		ArrayList<String> phoneNumberList = new ArrayList<String>();
		for ( File f : files) {
			if (!f.isFile()) {
				continue;
			}
			
			String[] emails = findPattern(f, EMAIL_ADDRESS_PATTERN);
			for (String email:emails) {
				emailsList.add(email);
			}
			String[] phoneNumbers = findPattern(f, PHONE_NUMBER_PATTERN);
			for (String phoneNumber:phoneNumbers) {
				phoneNumberList.add(phoneNumber);
			}
		}
		
		ArrayList<String> uniqueEmails = (ArrayList) emailsList.stream().distinct().collect(Collectors.toList());
		ArrayList<String> uniquePhoneNumbers = (ArrayList) phoneNumberList.stream().distinct().collect(Collectors.toList());
		System.out.println(String.format("Found %d emails, %d unique emails:\n%s", emailsList.size(), uniqueEmails.size(), uniqueEmails.toString()));
		System.out.println();
		System.out.println(String.format("Found %d phone numbers, %d unique phone numbers:\n%s", phoneNumberList.size(),uniquePhoneNumbers.size(), uniquePhoneNumbers.toString()));
	}
}
