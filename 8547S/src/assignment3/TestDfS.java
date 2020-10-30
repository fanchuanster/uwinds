/**
 * 
 */
package assignment3;

import java.io.File;
import graphs.*;

/**
 * @author donwen
 *
 */
public class TestDfS {
	
	public static final String INPUT_DATA_DIR = "resources\\graphs\\";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String dgFileName = "mediumDG.txt";
		File file = new File(INPUT_DATA_DIR + dgFileName);
		Digraph digraph = new Digraph(new In(file));
        
		long start = System.currentTimeMillis();
		DepthFirstOrder dfs = new DepthFirstOrder(digraph);
        System.out.println(String.format("Composing DepthFirstOrder from %s. \nTime spent: %d", dgFileName, System.currentTimeMillis() - start));

        System.out.println(dgFileName);
        
        System.out.print("Pre-order:  ");
        for (int v : dfs.pre()) {
        	System.out.print(v + " ");
        }
        System.out.println();
        
        System.out.print("Post-order: ");
        start = System.currentTimeMillis();
        for (int v : dfs.post()) {
        	System.out.print(v + " ");
        }
        StdOut.println();
	}

}
