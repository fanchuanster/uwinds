package assignment3;

import java.io.File;

import graphs.CC;
import graphs.Graph;
import graphs.In;
import graphs.Queue;
import graphs.StdOut;

public class TestConnectedComponents {

	public static void main(String[] args) {
		String dgFileName = "movies.txt";
		In in = new In(new File(TestDfS.INPUT_DATA_DIR + dgFileName));
		
        Graph G = new Graph(in);
        CC cc = new CC(G);

        // number of connected components
        int M = cc.count();
        StdOut.println(M + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

	}

}
