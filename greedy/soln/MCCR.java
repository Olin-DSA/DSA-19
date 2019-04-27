import java.util.LinkedList;

public class MCCR {

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graphprivate IndexMinPQ<Double> pq;
     */
    public static int MCCR(EdgeWeightedGraph G) {
        Edge[] edgeTo = new Edge[G.numberOfV()]; // edgeTo[v] = shortest edge from roaded vertex to un-roaded vertex
        int[] distTo = new int[G.numberOfV()]; // distTo[v] = weight of shortest such edge
        boolean[] marked = new boolean[G.numberOfV()]; // marked[v] = true if v on is connected by road, false otherwise
        IndexPQ<Integer> pq = new IndexPQ<Integer>(G.numberOfE()); // a queue of vertex, and each vertex's priority is decided by the weight the edge that connects to the vertex

        for (int v = 0; v < G.numberOfV(); v++) {
            distTo[v] = Integer.MAX_VALUE; // setting all distance to infinity
        }
        for (int v = 0; v < G.numberOfV(); v++) { // run from each vertex in graph
            if (!marked[v]) {
                distTo[v] = 0; //mark weight of current vertex as 0, and put into pq
                pq.insert(v, distTo[v]);
                while (!pq.isEmpty()) {
                    int smallv = pq.delMin(); //find the vertex that costs the least to go to.
                    marked[smallv] = true; // marked smallv as roaded, as in smallv is connected by road.
                    for (Edge e : G.edges(smallv)) { // for all edges of smallv
                        int w = e.other(smallv);  //w is a neighbour of smallv
                        if (marked[w]) continue;         // if w is already road, then smallv-w is obsolete edge
                        if (e.weight() < distTo[w]) {   //if a lower edge weight is found, update the weight
                            distTo[w] = e.weight();
                            edgeTo[w] = e;
                            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]); // put the new weight on pq
                            else pq.insert(w, distTo[w]);
                        }
                    }
                }
            }
        }
        int weight = 0;
        Edge mccrEdge;
        for (int i = 0; i < edgeTo.length;i++){
            mccrEdge = edgeTo[i];
            if (mccrEdge!=null) {
                weight += mccrEdge.weight();
            }
        }
        return weight;
    }

}

/**
 *  The {@code PrimMST} class represents a data type for computing a
 *  <em>minimum spanning tree</em> in an edge-weighted graph.
 *  The edge weights can be positive, zero, or negative and need not
 *  be distinct. If the graph is not connected, it computes a <em>minimum
 *  spanning forest</em>, which is the union of minimum spanning trees
 *  in each connected component. The {@code weight()} method returns the
 *  weight of a minimum spanning tree and the {@code edges()} method
 *  returns its edges.
 *  <p>
 *  This implementation uses <em>Prim's algorithm</em> with an indexed
 *  binary heap.
 *  The constructor takes time proportional to <em>E</em> log <em>V</em>
 *  and extra space (not including the graph) proportional to <em>V</em>,
 *  where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 *  Afterwards, the {@code weight()} method takes constant time
 *  and the {@code edges()} method takes time proportional to <em>V</em>.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/43mst">Section 4.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

/**
 Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
 Last updated: Fri Oct 20 12:50:46 EDT 2017.
 */
