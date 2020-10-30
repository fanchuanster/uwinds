/**
 * 
 */
package assignment3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import graphs.*;

/**
 * @author donwen
 *
 */
public class TestMST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String dgFileName = "meidumEWG.txt";
		In in = new In(TestDfS.INPUT_DATA_DIR + dgFileName);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
	}

}
