import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MCCCTest {

    @Test
    public void exampleCase() {
        EdgeWeightedGraph G = new EdgeWeightedGraph(4);
        int[] input = {0, 1, 3,
                0, 3, 1,
                0, 2, 5,
                1, 2, 4,
                2, 3, 7
        };
        int i = 0;
        while (i <= input.length - 3) {
            Edge newEdge = new Edge(input[i], input[i + 1], input[i + 2]);
            G.addEdge(newEdge);
            i = i + 3;
        }
        assertEquals(MCCR.MCCR(G), 8);
    }

    @Test
    public void case1() {
        EdgeWeightedGraph G = new EdgeWeightedGraph(8);
        int[] input = {0, 1, 7,
                0, 5, 10,
                0, 7, 15,
                1, 6, 9,
                1, 2, 12,
                1, 3, 5,
                3, 4, 14,
                3, 5, 8,
                4, 5, 3,
                2, 3, 6
        };
        int i = 0;
        while (i <= input.length - 3) {
            Edge newEdge = new Edge(input[i], input[i + 1], input[i + 2]);
            G.addEdge(newEdge);
            i = i + 3;
        }
        assertEquals(MCCR.MCCR(G), 53);
    }


    @Test
    public void case2() {
        EdgeWeightedGraph G = new EdgeWeightedGraph(8);
        int[] input = {0, 1, 8,
                0, 2, 4,
                0, 3, 8,
                0, 5, 11,
                0, 6, 14,
                1, 3, 12,
                1, 4, 17,
                1, 2, 10,
                3, 4, 5,
                3, 5, 13,
                5, 6, 6
        };
        int i = 0;
        while (i <= input.length - 3) {
            Edge newEdge = new Edge(input[i], input[i + 1], input[i + 2]);
            G.addEdge(newEdge);
            i = i + 3;
        }
        assertEquals(MCCR.MCCR(G), 42);
    }

    @Test
    public void case3() {
        EdgeWeightedGraph G = new EdgeWeightedGraph(8);
        int[] input = {0, 1, 1,
                1, 2, 100,
                2, 3, 1,
                0, 3, 1
        };
        int i = 0;
        while (i <= input.length - 3) {
            Edge newEdge = new Edge(input[i], input[i + 1], input[i + 2]);
            G.addEdge(newEdge);
            i = i + 3;
        }
        assertEquals(MCCR.MCCR(G), 3);
    }
}
