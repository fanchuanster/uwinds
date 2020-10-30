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
public class TestLargeDGDfs {
	
	public static final String INPUT_DATA_DIR = "resources\\graphs\\";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String dgFileName = "mediumDG.txt";
		File file = new File(INPUT_DATA_DIR + dgFileName);
		Digraph digraph = new Digraph(new In(file));
        
        DepthFirstOrder dfs = new DepthFirstOrder(digraph);


        System.out.println(dgFileName);
        System.out.print("Pre-order:  ");
        for (int v : dfs.pre()) {
        	System.out.print(v + " ");
        }
        System.out.println();

        System.out.print("Post-order: ");
        for (int v : dfs.post()) {
        	System.out.print(v + " ");
        }
        StdOut.println();
	}

}
