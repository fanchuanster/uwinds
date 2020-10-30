/**
 * 
 */
package assignment3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import graphs.DepthFirstOrder;
import graphs.Digraph;
import graphs.DijkstraSP;
import graphs.DirectedEdge;
import graphs.EdgeWeightedDigraph;
import graphs.In;
import graphs.StdOut;

/**
 * @author donwen
 *
 */
public class TestAllPairsSP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String dgFileName = "mediumEWG.txt";
		File file = new File(TestDfS.INPUT_DATA_DIR + dgFileName);
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(file));
        
		double[][] shortestDistances = new double[G.V()][G.V()];
		
		System.out.println(String.format("Find shortest path for all pairs - %s", dgFileName));
		
		long start = System.currentTimeMillis();
		
		for (int s=0; s<G.V(); s++) {
			// compute shortest paths
	        DijkstraSP sp = new DijkstraSP(G, s);

	        for (int t = 0; t < G.V(); t++) {
	            if (sp.hasPathTo(t)) {
	            	shortestDistances[s][t] = sp.distTo(t);
	            }
	            else {
	            	shortestDistances[s][t] = -1;
	            }
	        }
		}
		long total = System.currentTimeMillis() - start;
		
		String outfile = "sp_all_pairs.txt";
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(outfile));
			for (int i=0; i<G.V(); i++) {
				for (int j=0; j<G.V(); j++) {
					if (shortestDistances[i][j] >= 0) {
						out.write(String.format("%.2f\t", shortestDistances[i][j]));
					} else {
						out.write("N\t");
					}
				}
				out.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    if(out != null) {
		        try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
		
		System.out.println(String.format("Total time: %d ms.\nFind results in %s", total, outfile));
	}

}
