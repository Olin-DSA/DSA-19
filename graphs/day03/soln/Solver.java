/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;

    /**
     * GIVEN except cost function and compareTo
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State implements Comparable<State>{
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves;
        public int cost;
        private State prev;

        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            // TODO: Compute cost of board state according to A*
            // Set to 0 for student code to replace
            cost = this.moves + board.manhattan();
        }

         /*
          * TODO
          * Return a negative integer, zero, or a positive integer as this state's cost is less than, equal to,
          * or greater than the specified state's cost.
          */
         @Override
         public int compareTo(State s) {
             if (this.cost == s.cost){
                 return s.moves - this.moves;
             }
             return this.cost - s.cost;
         }
        
        @Override
        public int hashCode() {
            return this.board.hashCode();
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }
    }

    /*
     * TODO
     * Return the root state of a given state
     */
    private State root(State state) {
        State current = state;
        while (current.prev != null) {
            current = current.prev;
        }
        return current;
    }

    /*
     * TODO
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */
    public Solver(Board initial) {
        Map<State, State> openSet = new HashMap<>();
        Map<State, State> closedSet = new HashMap<>();
        PriorityQueue<State> pq = new PriorityQueue<>(10);


        // Special case: null board input
        if (initial == null) throw new IllegalArgumentException("Initial board state was null");
        if (!initial.solvable()) return;

        // Create the initial state and insert on open set
        State initBoard = new State(initial, 0, null);
        openSet.put(initBoard, initBoard);
        pq.add(initBoard);

        while(!openSet.isEmpty()) {
            State current = pq.poll();
            openSet.remove(current);
            // Check if we've reached the solution
            if (current.board.isGoal()) {
                State root = root(current);
                if (!root.board.equals(initial)) break;
                solved = true;
                minMoves = current.moves;
                solutionState = current;
                // Found solution -> exit
                break;
            }

            Iterable<Board> neighbors = current.board.neighbors();
            for (Board neighbor : neighbors) {
                State neighborState = new State(neighbor, current.moves + 1, current);
                State openState = openSet.getOrDefault(neighbor, null);
                State closedState = closedSet.getOrDefault(neighbor, null);
                if (openState != null && neighborState.cost > openState.cost) continue;
                if (closedState != null && neighborState.cost > closedState.cost) continue;
                openSet.put(neighborState, neighborState);
                pq.add(neighborState);
            }

            closedSet.put(current, current);
        }
    }

    /*
     * TODO
     * Is the input board a solvable state
     */
    public boolean isSolvable() {
        return solved;
    }

    /*
     * TODO
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        if (isSolvable()) {
            Stack<Board> sol = new Stack<>();
            State current = solutionState;
            while (current != null) {
                sol.push(current.board);
                current = current.prev;
            }
            return sol;
        }
        return null;
    }

    /*
     * GIVEN
     * Debugging space: Your solution can have whatever output you find useful
     */
    public static void main(String[] args) {
        int[][] initState = {{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};
        Board initial = new Board(initState);

        // Solve the puzzle
        Solver solver = new Solver(initial);
        if (!solver.isSolvable())
            System.out.println("No solution");
        else {
            for (Board board : solver.solution()) {
                board.printBoard();
            }
            System.out.println(solver.minMoves);
        }
    }


}
