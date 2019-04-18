import java.util.HashSet;


public class EdgeWeightedGraph {
    private HashSet<Edge>[] edges; // An array of hashSet. edges[v] is a HashSet of all v's edges
    private HashSet<Integer> vertices;
    private int E;

    public EdgeWeightedGraph(int V) { //initialize a graph with V number of  vertices
        edges = new HashSet[V];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new HashSet<>();
        }
        vertices = new HashSet<>(V);
    }

    public int numberOfV() {
        return vertices.size();
    }

    public int numberOfE() {
        return E;
    }


    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        if (!vertices.contains(v)) vertices.add(v);
        if (!vertices.contains(w)) vertices.add(w);
        edges[v].add(e);
        edges[w].add(e);
        E++;
    }

    public Iterable<Edge> edges(int v) { // return a set of v's edges
        return edges[v];
    }

}
/**
 * The {@code EdgeWeightedGraph} class represents an edge-weighted
 * graph of vertices named 0 through <em>V</em> – 1, where each
 * undirected edge is of type {@link Edge} and has a real-valued weight.
 * It supports the following two primary operations: add an edge to the graph,
 * iterate over all of the edges incident to a vertex. It also provides
 * methods for returning the number of vertices <em>V</em> and the number
 * of edges <em>E</em>. Parallel edges and self-loops are permitted.
 * By convention, a self-loop <em>v</em>-<em>v</em> appears in the
 * adjacency list of <em>v</em> twice and contributes two to the degree
 * of <em>v</em>.
 * <p>
 * This implementation uses an adjacency-lists representation, which
 * is a vertex-indexed array of  objects.
 * All operations take constant time (in the worst case) except
 * iterating over the edges incident to a given vertex, which takes
 * time proportional to the number of such edges.
 * <p>
 * For additional documentation,
 * see <a href="https://algs4.cs.princeton.edu/43mst">Section 4.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
