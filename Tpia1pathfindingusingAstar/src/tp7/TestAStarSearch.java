package tp7;

import java.util.ArrayList;

public class TestAStarSearch {
    public static void main(String[] args) {
        int[][] puzzle = {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}}; // The goal state
        int[][] start = {{2, 8, 3}, {1, 6, 4}, {7, 0, 5}}; // The initial state
        
        AStarSearch aStar = new AStarSearch(start, puzzle);
        aStar.runAStarSearch();
        
        ArrayList<Node> solutionPath = aStar.getSolutionPath();
        System.out.println("Solution path:");
        for (Node node : solutionPath) {
            System.out.println(node.toString());
        }
    }
}
