package assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import memoryManagement.*;

public class Task5 {

	public static void main(String[] args) throws IOException {
		final String sourceDateFile = "resources/ChIP-seq reads/ChIP-seq-reads-1M.dat";
		String[] sublists = { "A.dat", "B.dat", "C.dat", "D.dat" };
		
		HashMap<String, FileWriter> outputs = new HashMap<String, FileWriter>();
		for (String f:sublists) {
			outputs.put(f, new FileWriter(f));
		}

		int mod = sublists.length;
		int c = 0;
		In in;
		try {
            in = new In(sourceDateFile);
            while (!in.isEmpty() && c < 100) {
                String s = in.readLine();
                outputs.get(sublists[c % mod]).write(s);
                c++;
            }
        }
        catch (Exception e) { System.out.println(e); }
        System.out.println("Done");
        
        Iterator it = outputs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            pair.getValue()
        }
	}

}
