package assignment3;

import graphs.CC;
import graphs.Graph;
import graphs.Queue;
import graphs.StdIn;
import graphs.StdOut;
import graphs.SymbolGraph;

public class TestConnectedComponents {

	public static void main(String[] args) {
		String dgFileName = "movies.txt";
		SymbolGraph sg = new SymbolGraph(TestDfS.INPUT_DATA_DIR + dgFileName, "/");
        Graph G = sg.G();
        
        long start = System.currentTimeMillis();
        CC cc = new CC(G);

        // number of connected components
        int componentsNumber = cc.count();
        long end = System.currentTimeMillis();

        System.out.println(componentsNumber + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[componentsNumber];
        for (int i = 0; i < componentsNumber; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < componentsNumber; i++) {
            for (int v : components[i]) {
            	System.out.print(v + " ");
            }
            System.out.println();
        }
        
        System.out.println(componentsNumber + " components in all.");
        System.out.println(String.format("It took %d ms to use DFS identifying the components.", end-start));
        
        String[] actors = {"DiCaprio, Leonardo", "Roberts, Julia (I)", "Grant, Hugh (I)"};
        for (String actor:actors) {
        	if (sg.contains(actor)) {
                int s = sg.index(actor);
                System.out.println("Movies starred by " + actor);
                for (int v : G.adj(s)) {
                    StdOut.println("   " + sg.name(v));
                }
            }
            else {
                StdOut.println("input does not contain '" + actor + "'\n");
            }
        }
	}

}
