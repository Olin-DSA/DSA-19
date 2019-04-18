public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final int weight;

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }

    public int either() { // return one endpoint of the edge
        return v;
    }

    public int other(int vertex) { //return the other endpoint
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    public void print() {
        System.out.println(v + " connecting to " + w + " weighs " + weight);
    }

    @Override
    public int compareTo(Edge that) {
        return Integer.compare(this.weight, that.weight);
    }

}

/**
 * The {@code Edge} class represents a weighted edge in an
 * {@link EdgeWeightedGraph}. Each edge consists of two integers
 * (naming the two vertices) and a real-value weight. The data type
 * provides methods for accessing the two endpoints of the edge and
 * the weight. The natural order for this data type is by
 * ascending order of weight.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/43mst">Section 4.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */